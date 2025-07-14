package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

  @GetMapping("/hello")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<String> adminHello() {
    return ResponseEntity.ok("Olá, administrador!");
  }
}
