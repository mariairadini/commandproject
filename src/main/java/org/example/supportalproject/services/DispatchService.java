package org.example.supportalproject.services;

import lombok.RequiredArgsConstructor;
import org.example.supportalproject.domain.Users;
import org.example.supportalproject.messages.UserCreated;
import org.example.supportalproject.messages.UserDispatched;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Maria Tablante (maria.iradini+21@globant.com).
 * @since 02 Jun, 2025 12:16 PM
 */
@Service
@RequiredArgsConstructor
public class DispatchService {

  private static final String USER_DISPATCHED_TOPIC = "user.dispatched";
  private final KafkaTemplate<String, Object> kafkaProducer;

  public void process(UserCreated userCreated) throws Exception{
    UserDispatched userDispatched = UserDispatched.builder()
        .userId(userCreated.getUserId())
        .build();
    kafkaProducer.send(USER_DISPATCHED_TOPIC, userDispatched).get();
  }

}
