package com.SecurityWorkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SecurityWorkshop.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
