package com.example.response.wrapper;

import com.example.utils.BeanUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class ListResult<T> {
    @JsonProperty("data")
    private List<T> data;

    @JsonProperty("count")
    private int count;

    public static <T> ListResult<T> of(List<T> data) {
        return new ListResult<>(data, data.size());
    }

    public static <T, U> ListResult<T> of(List<U> data, Function<U, T> converter) {
        return ListResult.of(data.stream().map(converter).collect(Collectors.toList()));
    }

    public static <T> ListResult<T> of(List<?> data, Class<T> clazz) {
        return ListResult.of(data, item -> BeanUtils.convert(item, clazz));
    }
}
