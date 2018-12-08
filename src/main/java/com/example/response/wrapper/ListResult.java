package com.example.response.wrapper;

import com.example.utils.BeanUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class ListResult<T> {
    @JsonProperty("data")
    private List<T> data;

    @JsonProperty("count")
    private int count;

    public static <T> ListResult<T> of(List<T> data) {
        return new ListResult<>(data, data.size());
    }

    public static <T> ListResult<T> of(List<?> data, Class<T> clazz) {
        return ListResult.of(BeanUtils.convertList(data, clazz));
    }
}
