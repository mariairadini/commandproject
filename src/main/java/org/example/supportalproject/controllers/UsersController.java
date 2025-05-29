package org.example.supportalproject.controllers;

import java.util.List;
import org.example.supportalproject.domain.Users;
import org.example.supportalproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

  @Autowired
  private UserService userService;

  private final UserRepository userRepository;

  public UsersController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping
  public List<Users> getUsers() {
    return userService.listar();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Users> getUserById(Long id) {
    return userService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<Users> getUserByEmail(String email) {
    return userService.findByEmail(email)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Users createUser(@RequestBody Users user) {
    return userService.save(user);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
    return userService.findById(id)
        .map(existingUser -> {
      existingUser.setOxygenId(user.getOxygenId());
      existingUser.setName(user.getName());
      existingUser.setLastName(user.getLastName());
      existingUser.setEmail(user.getEmail());
      existingUser.setPassword(user.getPassword());
      existingUser.setEmailExists(user.isEmailExists());
      existingUser.setEmailVerified(user.isEmailVerified());
      existingUser.setTwoFaEnabled(user.isTwoFaEnabled());
      existingUser.setGdprStatus(user.isGdprStatus());
      existingUser.setPhrStatus(user.isPhrStatus());
      existingUser.setLastModified(user.getLastModified());
      return ResponseEntity.ok(userService.save(existingUser));
    })
        .orElse(ResponseEntity.notFound().build());
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    if (userService.findById(id).isPresent()) {
      userService.deleteById(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/email/{email}")
  public ResponseEntity<Void> deleteByEmail(@PathVariable String email) {
    if (userService.findByEmail(email).isPresent()) {
      userService.deleteByEmail(email);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }
}
