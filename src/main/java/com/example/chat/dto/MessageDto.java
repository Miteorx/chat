package com.example.chat.dto;

import jakarta.validation.constraints.NotNull;

public class MessageDto {

  @NotNull(message = "Message should be not null")
  private String message;

  public MessageDto(String message) {
    this.message = message;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
