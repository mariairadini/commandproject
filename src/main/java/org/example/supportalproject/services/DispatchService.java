package org.example.supportalproject.services;

import org.example.supportalproject.domain.Users;
import org.example.supportalproject.messages.UserCreated;
import org.springframework.stereotype.Service;

/**
 * @author Maria Tablante (maria.iradini+21@globant.com).
 * @since 02 Jun, 2025 12:16 PM
 */
@Service
public class DispatchService {

  public void process(UserCreated payload) {
    // no-op
  }

}
