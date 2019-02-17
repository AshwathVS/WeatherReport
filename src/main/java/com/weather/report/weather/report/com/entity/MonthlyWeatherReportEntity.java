package com.weather.report.weather.report.com.entity;

public class MonthlyWeatherReportEntity {
    Double monthlyLowestMinTemperature;
    Double monthlyHighestMaxTemperature;
    Double monthlyAveragePrecipitation;
    Double monthlyModeWindDirection;
    Double monthlyMedian2minWindSpeed;
    Double monthlyPercentageOfRainyDays;
    int monthlyNumberOfFoggyDays;
    Double wasThereAtleaseOneSmokeHazardDay;

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

    public Double getMonthlyModeWindDirection() {
        return monthlyModeWindDirection;
    }

    public void setMonthlyModeWindDirection(Double monthlyModeWindDirection) {
        this.monthlyModeWindDirection = monthlyModeWindDirection;
    }

    public Double getMonthlyMedian2minWindSpeed() {
        return monthlyMedian2minWindSpeed;
    }

    public void setMonthlyMedian2minWindSpeed(Double monthlyMedian2minWindSpeed) {
        this.monthlyMedian2minWindSpeed = monthlyMedian2minWindSpeed;
    }

    public Double getMonthlyPercentageOfRainyDays() {
        return monthlyPercentageOfRainyDays;
    }

    public void setMonthlyPercentageOfRainyDays(Double monthlyPercentageOfRainyDays) {
        this.monthlyPercentageOfRainyDays = monthlyPercentageOfRainyDays;
    }

    public int getMonthlyNumberOfFoggyDays() {
        return monthlyNumberOfFoggyDays;
    }

    public void setMonthlyNumberOfFoggyDays(int monthlyNumberOfFoggyDays) {
        this.monthlyNumberOfFoggyDays = monthlyNumberOfFoggyDays;
    }

    public Double getWasThereAtleaseOneSmokeHazardDay() {
        return wasThereAtleaseOneSmokeHazardDay;
    }

    public void setWasThereAtleaseOneSmokeHazardDay(Double wasThereAtleaseOneSmokeHazardDay) {
        this.wasThereAtleaseOneSmokeHazardDay = wasThereAtleaseOneSmokeHazardDay;
    }
}
