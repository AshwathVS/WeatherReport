package com.service;

import com.weather.report.weather.report.com.entity.WeatherEntity;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CSVtoMapReadService {
    private static Map<Date, WeatherEntity> weatherDataSet = new HashMap<>();

    public static String filePath = "/Users/ashwathvs/Downloads/weather.report/src/main/resources/rdu-weather-history.csv";

    public static boolean fillDataSet(){
        try {
            ICsvBeanReader beanReader;
            beanReader = new CsvBeanReader(new FileReader(filePath),
                    CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
            String[] header = beanReader.getHeader(true);
            WeatherEntity weatherEntity;
            while ((weatherEntity = beanReader.read(WeatherEntity.class, header, getProcessors())) != null) {
                weatherDataSet.put(weatherEntity.getDate(), weatherEntity);
            }
            return true;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static void main(String[] args){
        fillDataSet();
    }

    public static Map<Date, WeatherEntity> getWeatherDataSet() {
        return weatherDataSet;
    }

    public static CellProcessor[] getProcessors(){
        CellProcessor[] cellProcessors = new CellProcessor[]{
                new ParseDate("yyyy-MM-dd"),
                new Optional(new ParseDouble()),
                new Optional(new ParseDouble()),
                new Optional(new ParseDouble()),
                new Optional(new ParseDouble()),
                new Optional(new ParseDouble()),
                new Optional(new ParseDouble()),
                new Optional(new ParseDouble()),
                new Optional(new ParseDouble()),
                new Optional(new ParseDouble()),
                new Optional(new ParseDouble()),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No"),
                new ParseBool("Yes", "No")
        };
        return cellProcessors;
    }
}
