package com.example.chat.service;

import com.example.chat.dto.MessageDto;
import com.example.chat.model.Message;
import com.example.chat.model.Person;
import com.example.chat.repository.MessageRepository;
import com.example.chat.repository.PersonRepository;
import com.example.chat.service.exceptions.PersonNotExistException;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  private final MessageRepository messageRepository;
  private final PersonRepository personRepository;

  public MessageService(MessageRepository messageRepository,
      PersonRepository personRepository) {
    this.messageRepository = messageRepository;
    this.personRepository = personRepository;
  }

  public Message saveMessage(MessageDto messageDto, String username)
      throws PersonNotExistException {
    Optional<Person> person = personRepository.findPersonByUsername(username);
    if (person.isPresent()) {
      Message message = new Message(0L, messageDto.getMessage(), person.get());
      return messageRepository.save(message);
    } else {
      throw new PersonNotExistException();
    }
  }

  public Iterable<Message> readAllMessages() {
    return messageRepository.findAll();
  }

}
