package com.msvc.user.infraestructure.abstract_services;


import java.util.List;

import com.msvc.user.domain.entities.Users;

public interface IUserService {
  Users saveUser(Users user);
  List<Users> getAllUsers();
  Users getUser(String id);
}
