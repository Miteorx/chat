package com.example.chat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String message;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Person.class)
  @JoinColumn(name = "person_id")
  @JsonBackReference
  private Person person;

  public Message(Long id, String message, Person person) {
    this.id = id;
    this.message = message;
    this.person = person;
  }

  public Message() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person username) {
    this.person = username;
  }
}
