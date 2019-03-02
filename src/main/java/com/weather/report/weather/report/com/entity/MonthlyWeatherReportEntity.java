package com.weather.report.weather.report.com.entity;

public class MonthlyWeatherReportEntity {
    Double monthlyLowestMinTemperature;
    Double monthlyHighestMaxTemperature;
    Double monthlyAveragePrecipitation;
    Double monthlyMedian2minWindSpeed;

    public Double getMonthlyLowestMinTemperature() {
        return monthlyLowestMinTemperature;
    }

    public void setMonthlyLowestMinTemperature(Double monthlyLowestMinTemperature) {
        this.monthlyLowestMinTemperature = monthlyLowestMinTemperature;
    }

    public Double getMonthlyHighestMaxTemperature() {
        return monthlyHighestMaxTemperature;
    }

    public void setMonthlyHighestMaxTemperature(Double monthlyHighestMaxTemperature) {
        this.monthlyHighestMaxTemperature = monthlyHighestMaxTemperature;
    }

    public Double getMonthlyAveragePrecipitation() {
        return monthlyAveragePrecipitation;
    }

    public void setMonthlyAveragePrecipitation(Double monthlyAveragePrecipitation) {
        this.monthlyAveragePrecipitation = monthlyAveragePrecipitation;
    }

    public Double getMonthlyMedian2minWindSpeed() {
        return monthlyMedian2minWindSpeed;
    }

    public void setMonthlyMedian2minWindSpeed(Double monthlyMedian2minWindSpeed) {
        this.monthlyMedian2minWindSpeed = monthlyMedian2minWindSpeed;
    }
}
