package com.example.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMsg {
    @JsonProperty("code")
    private final int code;

    @JsonProperty("message")
    private final String message;

    public ErrorMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
