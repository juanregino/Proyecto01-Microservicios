package com.msvc.user.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.user.domain.entities.Users;
import com.msvc.user.domain.repositories.UserRepository;
import com.msvc.user.infraestructure.abstract_services.IUserService;
import com.msvc.user.utils.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService  implements IUserService {

  @Autowired
  private final UserRepository userRepository;

  @Override
  public Users saveUser(Users user) {
    
    return userRepository.save(user);

  }

  @Override
  public List<Users> getAllUsers() {
    
    return userRepository.findAll();

  }

  @Override
  public Users getUser(String id) {
    
    return userRepository.findById(Integer.parseInt(id)).orElseThrow(() -> new ResourceNotFoundException());
  }
  
}
