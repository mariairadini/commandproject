package org.example.supportalproject.services;

import static java.util.UUID.randomUUID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.example.supportalproject.domain.Users;
import org.example.supportalproject.messages.UserCreated;
import org.example.supportalproject.messages.UserDispatched;
import org.example.supportalproject.util.TestEventData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author Maria Tablante (maria.iradini+21@globant.com).
 * @since 02 Jun, 2025 12:17 PM
 */
class DispatchServiceTest {
  private DispatchService dispatchService;
  private Users mockUserCreated;
  private KafkaTemplate kafkaProducerMock;

  @BeforeEach
  void setUp() {
    mockUserCreated = mock(Users.class);
    kafkaProducerMock = mock(KafkaTemplate.class);
    dispatchService = new DispatchService(kafkaProducerMock);
  }

  @Test
  public void testProcessSuccess() throws Exception {
    when(kafkaProducerMock.send(anyString(), any(UserDispatched.class)))
        .thenReturn(mock(CompletableFuture.class));

    UserCreated testEvent = TestEventData.buildUserCreatedEvent(randomUUID(), mockUserCreated);
    dispatchService.process(testEvent);
    verify(kafkaProducerMock, times(1))
        .send(eq("user.dispatched"), any(UserDispatched.class));
  }

  @Test
  public void testProcessProducerThrowsException() throws Exception {
    UserCreated testEvent = TestEventData.buildUserCreatedEvent(randomUUID(), mockUserCreated);
    doThrow(new RuntimeException("Producer failure")).when(kafkaProducerMock).send(anyString(), any(UserDispatched.class));

    Exception exception = assertThrows(RuntimeException.class, () -> dispatchService.process(testEvent));

    verify(kafkaProducerMock, times(1)).send(eq("user.dispatched"), any(UserDispatched.class));
    assertThat(exception.getMessage(), equalTo("Producer failure"));
  }
}