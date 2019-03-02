package com.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDTO {
    private String message;
    private String description;

    public ErrorDTO(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public ErrorDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ErrorDTO getDefaultErrorDTO(String message, String description){
        return new ErrorDTO(message, description);
    }
}
