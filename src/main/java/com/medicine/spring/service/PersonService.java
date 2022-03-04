package com.medicine.spring.service;

import com.medicine.spring.model.Person;
import com.medicine.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //объясняем что данный класс является компонентом спринга
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired //инициализируем personRepository
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Long id) {
        return personRepository.getOne(id);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
