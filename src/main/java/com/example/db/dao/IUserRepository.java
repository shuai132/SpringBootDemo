package com.example.db.dao;

import com.example.db.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IUserRepository extends JpaRepository<UserTable, Long>, JpaSpecificationExecutor<UserTable> {}
