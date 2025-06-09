package org.example.supportalproject.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.example.supportalproject.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Maria Tablante (maria.iradini+21@globant.com).
 * @since 06 Jun, 2025 2:59 PM
 */
class UserServiceTest {

  private UserRepository userRepository;
  private UserService userService;


  @BeforeEach
  void setUp() {
    userRepository = mock(UserRepository.class);
    userService = new UserService(userRepository);
  }

  @Test
  public void testUsersList() {
    
  }

  @Test
  void create() {
  }

  @Test
  void update() {
  }

  @Test
  void partialUpdate() {
  }

  @Test
  void findById() {
  }

  @Test
  void findByEmail() {
  }

  @Test
  void deleteById() {
  }

  @Test
  void deleteByEmail() {
  }
}