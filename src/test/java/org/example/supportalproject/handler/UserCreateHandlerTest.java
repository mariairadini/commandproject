package org.example.supportalproject.handler;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.UUID;
import org.example.supportalproject.domain.Users;
import org.example.supportalproject.messages.UserCreated;
import org.example.supportalproject.services.DispatchService;
import org.example.supportalproject.util.TestEventData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Maria Tablante (maria.iradini+21@globant.com).
 * @since 02 Jun, 2025 12:12 PM
 */
class UserCreateHandlerTest {

  private UserCreateHandler handler;
  private DispatchService mockDispatchService;

  @BeforeEach
  void setUp() {
    mockDispatchService = mock(DispatchService.class);
    handler = new UserCreateHandler(mockDispatchService);
  }

  @Test
  public void testListen() {
    UserCreated testEvent = TestEventData.buildUserCreatedEvent(randomUUID(), randomUUID().toString());
    handler.listen(testEvent);
    verify(mockDispatchService, times(1)).process(testEvent);
  }
}