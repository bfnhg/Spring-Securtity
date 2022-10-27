package com.example.concour;

import com.example.concour.bean.Role;
import com.example.concour.service.facade.UserService;
import com.example.concour.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ConcourApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConcourApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(false){
            User admin = new User("admin","admin");
            admin.setAuthorities(Arrays.asList(new Role("ROLE_ADMIN")));
            userService.save(admin);

        }

    }
    @Autowired
    private UserService userService;

}
