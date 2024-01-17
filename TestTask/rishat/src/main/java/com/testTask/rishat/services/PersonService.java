package com.testTask.rishat.services;


import com.testTask.rishat.entity.PersonEntity;
import com.testTask.rishat.exeption.NoSuchSpecifiedPerson;
import com.testTask.rishat.exeption.PersonAlreadyExistException;
import com.testTask.rishat.model.Person;
import com.testTask.rishat.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonEntity registration(PersonEntity person) throws PersonAlreadyExistException {
        if (personRepository.findByEmail(person.getEmail()) != null){
            throw new PersonAlreadyExistException("Пользователь с таким email уже есть ! ");
        }
        return personRepository.save(person);
    }

    public Person getOne(Long id) throws NoSuchSpecifiedPerson {
        Optional<PersonEntity> entity = personRepository.findById(id);
        Person person;
        if (entity.isPresent()) {
            person = Person.toModel(entity.get());
        } else throw new NoSuchSpecifiedPerson(" Пользвотеля не существует");
        return person;
    }

    public Long deletePerson(Long id){
        personRepository.deleteById(id);
        return id;
    }
}
