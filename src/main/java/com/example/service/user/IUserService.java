package com.example.service.user;

import com.example.response.BaseResponse;
import com.example.controller.user.type.User;
import com.example.controller.user.type.UserTablePage;
import com.example.db.entity.UserTable;

public interface IUserService {
    BaseResponse<UserTable> getUserById(Long id);

    BaseResponse<UserTablePage> getUsers(int page, int size);

    BaseResponse<Long> addUser(User user);

    BaseResponse<Long> deleteUser(Long id);
}
