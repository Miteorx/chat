package com.example.chat.service.exceptions;

public class PersonNotExistException extends Exception {

  public PersonNotExistException() {
    super("Person not exist");
  }
}
