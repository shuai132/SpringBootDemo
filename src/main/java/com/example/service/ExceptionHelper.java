package com.example.service;

import com.example.response.Response;
import com.example.response.ErrorMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.function.Supplier;

@Service
public final class ExceptionHelper {
    public Logger logger;

    public ExceptionHelper() {
        logger = LoggerFactory.getLogger(ExceptionHelper.class);
    }

    public ExceptionHelper(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public ExceptionHelper(Logger logger) {
        this.logger = logger;
    }

    public <T> Response<T> handle(Supplier<T> result, @Nullable ErrorMsg errorMsg) {
        try {
            T t = result.get();
            return Response.of(t);
        } catch (Response.RespException e){
            logger.error(e.getMessage());
            return Response.error(e.getMessage());
        } catch (Exception e) {
            logger.error(e.toString(), e);
            return Response.of(errorMsg != null ? errorMsg : ErrorMsg.of(e.getMessage()));
        }
    }

    public <T> Response<T> handle(Supplier<T> result) {
        return handle(result, null);
    }
}