package com.example.concour.service.facade;


import com.example.concour.bean.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    String signIn(User user);

    User save(User user);
    List<User> findAll();
}
