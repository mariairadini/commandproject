package org.example.supportalproject.util;

import java.util.UUID;
import org.example.supportalproject.domain.Users;
import org.example.supportalproject.messages.UserCreated;

/**
 * @author Maria Tablante (maria.iradini+21@globant.com).
 * @since 02 Jun, 2025 2:15 PM
 */
public class TestEventData {

  public static UserCreated buildUserCreatedEvent(UUID userId, String user) {
    return UserCreated.builder()
        .userId(UUID.randomUUID())
        .userCreated(user)
        .build();
  }
}
