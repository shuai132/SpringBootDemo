package com.example.response.wrapper;

import com.example.utils.BeanUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageResult<T> {
    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("total_elems")
    private long totalElements;

    @JsonProperty("data")
    private List<T> data;

    public static <T> PageResult<T> of(Page<T> page) {
        return new PageResult<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
    }

    public static <T> PageResult<T> of(int totalPages, long totalElements, List<T> data) {
        return new PageResult<>(totalPages, totalElements, data);
    }

    public static <T, U> PageResult<T> of(Page<U> page, Function<U, T> converter) {
        return PageResult.of(
                page.getTotalPages(),
                page.getTotalElements(),
                page.getContent().stream().map(converter).collect(Collectors.toList())
        );
    }

    public static <T> PageResult<T> of(Page<?> page, Class<T> clazz) {
        return PageResult.of(page, item -> BeanUtils.convert(item, clazz));
    }
}
