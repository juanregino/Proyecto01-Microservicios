package com.msvc.user.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msvc.user.domain.entities.Users;
import com.msvc.user.infraestructure.abstract_services.IUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
  @Autowired
  private final IUserService userService;
  

  @PostMapping
  public ResponseEntity<Users> saveUser(@RequestBody Users request) {

    Users user = this.userService.saveUser(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);

  }
  @GetMapping
  public ResponseEntity<List<Users>> getAllUsers() {
    List<Users> users = this.userService.getAllUsers();
    return ResponseEntity.ok(users);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Users> getUser(@PathVariable String id) {
    Users user = this.userService.getUser(id);
    return ResponseEntity.ok(user);
  }
}
