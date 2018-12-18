package com.example.service.user;

import com.example.controller.user.type.UserName;
import com.example.controller.user.type.UserParam;
import com.example.db.entity.UserTable;
import com.example.response.wrapper.ListResult;
import com.example.response.wrapper.PageResult;

public interface IUserService {
    UserTable getById(Long id);

    PageResult<UserTable> getPage(int page, int size);

    Long add(UserParam param);

    Long delete(Long id);

    Long patch(Long id, UserParam param);

    ListResult<UserName> list();
}
