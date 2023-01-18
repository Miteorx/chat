package com.example.chat.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String username;

  @OneToMany(mappedBy = "person",
      cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Message> messages;

  public Person(Long id, String username, List<Message> messages) {
    this.id = id;
    this.username = username;
    this.messages = messages;
  }

  public Person() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }
}
