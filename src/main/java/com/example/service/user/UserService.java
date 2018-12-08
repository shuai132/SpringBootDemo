package com.example.service.user;

import com.example.controller.user.type.UserName;
import com.example.controller.user.type.UserParam;
import com.example.db.dao.IUserRepository;
import com.example.db.entity.UserTable;
import com.example.response.Response;
import com.example.response.wrapper.ListResult;
import com.example.response.wrapper.PageResult;
import com.example.service.ExceptionHelper;
import com.example.service.Utils;
import com.example.utils.BeanUtils;
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
    public Response<UserTable> getById(Long id){
        return helper.handle(() -> userRepository.findById(id).orElse(null), Const.FIND_ERROR);
    }

    @Override
    public Response<PageResult<UserTable>> getPage(int page, int size){
        return helper.handle(() -> {
            var result = userRepository.findAll(PageRequest.of(page, size));
            return PageResult.of(result);
        }, Const.FIND_ERROR);
    }

    @Override
    public Response<Long> add(UserParam param){
        return helper.handle(() -> {
            var userTable = BeanUtils.convert(param, UserTable.class);
            userTable.setCreateAt(TimeUtils.nowTimestamp());
            return userRepository.save(userTable).getId();
        }, Const.SAVE_ERROR);
    }

    @Override
    public Response<Long> delete(Long id){
        return helper.handle(() -> Utils.deleteById(userRepository, id), Const.DELETE_ERROR);
    }

    @Override
    public Response<Long> patch(Long id, UserParam param) {
        return helper.handle(() -> Utils.patchById(userRepository, id, param).getId());
    }

    @Override
    public Response<ListResult<UserName>> list() {
        return helper.handle(() -> {
            var result = userRepository.findAll();
            return ListResult.of(result, UserName.class);
        });
    }
}
