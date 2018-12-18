package com.example.service.user;

import com.example.controller.user.type.UserName;
import com.example.controller.user.type.UserParam;
import com.example.db.dao.IUserRepository;
import com.example.db.entity.UserTable;
import com.example.response.wrapper.ListResult;
import com.example.response.wrapper.PageResult;
import com.example.service.Utils;
import com.example.utils.BeanUtils;
import com.example.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserTable getById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public PageResult<UserTable> getPage(int page, int size){
        var result = userRepository.findAll(PageRequest.of(page, size));
        return PageResult.of(result);
    }

    @Override
    public Long add(UserParam param){
        var userTable = BeanUtils.convert(param, UserTable.class);
        userTable.setCreateAt(TimeUtils.nowTimestamp());
        return userRepository.save(userTable).getId();
    }

    @Override
    public Long delete(Long id){
        return Utils.deleteById(userRepository, id);
    }

    @Override
    public Long patch(Long id, UserParam param) {
        return Utils.patchById(userRepository, id, param).getId();
    }

    @Override
    public ListResult<UserName> list() {
        var result = userRepository.findAll();
        return ListResult.of(result, UserName.class);
    }
}
