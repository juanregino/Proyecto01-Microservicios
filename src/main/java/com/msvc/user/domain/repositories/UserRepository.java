package com.msvc.user.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msvc.user.domain.entities.Users;

public interface UserRepository  extends JpaRepository<Users, Integer> {
  
}
