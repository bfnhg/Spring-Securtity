package com.example.concour.ws;


import com.example.concour.bean.User;
import com.example.concour.service.facade.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/admin/user")
public class UserController {

    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/sign-in/")
    public String signIn(@RequestBody User user) {
        return userService.signIn(user);
    }


    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("/username/{username}")
    public UserDetails loadUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }


    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
