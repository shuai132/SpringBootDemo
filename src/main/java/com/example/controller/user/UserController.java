package com.example.controller.user;

import com.example.controller.user.type.UserTablePage;
import com.example.db.entity.UserTable;
import com.example.response.BaseResponse;
import com.example.service.user.IUserService;
import com.example.controller.user.type.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Api(value = "用户管理")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    @ApiOperation("通过id查找用户")
    public BaseResponse<UserTable> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    @ApiOperation("查询用户")
    public BaseResponse<UserTablePage> getUsers(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "20") int size){
        return userService.getUsers(page, size);
    }

    @PostMapping
    @ApiOperation("添加用户")
    public BaseResponse<Long> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户")
    public BaseResponse<Long> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
