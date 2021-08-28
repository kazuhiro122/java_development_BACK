package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserItem;

@Repository
public interface AccountingFuncRepository extends JpaRepository<UserItem, Long> {

}
