package com.testTask.rishat.controller;


import com.testTask.rishat.entity.PersonEntity;
import com.testTask.rishat.exeption.NoSuchSpecifiedPerson;
import com.testTask.rishat.exeption.PersonAlreadyExistException;
import com.testTask.rishat.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity registration(@RequestBody PersonEntity person) {
        try {
            personService.registration(person);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        } catch (PersonAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка !");
        }
    }


    @GetMapping
    public ResponseEntity getOnePerson(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(personService.getOne(id));
        } catch (NoSuchSpecifiedPerson e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка !");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id){
        try {
            return ResponseEntity.ok(personService.deletePerson(id));
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка !");
        }
    }
}
