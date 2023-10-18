package com.SecurityWorkshop.service;


import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.SecurityWorkshop.model.Role;
import com.SecurityWorkshop.model.User;
import com.SecurityWorkshop.repository.RoleRepository;
import com.SecurityWorkshop.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void generateUserList() {
        Role adminRole = roleRepository.findByName("ADMIN");
        Role userRole = roleRepository.findByName("USER");

        if (adminRole == null) {
            adminRole = new Role("ADMIN");
            roleRepository.save(adminRole);
        }

        if (userRole == null) {
            userRole = new Role("USER");
            roleRepository.save(userRole);
        }

        User adminUser = new User();
        adminUser.setPassword(bCryptPasswordEncoder.encode("adminpassword"));
        adminUser.setUsername("admin");
        adminUser.getRoles().add(adminRole);

        User regularUser = new User();
        regularUser.setPassword(bCryptPasswordEncoder.encode("userpassword"));
        regularUser.setUsername("user");
        regularUser.getRoles().add(userRole);

        List<User> users = new ArrayList<>();
        users.add(adminUser);
        users.add(regularUser);
        userRepository.saveAll(users);
    }

}
