package com.weather.report.weather.report.com.entity;

import java.util.Date;

public class WeatherEntity {
    private Date date;
    private double temperaturemin;
    private double temperaturemax;
    private double precipitation;
    private double snowfall;
    private double snowdepth;
    private double avgwindspeed;
    private double fastest2minwinddir;
    private double fastest2minwindspeed;
    private double fastest5secwinddir;
    private double fastest5secwindspeed;
    private boolean fog;
    private boolean fogheavy;
    private boolean mist;
    private boolean rain;
    private boolean fogground;
    private boolean ice;
    private boolean glaze;
    private boolean drizzle;
    private boolean snow;
    private boolean freezingRain;
    private boolean smokeHaze;
    private boolean thunder;
    private boolean highWind;
    private boolean hail;
    private boolean blowingSnow;
    private boolean dust;
    private boolean freezingfog;

    @Override
    public String toString() {
        return "WeatherEntity{" +
                "date=" + date +
                ", temperaturemin=" + temperaturemin +
                ", temperaturemax=" + temperaturemax +
                ", precipiation=" + precipitation +
                ", snowfall=" + snowfall +
                ", snowdepth=" + snowdepth +
                ", avgwindspeed=" + avgwindspeed +
                ", fastest2minwinddir=" + fastest2minwinddir +
                ", fastest2minwindspeed=" + fastest2minwindspeed +
                ", fastest5secwinddir=" + fastest5secwinddir +
                ", fastest5secwindspeed=" + fastest5secwindspeed +
                ", fog=" + fog +
                ", fogheavy=" + fogheavy +
                ", mist=" + mist +
                ", rain=" + rain +
                ", fogground=" + fogground +
                ", ice=" + ice +
                ", glaze=" + glaze +
                ", drizzle=" + drizzle +
                ", snow=" + snow +
                ", freezingRain=" + freezingRain +
                ", smokeHaze=" + smokeHaze +
                ", thunder=" + thunder +
                ", highWind=" + highWind +
                ", hail=" + hail +
                ", blowingSnow=" + blowingSnow +
                ", dust=" + dust +
                ", freezingfog=" + freezingfog +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTemperaturemin() {
        return temperaturemin;
    }

    public void setTemperaturemin(double temperaturemin) {
        this.temperaturemin = temperaturemin;
    }

    public double getTemperaturemax() {
        return temperaturemax;
    }

    public void setTemperaturemax(double temperaturemax) {
        this.temperaturemax = temperaturemax;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getSnowfall() {
        return snowfall;
    }

    public void setSnowfall(double snowfall) {
        this.snowfall = snowfall;
    }

    public double getSnowdepth() {
        return snowdepth;
    }

    public void setSnowdepth(double snowdepth) {
        this.snowdepth = snowdepth;
    }

    public double getAvgwindspeed() {
        return avgwindspeed;
    }

    public void setAvgwindspeed(double avgwindspeed) {
        this.avgwindspeed = avgwindspeed;
    }

    public double getFastest2minwinddir() {
        return fastest2minwinddir;
    }

    public void setFastest2minwinddir(double fastest2minwinddir) {
        this.fastest2minwinddir = fastest2minwinddir;
    }

    public double getFastest2minwindspeed() {
        return fastest2minwindspeed;
    }

    public void setFastest2minwindspeed(double fastest2minwindspeed) {
        this.fastest2minwindspeed = fastest2minwindspeed;
    }

    public double getFastest5secwinddir() {
        return fastest5secwinddir;
    }

    public void setFastest5secwinddir(double fastest5secwinddir) {
        this.fastest5secwinddir = fastest5secwinddir;
    }

    public double getFastest5secwindspeed() {
        return fastest5secwindspeed;
    }

    public void setFastest5secwindspeed(double fastest5secwindspeed) {
        this.fastest5secwindspeed = fastest5secwindspeed;
    }

    public boolean isFog() {
        return fog;
    }

    public void setFog(boolean fog) {
        this.fog = fog;
    }

    public boolean isFogheavy() {
        return fogheavy;
    }

    public void setFogheavy(boolean fogheavy) {
        this.fogheavy = fogheavy;
    }

    public boolean isMist() {
        return mist;
    }

    public void setMist(boolean mist) {
        this.mist = mist;
    }

    public boolean isRain() {
        return rain;
    }

    public void setRain(boolean rain) {
        this.rain = rain;
    }

    public boolean isFogground() {
        return fogground;
    }

    public void setFogground(boolean fogground) {
        this.fogground = fogground;
    }

    public boolean isIce() {
        return ice;
    }

    public void setIce(boolean ice) {
        this.ice = ice;
    }

    public boolean isGlaze() {
        return glaze;
    }

    public void setGlaze(boolean glaze) {
        this.glaze = glaze;
    }

    public boolean isDrizzle() {
        return drizzle;
    }

    public void setDrizzle(boolean drizzle) {
        this.drizzle = drizzle;
    }

    public boolean isSnow() {
        return snow;
    }

    public void setSnow(boolean snow) {
        this.snow = snow;
    }

    public boolean isFreezingRain() {
        return freezingRain;
    }

    public void setFreezingRain(boolean freezingRain) {
        this.freezingRain = freezingRain;
    }

    public boolean isSmokeHaze() {
        return smokeHaze;
    }

    public void setSmokeHaze(boolean smokeHaze) {
        this.smokeHaze = smokeHaze;
    }

    public boolean isThunder() {
        return thunder;
    }

    public void setThunder(boolean thunder) {
        this.thunder = thunder;
    }

    public boolean isHighWind() {
        return highWind;
    }

    public void setHighWind(boolean highWind) {
        this.highWind = highWind;
    }

    public boolean isHail() {
        return hail;
    }

    public void setHail(boolean hail) {
        this.hail = hail;
    }

    public boolean isBlowingSnow() {
        return blowingSnow;
    }

    public void setBlowingSnow(boolean blowingSnow) {
        this.blowingSnow = blowingSnow;
    }

    public boolean isDust() {
        return dust;
    }

    public void setDust(boolean dust) {
        this.dust = dust;
    }

    public boolean isFreezingfog() {
        return freezingfog;
    }

    public void setFreezingfog(boolean freezingfog) {
        this.freezingfog = freezingfog;
    }
}
