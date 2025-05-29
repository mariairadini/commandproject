package org.example.supportalproject.repositories;

import java.util.Optional;
import org.example.supportalproject.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Maria Tablante (maria.tablante@autodesk.com).
 * @since 13 Apr, 2025 5:23 PM
 */
public interface UserRepository extends JpaRepository<Users, Long> {
  Optional<Users> findByEmail(String email);

  void deleteByEmail(String email);
}
