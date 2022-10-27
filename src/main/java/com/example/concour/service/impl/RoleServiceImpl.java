package com.example.concour.service.impl;

import com.example.concour.bean.Role;
import com.example.concour.dao.RoleDao;
import com.example.concour.service.facade.RoleService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    // si n'exsite pas j le sauvegarde sino je retourne ce qu'il y a dans la base donnee
    public Role save(Role role) {
        Role loadeRole = roleDao.findByAuthority(role.getAuthority());
        if (loadeRole == null) {
            return roleDao.save(role);
        } else {
            return loadeRole;
        }

    }

    @Override
    //sauvegardeer ensemble de roles
    //je cherche le role en se basant sur authority
    //si diff de null je rtourne le role avec son id
    public void save(Collection<Role> roles) {
        if (roles != null && !roles.isEmpty()) {
            for (Role role : roles) {
                Role foundeRole = findByAuthority(role.getAuthority());
                if (foundeRole != null) {
                    role.setId(foundeRole.getId());
                } else {
                    roleDao.save(role);
                }
            }
        }
    }

    @Override
    public Role findByAuthority(String authority) {
        return roleDao.findByAuthority(authority);
    }


}



