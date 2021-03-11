package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.blog.model.Role;
import com.blog.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}
