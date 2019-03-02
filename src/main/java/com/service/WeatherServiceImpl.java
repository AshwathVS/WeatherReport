package com.service;

import com.weather.report.weather.report.com.entity.AllTimeWeatherReportEntity;
import com.weather.report.weather.report.com.entity.MonthlyWeatherReportEntity;
import com.weather.report.weather.report.com.entity.WeatherEntity;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Override
    public WeatherEntity getWeatherEntityByDate(Date date) {
        Map<Date, WeatherEntity> weatherEntityMap = CSVtoMapReadService.getWeatherDataSet();
        return weatherEntityMap.get(date);
    }

    @Override
    public WeatherEntity getClosestWeatherEntityByDate(Date date) {
        Map<Date, WeatherEntity> weatherEntityMap = CSVtoMapReadService.getWeatherDataSet();
        if(weatherEntityMap.containsKey(date)){
            return weatherEntityMap.get(date);
        }
        else {
            if(date.compareTo(CSVtoMapReadService.getMaxEntry()) > 0)
            {
                return weatherEntityMap.get(CSVtoMapReadService.getMaxEntry());
            }
            else if(date.compareTo(CSVtoMapReadService.getMinEntry()) < 0){
                return weatherEntityMap.get(CSVtoMapReadService.getMinEntry());
            }
            else {
                Map<Date, Long> findDifferences = new HashMap<>(10);
                weatherEntityMap.entrySet().forEach(dateWeatherEntityEntry -> findDifferences.put(dateWeatherEntityEntry.getKey(),
                        dateWeatherEntityEntry.getKey().getTime() - date.getTime()));
                Map.Entry<Date, Long> min = Collections.min(findDifferences.entrySet(), new Comparator<Map.Entry<Date, Long>>() {
                    public int compare(Map.Entry<Date, Long> entry1, Map.Entry<Date, Long> entry2) {
                        return Long.compare(Math.abs(entry1.getValue()), Math.abs(entry2.getValue()));
                    }
                });
                return weatherEntityMap.get(min.getKey());
            }
        }
    }

    @Override
    public AllTimeWeatherReportEntity getAllTimeWeatherReport() {
        Map<Date, WeatherEntity> weatherEntityMap = CSVtoMapReadService.getWeatherDataSet();
        AllTimeWeatherReportEntity allTimeWeatherReportEntity = new AllTimeWeatherReportEntity();
        Double avgWeatherSpeed = weatherEntityMap.values().stream().mapToDouble((entity) -> entity.getAvgwindspeed()).sum() / weatherEntityMap.size();
        allTimeWeatherReportEntity.setAverageWindSpeed(Double.valueOf(new DecimalFormat("#.##").format(avgWeatherSpeed)));
        Date coldestDate = weatherEntityMap.entrySet().stream().min((entity1, entity2) -> entity1.getValue().getTemperaturemin() > entity2.getValue().getTemperaturemin() ? 1 : -1).get().getKey();
        Date hottestDate = weatherEntityMap.entrySet().stream().min((entity1, entity2) -> entity1.getValue().getTemperaturemax() > entity2.getValue().getTemperaturemax() ? 1 : -1).get().getKey();
        Date rainiestDate = weatherEntityMap.entrySet().stream().min((entity1, entity2) -> entity1.getValue().getPrecipitation() > entity2.getValue().getPrecipitation() ? 1 : -1).get().getKey();
        Date windiestDate = weatherEntityMap.entrySet().stream().min((entity1, entity2) -> entity1.getValue().getAvgwindspeed() > entity2.getValue().getAvgwindspeed() ? 1 : -1).get().getKey();
        allTimeWeatherReportEntity.setColdestDay(DayOfWeek.of(coldestDate.getDay() + 1).name());
        allTimeWeatherReportEntity.setHottestDay(DayOfWeek.of(hottestDate.getDay() + 1).name());
        allTimeWeatherReportEntity.setRainiestDay(DayOfWeek.of(rainiestDate.getDay() + 1).name());
        allTimeWeatherReportEntity.setWindiestDay(DayOfWeek.of(windiestDate.getDay() + 1).name());
        allTimeWeatherReportEntity.setColdestDate(coldestDate);
        allTimeWeatherReportEntity.setHottestDate(hottestDate);
        allTimeWeatherReportEntity.setWindiestDate(windiestDate);
        allTimeWeatherReportEntity.setRainiestDate(rainiestDate);
        return allTimeWeatherReportEntity;
    }

    @Override
    public MonthlyWeatherReportEntity getMonthlyReport(String date) {
        Map<Date, WeatherEntity> weatherEntityMap = CSVtoMapReadService.getWeatherDataSet();
        MonthlyWeatherReportEntity monthlyWeatherReportEntity = new MonthlyWeatherReportEntity();
        Predicate<Map.Entry<Date, WeatherEntity>> datePredicate = (entry) -> DateFormatUtils.format(entry.getValue().getDate(), "MM/YYYY").equals(date);

        /**Avg Monthly Precipitation**/
        DoubleStream monthlyPrecipitationStream = weatherEntityMap.entrySet().stream().filter(datePredicate).mapToDouble(entity -> entity.getValue().getPrecipitation());
        Double totalMonthlyPrecipitation = monthlyPrecipitationStream.sum();
        Long totalEntries = weatherEntityMap.entrySet().stream().filter(datePredicate).mapToDouble(entity -> entity.getValue().getPrecipitation()).count();
        monthlyWeatherReportEntity.setMonthlyAveragePrecipitation(totalMonthlyPrecipitation / totalEntries);

        /****/
        OptionalDouble maxHighest = weatherEntityMap.entrySet().stream().filter(datePredicate).mapToDouble(entry -> entry.getValue().getTemperaturemax()).max();
        monthlyWeatherReportEntity.setMonthlyHighestMaxTemperature(maxHighest.getAsDouble());

        /****/
        OptionalDouble minHighest = weatherEntityMap.entrySet().stream().filter(datePredicate).mapToDouble(entry -> entry.getValue().getTemperaturemax()).min();
        monthlyWeatherReportEntity.setMonthlyLowestMinTemperature(minHighest.getAsDouble());

        /****/
        Stream<Map.Entry<Date, WeatherEntity> > stream = weatherEntityMap.entrySet().stream().filter(datePredicate).sorted((entity1, entity2) -> entity1.getValue().getFastest2minwindspeed() < entity2.getValue().getFastest2minwindspeed() ? 1 : -1);
        int streamLength = weatherEntityMap.entrySet().stream().filter(datePredicate).sorted((entity1, entity2) -> entity1.getValue().getFastest2minwindspeed() < entity2.getValue().getFastest2minwindspeed() ? 1 : -1).toArray().length;
        if(streamLength == 0){
            return null;
        }
        else if (streamLength == 1){
            Map.Entry<Date, WeatherEntity> entityEntry = (Map.Entry<Date, WeatherEntity>)stream.toArray()[0];
            monthlyWeatherReportEntity.setMonthlyMedian2minWindSpeed(entityEntry.getValue().getFastest2minwindspeed());
        }
        else if(streamLength % 2 == 0){
            Map.Entry<Date, WeatherEntity> entityEntry = (Map.Entry<Date, WeatherEntity>)stream.toArray()[streamLength / 2];
            monthlyWeatherReportEntity.setMonthlyMedian2minWindSpeed(entityEntry.getValue().getFastest2minwindspeed());
        }
        else {
            Map.Entry<Date, WeatherEntity> entityEntry = (Map.Entry<Date, WeatherEntity>)stream.toArray()[streamLength / 2 + 1];
            monthlyWeatherReportEntity.setMonthlyMedian2minWindSpeed(entityEntry.getValue().getFastest2minwindspeed());
        }


        return monthlyWeatherReportEntity;
    }
}
