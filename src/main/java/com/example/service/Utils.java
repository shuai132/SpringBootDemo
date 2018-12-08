package com.example.service;

import com.example.utils.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

public final class Utils {
    /**
     * 根据param属性patch到id对应的数据
     * 注意: 不支持含有嵌套的属性
     */
    public static <T, ID> T patchById(JpaRepository<T, ID> repository, ID id, Object param) {
        var table = repository.getOne(id);
        BeanUtils.copyNotNullProperties(param, table);
        repository.flush();
        return table;
    }

    public static <T, ID> ID deleteById(JpaRepository<T, ID> repository, ID id) {
        repository.deleteById(id);
        return id;
    }
}
