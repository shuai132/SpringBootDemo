package com.example.service;

import com.example.response.BaseResponse;
import com.example.response.ErrorMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.function.Supplier;

@Service
public final class ExceptionHelper {
    private Logger logger;

    public ExceptionHelper() {
        logger = LoggerFactory.getLogger(ExceptionHelper.class);
    }

    public ExceptionHelper(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public ExceptionHelper(Logger logger) {
        this.logger = logger;
    }

    public <T> BaseResponse<T> handle(Supplier<T> result, @Nullable ErrorMsg errorMsg) {
        try {
            T t = result.get();
            return BaseResponse.create(t);
        } catch (Exception e) {
            logger.error(e.toString(), e);
            return BaseResponse.create(errorMsg != null ? errorMsg : new ErrorMsg(0, "no message set!"));
        }
    }

    public <T> BaseResponse<T> handle(Supplier<T> result) {
        return handle(result, null);
    }
}