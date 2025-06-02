package org.example.supportalproject.services;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.example.supportalproject.domain.Users;
import org.example.supportalproject.messages.UserCreated;
import org.example.supportalproject.util.TestEventData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Maria Tablante (maria.iradini+21@globant.com).
 * @since 02 Jun, 2025 12:17 PM
 */
class DispatchServiceTest {
  private DispatchService dispatchService;

  @BeforeEach
  void setUp() {
    dispatchService = new DispatchService();
  }

  @Test
  public void testProcess() {
    UserCreated testEvent = TestEventData.buildUserCreatedEvent(randomUUID(), randomUUID().toString());
    dispatchService.process(testEvent);
  }
}