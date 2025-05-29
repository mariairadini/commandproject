package org.example.supportalproject.services;

import java.util.List;
import java.util.Optional;
import org.example.supportalproject.domain.Users;
import org.example.supportalproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Maria Tablante (maria.tablante@autodesk.com).
 * @since 28 May, 2025 3:28 PM
 */
@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<Users> usersList() {
    return repository.findAll();
  }

  public Users save(Users user) {
    return repository.save(user);
  }

  public Optional<Users> findById(Long id) {
    return repository.findById(id);
  }

  public Optional<Users> findByEmail(String email) {
    return repository.findByEmail(email);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  public void deleteByEmail(String email) {
    repository.deleteByEmail(email);
  }
}
