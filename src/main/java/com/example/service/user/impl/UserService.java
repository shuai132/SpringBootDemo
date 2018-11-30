package com.example.service.user.impl;

import com.example.controller.user.type.User;
import com.example.controller.user.type.UserTablePage;
import com.example.db.dao.IUserRepository;
import com.example.db.entity.UserTable;
import com.example.response.BaseResponse;
import com.example.service.ExceptionHelper;
import com.example.service.user.IUserService;
import com.example.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private static final ExceptionHelper helper = new ExceptionHelper(UserService.class);

    @Autowired
    private IUserRepository userRepository;

    @Override
    public BaseResponse<UserTable> getUserById(Long id){
        return helper.handle(() -> {
            return userRepository.findById(id).orElse(null);
        }, Const.FIND_ERROR);
    }

    @Override
    public BaseResponse<UserTablePage> getUsers(int page, int size){
        return helper.handle(() -> {
            var p = userRepository.findAll(PageRequest.of(page, size));
            var userTablePage = new UserTablePage();
            userTablePage.totalPages = p.getTotalPages();
            userTablePage.totalElements = p.getTotalElements();
            userTablePage.users = p.getContent();
            return userTablePage;
        }, Const.FIND_ERROR);
    }

    @Override
    public BaseResponse<Long> addUser(User user){
        return helper.handle(() -> {
            var userTable = new UserTable();
            userTable.setName(user.name);
            userTable.setCreateAt(TimeUtils.nowTimestamp());
            var result = userRepository.save(userTable);
            return result.getId();
        }, Const.SAVE_ERROR);
    }

    @Override
    public BaseResponse<Long> deleteUser(Long id){
        return helper.handle(() -> {
            userRepository.deleteById(id);
            return id;
        }, Const.DELETE_ERROR);
    }
}
