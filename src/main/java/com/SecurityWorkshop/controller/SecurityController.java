package com.SecurityWorkshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    
    @GetMapping("/register")
    public String register() {
        return "Register";
    }

    @GetMapping("/login")
        public String login() {
            return "Login";
        }

    @GetMapping("/user")
        public String loggedUser() {
            return "Logged as user";
        }

    @GetMapping("/admin")
        public String loggedAdmin() {
            return "Logged as admin";
        }

}
