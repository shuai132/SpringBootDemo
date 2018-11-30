package com.example.controller.user.type;

import com.example.db.entity.UserTable;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserTablePage {
    @JsonProperty("total_pages")
    public int totalPages;

    @JsonProperty("total_elems")
    public long totalElements;

    @JsonProperty("users")
    public List<UserTable> users;
}
