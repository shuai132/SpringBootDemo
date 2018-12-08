package com.example.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "user")
@Data
public class UserTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(nullable = false)
    @JsonProperty("name")
    private String name;

    @Column
    @ApiModelProperty(example = Const.DATETIME_EXAMPLE)
    @JsonProperty("create_at")
    private Timestamp createAt;
}
