package com.weather.report.weather.report.com.entity;

import java.util.Date;

public class AllTimeWeatherReportEntity {
    String hottestDay;
    String coldestDay;
    String rainiestDay;
    String windiestDay;
    Date hottestDate;
    Date coldestDate;
    Date rainiestDate;
    Date windiestDate;
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

    public Date getColdestDate() {
        return coldestDate;
    }

    public void setColdestDate(Date coldestDate) {
        this.coldestDate = coldestDate;
    }

    public Date getRainiestDate() {
        return rainiestDate;
    }

    public void setRainiestDate(Date rainiestDate) {
        this.rainiestDate = rainiestDate;
    }

    public Date getWindiestDate() {
        return windiestDate;
    }

    public void setWindiestDate(Date windiestDate) {
        this.windiestDate = windiestDate;
    }

    public Date getHottestDate() {
        return hottestDate;
    }

    public void setHottestDate(Date hottestDate) {
        this.hottestDate = hottestDate;
    }
}
