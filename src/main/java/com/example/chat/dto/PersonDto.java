package com.example.chat.dto;

import jakarta.validation.constraints.NotNull;

public class PersonDto {

  @NotNull(message = "Username should be not null")
  private String username;

  public PersonDto(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
