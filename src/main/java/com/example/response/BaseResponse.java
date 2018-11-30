package com.example.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse<T> {
    @JsonProperty("data")
    private final T data;

    @JsonProperty("success")
    private final boolean success;

    @JsonProperty("error_msg")
    private final ErrorMsg errorMsg;

    private BaseResponse(T data) {
        this.data = data;
        this.errorMsg = null;
        this.success = true;
    }

    private BaseResponse(ErrorMsg errorMsg) {
        this.errorMsg = errorMsg;
        this.data = null;
        this.success = false;
    }

    public static <T> BaseResponse<T> create(T value) {
        return new BaseResponse<>(value);
    }

    public static <T> BaseResponse<T> create(ErrorMsg value) {
        return new BaseResponse<>(value);
    }
}
