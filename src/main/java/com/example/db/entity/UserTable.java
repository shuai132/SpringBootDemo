package com.example.db.entity;

import com.example.utils.Const;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "user")
@Getter
@Setter
public class UserTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(nullable = false)
    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private Integer age;

    @Column
    @ApiModelProperty(example = Const.DATETIME_EXAMPLE)
    @JsonProperty("create_at")
    private Timestamp createAt;
}
