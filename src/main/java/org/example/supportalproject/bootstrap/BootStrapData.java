package org.example.supportalproject.bootstrap;

import org.example.supportalproject.domain.Users;
import org.example.supportalproject.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Maria Tablante (maria.tablante@autodesk.com).
 * @since 15 Apr, 2025 4:43 PM
 */
@Component
public class BootStrapData implements CommandLineRunner {

  private final UserRepository userRepository;

  public BootStrapData(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    Users firstUser = new Users("Maria", "Tablante", "mariairadini@gmail.com", "password123",
        true, true, false, true, true, null);

    userRepository.save(firstUser);

    System.out.println("Bootstrap Data Loaded");
    System.out.println("Users Loaded: " + userRepository.count());
  }
}
