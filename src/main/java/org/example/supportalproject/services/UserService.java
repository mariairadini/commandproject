package org.example.supportalproject.services;

import java.util.List;
import java.util.Optional;
import org.example.supportalproject.domain.Users;
import org.example.supportalproject.repositories.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author Maria Tablante (maria.tablante@autodesk.com).
 * @since 28 May, 2025 3:28 PM
 */
@Service
public class UserService {


  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<Users> usersList() {
    return repository.findAll();
  }

  public Users create(Users user) {
    return repository.save(user);
  }

  public Optional<Users> update(Long id, Users newUser) {
    Users existingUser = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    if (newUser.getOxygenId() != null) existingUser.setOxygenId(newUser.getOxygenId());
    if (newUser.getName() != null) existingUser.setName(newUser.getName());
    if (newUser.getLastName() != null) existingUser.setLastName(newUser.getLastName());
    if (newUser.getEmail() != null) existingUser.setEmail(newUser.getEmail());
    if (newUser.getPassword() != null) existingUser.setPassword(newUser.getPassword());
    if (newUser.getEmailExists()) existingUser.setEmailExists(newUser.getEmailExists());
    if (newUser.getEmailVerified()) existingUser.setEmailVerified(newUser.getEmailVerified());
    if (newUser.getTwoFaEnabled()) existingUser.setTwoFaEnabled(newUser.getTwoFaEnabled());
    if (newUser.getGdprStatus()) existingUser.setGdprStatus(newUser.getGdprStatus());
    if (newUser.getPhrStatus()) existingUser.setPhrStatus(newUser.getPhrStatus());
    if(newUser.getLastModified() != null) existingUser.setLastModified(newUser.getLastModified());
    return Optional.of(repository.save(existingUser));
  }

  public Optional<Users> partialUpdate(Long id, Users userNewInfo) {
    Users user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    if (userNewInfo.getOxygenId() != null) user.setOxygenId(userNewInfo.getOxygenId());
    if (userNewInfo.getName() != null) user.setName(userNewInfo.getName());
    if (userNewInfo.getLastName() != null) user.setLastName(userNewInfo.getLastName());
    if (userNewInfo.getEmail() != null) user.setEmail(userNewInfo.getEmail());
    if (userNewInfo.getPassword() != null) user.setPassword(userNewInfo.getPassword());
    if (userNewInfo.getEmailExists()) user.setEmailExists(userNewInfo.getEmailExists());
    if (userNewInfo.getEmailVerified()) user.setEmailVerified(userNewInfo.getEmailVerified());
    if (userNewInfo.getTwoFaEnabled()) user.setTwoFaEnabled(userNewInfo.getTwoFaEnabled());
    if (userNewInfo.getGdprStatus()) user.setGdprStatus(userNewInfo.getGdprStatus());
    if (userNewInfo.getPhrStatus()) user.setPhrStatus(userNewInfo.getPhrStatus());
    if (userNewInfo.getLastModified() != null) user.setLastModified(userNewInfo.getLastModified());
    return Optional.of(repository.save(user));
  }

  public Optional<Users> findById(Long id) {
    return repository.findById(id);
  }

  public Optional<Users> findByEmail(String email) {
    return repository.findByEmail(email);
  }

  public boolean deleteById(Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }

  public boolean deleteByEmail(String email) {
    if (repository.findByEmail(email).isPresent()) {
      repository.deleteByEmail(email);
      return true;
    }
    return false;
  }
}
