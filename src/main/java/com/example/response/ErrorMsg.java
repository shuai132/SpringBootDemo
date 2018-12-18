package com.example.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMsg {
    @JsonProperty("code")
    private final int code;

    @JsonProperty("message")
    private final String message;

    public static ErrorMsg of(int code, String message) {
        return new ErrorMsg(code, message);
    }

    public static ErrorMsg of(String message) {
        return new ErrorMsg(0, message);
    }
}
