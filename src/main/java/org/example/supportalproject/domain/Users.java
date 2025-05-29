package org.example.supportalproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

/**
 * @author Maria Tablante (maria.tablante@autodesk.com).
 * @since 13 Apr, 2025 4:25 PM
 */
@Entity
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long oxygenId;

  private String name;
  private String lastName;
  private String email;
  private String password;
  private boolean emailExists;
  private boolean emailVerified;
  private boolean twoFaEnabled;
  private boolean gdprStatus;
  private boolean phrStatus;
  private Date lastModified;

  public Users() {
  }

  public Users(String name, String lastName, String email, String password, boolean emailExists,
              boolean emailVerified, boolean twoFaEnabled, boolean gdprStatus, boolean phrStatus,
              Date lastModified) {
    this.name = name;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.emailExists = emailExists;
    this.emailVerified = emailVerified;
    this.twoFaEnabled = twoFaEnabled;
    this.gdprStatus = gdprStatus;
    this.phrStatus = phrStatus;
    this.lastModified = lastModified;
  }

  public Long getOxygenId() {
    return oxygenId;
  }

  public void setOxygenId(Long oxygenId) {
    this.oxygenId = oxygenId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isEmailExists() {
    return emailExists;
  }

  public void setEmailExists(boolean emailExists) {
    this.emailExists = emailExists;
  }

  public boolean isEmailVerified() {
    return emailVerified;
  }

  public void setEmailVerified(boolean emailVerified) {
    this.emailVerified = emailVerified;
  }

  public boolean isTwoFaEnabled() {
    return twoFaEnabled;
  }

  public void setTwoFaEnabled(boolean twoFaEnabled) {
    this.twoFaEnabled = twoFaEnabled;
  }

  public boolean isGdprStatus() {
    return gdprStatus;
  }

  public void setGdprStatus(boolean gdprStatus) {
    this.gdprStatus = gdprStatus;
  }

  public boolean isPhrStatus() {
    return phrStatus;
  }

  public void setPhrStatus(boolean phrStatus) {
    this.phrStatus = phrStatus;
  }

  public Date getLastModified() {
    return lastModified;
  }

  public void setLastModified(Date lastModified) {
    this.lastModified = lastModified;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    Users users = (Users) o;
    return oxygenId != null ? oxygenId.equals(users.oxygenId) : users.oxygenId == null;
  }

  @Override
  public int hashCode() {
    return oxygenId != null ? oxygenId.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "User{" +
        "oxygenId='" + oxygenId + '\'' +
        ", name='" + name + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", emailExists=" + emailExists +
        ", emailVerified=" + emailVerified +
        ", twoFaEnabled=" + twoFaEnabled +
        ", gdprStatus=" + gdprStatus +
        ", phrStatus=" + phrStatus +
        ", lastModified=" + lastModified +
        '}';
  }
}
