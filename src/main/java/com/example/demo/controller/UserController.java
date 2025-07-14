// src/main/java/com/example/jwtaula/controller/UserController.java
package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @GetMapping("/hello")
  @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
  public ResponseEntity<String> userHello() {
    return ResponseEntity.ok("Olá, usuário autenticado!");
  }
}