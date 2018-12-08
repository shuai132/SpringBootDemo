package com.example.service.user;

import com.example.controller.user.type.UserName;
import com.example.response.Response;
import com.example.controller.user.type.UserParam;
import com.example.db.entity.UserTable;
import com.example.response.wrapper.ListResult;
import com.example.response.wrapper.PageResult;

public interface IUserService {
    Response<UserTable> getById(Long id);

    Response<PageResult<UserTable>> getPage(int page, int size);

    Response<Long> add(UserParam param);

    Response<Long> delete(Long id);

    Response<Long> patch(Long id, UserParam param);

    Response<ListResult<UserName>> list();
}
