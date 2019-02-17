package com.weather.report.weather.report.com.entity;

public class AllTimeWeatherReportEntity {
    String hottestDay;
    String coldestDay;
    String rainiestDay;
    String windiestDay;
    double averageWindSpeed;

    public String getHottestDay() {
        return hottestDay;
    }

    public void setHottestDay(String hottestDay) {
        this.hottestDay = hottestDay;
    }

    public String getColdestDay() {
        return coldestDay;
    }

    public void setColdestDay(String coldestDay) {
        this.coldestDay = coldestDay;
    }

    public String getRainiestDay() {
        return rainiestDay;
    }

    public void setRainiestDay(String rainiestDay) {
        this.rainiestDay = rainiestDay;
    }

    public String getWindiestDay() {
        return windiestDay;
    }

    public void setWindiestDay(String windiestDay) {
        this.windiestDay = windiestDay;
    }

    public double getAverageWindSpeed() {
        return averageWindSpeed;
    }

    public void setAverageWindSpeed(double averageWindSpeed) {
        this.averageWindSpeed = averageWindSpeed;
    }
}
