package com.controller;

import com.response.ErrorDTO;
import com.response.GenericResponse;
import com.service.WeatherService;
import com.weather.report.weather.report.com.entity.AllTimeWeatherReportEntity;
import com.weather.report.weather.report.com.entity.MonthlyWeatherReportEntity;
import com.weather.report.weather.report.com.entity.WeatherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.IllegalFormatException;

@Controller
@RequestMapping("/weather")
public class WeatherController {
    private static final String PARAM_FORMAT = "yyyy-MM-dd";

    WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/weatherByDate")
    public ResponseEntity<GenericResponse> getWeatherDataByDate(@RequestParam("date") @DateTimeFormat(pattern = PARAM_FORMAT) Date date){
        try{
            WeatherEntity weatherEntity = weatherService.getWeatherEntityByDate(date);
            return new ResponseEntity<>(new GenericResponse<>(weatherEntity, null), HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(new GenericResponse(null, ErrorDTO.getDefaultErrorDTO("EXCEPTION!", ex.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/closestWeatherByDate")
    public ResponseEntity<GenericResponse> getClosestWeatherReport(@RequestParam("date") @DateTimeFormat(pattern = PARAM_FORMAT) Date date){
        try{
            WeatherEntity weatherEntity = weatherService.getClosestWeatherEntityByDate(date);
            return new ResponseEntity<>(new GenericResponse<>(weatherEntity, null), HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(new GenericResponse(null, ErrorDTO.getDefaultErrorDTO("EXCEPTION!", ex.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/allTimeWeatherReport")
    public ResponseEntity<GenericResponse> getAllTimeWeatherReport(){
        try{
            AllTimeWeatherReportEntity allTimeWeatherReportEntity = weatherService.getAllTimeWeatherReport();
            return new ResponseEntity<>(new GenericResponse<>(allTimeWeatherReportEntity, null), HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(new GenericResponse(null, ErrorDTO.getDefaultErrorDTO("EXCEPTION!", ex.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/monthlyWeatherReport")
    public ResponseEntity<GenericResponse> getMonthlyReport(@RequestParam("date") String date){
        try{
            validateDateString(date);
            MonthlyWeatherReportEntity monthlyWeatherReportEntity = weatherService.getMonthlyReport(date);
            return new ResponseEntity<>(new GenericResponse<>(monthlyWeatherReportEntity, null), HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(new GenericResponse(null, ErrorDTO.getDefaultErrorDTO(ex.getClass().getName(), ex.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }

    private void validateDateString(String date) throws NumberFormatException, IllegalArgumentException{
        if(!date.contains("/")){
            throw new IllegalArgumentException("Input must be of format MM/YYYY.");
        }
        else{
            String[] splitDate = date.split("/");
            Long month = Long.parseLong(splitDate[0]);
            if(month > 12 || month <= 0){
                throw new IllegalArgumentException("Month value Invalid");
            }
            Long.parseLong(splitDate[1]);
        }
    }


}
