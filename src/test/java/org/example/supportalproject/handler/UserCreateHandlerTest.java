package org.example.supportalproject.handler;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
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
  private Users mockUserCreated;

  @BeforeEach
  void setUp() {
    mockDispatchService = mock(DispatchService.class);
    mockUserCreated = mock(Users.class);
    handler = new UserCreateHandler(mockDispatchService);
  }

  @Test
  public void testListenSuccess() throws Exception {
    UserCreated testEvent = TestEventData.buildUserCreatedEvent(randomUUID(), mockUserCreated);
    handler.listen(testEvent);
    verify(mockDispatchService, times(1)).process(testEvent);
  }

  @Test
  public void testListenServiceThrowsException() throws Exception {
    UserCreated testEvent = TestEventData.buildUserCreatedEvent(randomUUID(), mockUserCreated);
    doThrow(new RuntimeException("Service failure")).when(mockDispatchService).process(testEvent);

    handler.listen(testEvent);
    verify(mockDispatchService, times(1)).process(testEvent);
  }
}