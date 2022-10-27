package com.example.concour.dao;

import com.example.concour.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
User findByUsername(String username);
User findByEmail(String email);

    @Override
    List<User> findAll();
}
