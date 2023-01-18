package com.example.chat.service;

import com.example.chat.dto.PersonDto;
import com.example.chat.model.Person;
import com.example.chat.repository.PersonRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public Person savePerson(PersonDto personDto) {
    if (personRepository.findPersonByUsername(personDto.getUsername()).isEmpty()) {
      Person person = new Person(0L, personDto.getUsername(), null);
      return personRepository.save(person);
    }
    Optional<Person> person = personRepository.findPersonByUsername(personDto.getUsername());
    return person.get();
  }

}
