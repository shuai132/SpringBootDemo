package com.example.controller.user.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserParam {
    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private Integer age;
}
