package com.example.controller.user.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserParam {
    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private Integer age;
}
