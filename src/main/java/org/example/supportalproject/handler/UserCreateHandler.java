package org.example.supportalproject.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.supportalproject.domain.Users;
import org.example.supportalproject.messages.UserCreated;
import org.example.supportalproject.services.DispatchService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Maria Tablante (maria.iradini+21@globant.com).
 * @since 01 Jun, 2025 8:02 PM
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class UserCreateHandler {

  private final DispatchService dispatchService;

  @KafkaListener(
      id = "userConsumerClient",
      topics = "user.created",
      groupId = "dispatch.order.created.consumer",
      containerFactory = "kafkaListenerContainerFactory"
  )
  public void listen(UserCreated payload) {
    log.info("UserCreateHandler: Received payload: " + payload);
    try {
      dispatchService.process(payload);
    } catch (Exception e) {
      log.error("Procesing failuere", e);
    }
  }
}
