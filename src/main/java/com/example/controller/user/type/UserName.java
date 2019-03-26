package com.example.controller.user.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserName {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;
}
