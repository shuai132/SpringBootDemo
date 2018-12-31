package com.example.controller.base;

import com.example.service.ExceptionHelper;

public abstract class BaseController {
    protected ExceptionHelper helper = new ExceptionHelper(this.getClass());
}
