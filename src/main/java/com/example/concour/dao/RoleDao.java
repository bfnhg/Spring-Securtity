package com.example.concour.dao;

import com.example.concour.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long> {
    Role findByAuthority(String authority);

}

