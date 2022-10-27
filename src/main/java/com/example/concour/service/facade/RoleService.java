package com.example.concour.service.facade;

import com.example.concour.bean.Role;

import java.util.Collection;

public interface RoleService {
    Role save(Role role);
    void save(Collection<Role> roles);
    Role findByAuthority(String authority);
}
