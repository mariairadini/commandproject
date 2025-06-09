package org.example.supportalproject.controllers;

import org.example.supportalproject.domain.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.supportalproject.services.UserService;

/**
 * @author Maria Tablante (maria.tablante@autodesk.com).
 * @since 12 May, 2025 2:47 PM
 */
@RestController
@RequestMapping("/users")
public class UsersController {


  private final UserService userService;

  public UsersController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<Users> createUser(@RequestBody Users user) {
    Users userCreated = userService.create(user);
    return ResponseEntity.status(201).body(userCreated);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
    return userService.update(id, user)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  public ResponseEntity<Users> partialUpdateUser(@PathVariable Long id, @RequestBody Users userNewInfo) {
    return userService.partialUpdate(id, userNewInfo)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    boolean deleted = userService.deleteById(id);
      return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/email/{email}")
  public ResponseEntity<Void> deleteByEmail(@PathVariable String email) {
    boolean deleted = userService.deleteByEmail(email);
      return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
  }
}
