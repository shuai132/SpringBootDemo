package com.example.service.user.impl;

import com.example.response.ErrorMsg;

public interface Const {
    ErrorMsg FIND_ERROR = new ErrorMsg(0, "查询失败");
    ErrorMsg SAVE_ERROR = new ErrorMsg(1, "保存失败");
    ErrorMsg DELETE_ERROR = new ErrorMsg(2, "删除失败");
}
