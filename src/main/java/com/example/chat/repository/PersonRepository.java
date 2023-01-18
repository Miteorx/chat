package com.example.chat.repository;

import com.example.chat.model.Person;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
  Optional<Person> findPersonByUsername(String username);

}
