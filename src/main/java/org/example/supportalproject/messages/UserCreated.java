package org.example.supportalproject.messages;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.supportalproject.domain.Users;

/**
 * @author Maria Tablante (maria.iradini+21@globant.com).
 * @since 02 Jun, 2025 2:00 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreated {
  UUID userId;
  Users userCreated;
}
