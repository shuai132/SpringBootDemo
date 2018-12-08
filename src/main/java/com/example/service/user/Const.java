package com.example.service.user;

import com.example.response.ErrorMsg;

public interface Const {
    ErrorMsg FIND_ERROR = ErrorMsg.of(0, "查询失败");
    ErrorMsg SAVE_ERROR = ErrorMsg.of(1, "保存失败");
    ErrorMsg DELETE_ERROR = ErrorMsg.of(2, "删除失败");
}
