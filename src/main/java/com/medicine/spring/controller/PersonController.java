package com.medicine.spring.controller;

import com.medicine.spring.model.Person;
import com.medicine.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller//Указывает что это класс контроллер
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person") //Обрабатывает get-запросы
    public String findAll(Model model) {
        List<Person> people = personService.findAll();
        model.addAttribute("people", people);
        return "person-list";
    }

    @GetMapping("/person-create")
    public String createPersonForm(Person person) {
        return "person-create";
    }

    @PostMapping("/person-create") //Обрабатывает post-запросы
    public String createPerson(Person person) {
        personService.savePerson(person);
        return "redirect:/person";
    }

    @GetMapping("person-delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        personService.deleteById(id);
        return "redirect:/person";
    }

    @GetMapping("/person-update/{id}")
    public String updatePersonForm(@PathVariable("id") Long id, Model model) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        return "person-update";
    }

    @PostMapping("/person-update")
    public String updatePerson(Person person) {
        personService.savePerson(person);
        return "redirect:/person";
    }
}
