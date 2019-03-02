package com.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericResponse<T> {
    private T data;
    @JsonProperty("error")
    private ErrorDTO errorDTO;

    public GenericResponse(T data, ErrorDTO errorDTO) {
        this.data = data;
        this.errorDTO = errorDTO;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorDTO getErrorDTO() {
        return errorDTO;
    }

    public void setErrorDTO(ErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
    }
}
