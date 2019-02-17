package com.service;

import com.weather.report.weather.report.com.entity.AllTimeWeatherReportEntity;
import com.weather.report.weather.report.com.entity.MonthlyWeatherReportEntity;
import com.weather.report.weather.report.com.entity.WeatherEntity;

import java.util.Date;

public interface WeatherService {
    WeatherEntity getWeatherEntityByDate(Date date);
    WeatherEntity getClosestWeatherEntityByDate(Date date);
    AllTimeWeatherReportEntity getAllTimeWeatherReport();
    MonthlyWeatherReportEntity getMonthyReport(String date);
}
