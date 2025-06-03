package org.example.supportalproject.messages;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maria Tablante (maria.iradini+21@globant.com).
 * @since 02 Jun, 2025 8:41 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDispatched {

  UUID userId;
}
