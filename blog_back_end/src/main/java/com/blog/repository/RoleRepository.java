package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
