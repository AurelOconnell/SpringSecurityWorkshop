package com.SecurityWorkshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    
    @GetMapping("/register")
    public String register() {
        return "register.html";
    }

    @GetMapping("/login")
        public String login() {
            return "login.html";
        }

    @GetMapping("/user")
        public String getUser() {
            return "user.html";
        }

    @GetMapping("/admin")
        public String getAdmin() {
            return "admin.html";
        }

}
