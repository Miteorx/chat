package com.example.chat.controller;

import com.example.chat.dto.MessageDto;
import com.example.chat.dto.PersonDto;
import com.example.chat.model.Message;
import com.example.chat.service.MessageService;
import com.example.chat.service.PersonService;
import com.example.chat.service.exceptions.PersonNotExistException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private final PersonService personService;
  private final MessageService messageService;

  public MainController(PersonService personService,
      MessageService messageService) {
    this.personService = personService;
    this.messageService = messageService;
  }

  @GetMapping("/")
  public String main(Model model, HttpServletRequest req) {
    Iterable<Message> messages = messageService.readAllMessages();
    model.addAttribute("messages", messages);

    HttpSession session = req.getSession();
    String currentUser = (String) session.getAttribute("currentUser");
    model.addAttribute("currentUser", currentUser);
    return "index";
  }

  @PostMapping("/apply")
  public String applyPerson(@RequestParam @Valid String username, HttpServletRequest req) {
    PersonDto personDto = new PersonDto(username);
    personService.savePerson(personDto);
    HttpSession session = req.getSession();
    session.setAttribute("currentUser", username);
    return "redirect:/";
  }

  @PostMapping("/message")
  public String postMessage(@RequestParam @Valid String message, HttpServletRequest req)
      throws PersonNotExistException {
    MessageDto messageDto = new MessageDto(message);
    String username = (String) req.getSession().getAttribute("currentUser");
    messageService.saveMessage(messageDto, username);
    return "redirect:/";
  }

}
