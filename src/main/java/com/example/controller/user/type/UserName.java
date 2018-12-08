package com.example.controller.user.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserName {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;
}
