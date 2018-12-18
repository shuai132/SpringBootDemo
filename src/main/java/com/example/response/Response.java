package com.example.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    @JsonProperty("data")
    private final T data;

    @JsonProperty("success")
    private final boolean success;

    @JsonProperty("error_msg")
    private final ErrorMsg errorMsg;

    private Response(T data) {
        this.data = data;
        this.errorMsg = null;
        this.success = true;
    }

    private Response(ErrorMsg errorMsg) {
        this.errorMsg = errorMsg;
        this.data = null;
        this.success = false;
    }

    public static <T> Response<T> of(T value) {
        return new Response<>(value);
    }

    public static <T> Response<T> of(ErrorMsg value) {
        return new Response<>(value);
    }

    public static Response<String> ok() {
        return new Response<>("ok");
    }

    public static <T> Response<T> error(String errorMsg) {
        return new Response<>(ErrorMsg.of(errorMsg));
    }

    public static <T> T threwError(String msg) throws RuntimeException {
        throw new RespException(msg);
    }

    public static class RespException extends RuntimeException {
        public RespException() {
            super();
        }
        public RespException(String msg) {
            super(msg);
        }
    }
}
