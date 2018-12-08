package com.example.controller.user;

import com.example.controller.user.type.UserName;
import com.example.db.entity.UserTable;
import com.example.response.Response;
import com.example.response.wrapper.ListResult;
import com.example.response.wrapper.PageResult;
import com.example.service.user.IUserService;
import com.example.controller.user.type.UserParam;
import com.example.utils.Const;
import com.example.utils.ParamUtils;
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
    @ApiOperation("通过id获取")
    public Response<UserTable> getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping
    @ApiOperation("分页获取")
    public Response<PageResult<UserTable>> getPage(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "20") int size){
        return userService.getPage(page, size);
    }

    @PostMapping
    @ApiOperation("添加")
    public Response<Long> post(@RequestBody UserParam param){
        return userService.add(param);
    }

    @PutMapping("/{id}")
    @ApiOperation("修改")
    public Response<Long> put(@PathVariable Long id, @RequestBody UserParam param) {
        if (ParamUtils.hasNullProperty(param)) {
            return Response.error(Const.MSG_INCOMPLETE_PARAM);
        }
        return userService.patch(id, param);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public Response<Long> deleteUser(@PathVariable Long id){
        return userService.delete(id);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列出所有")
    public Response<ListResult<UserName>> list(){
        return userService.list();
    }
}
