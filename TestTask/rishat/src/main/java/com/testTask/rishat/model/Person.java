package com.testTask.rishat.model;


import com.testTask.rishat.entity.PersonEntity;
import lombok.Data;

@Data
public class Person {


    public static  Person toModel(PersonEntity entity){
        Person model = new Person();
        model.setId(entity.getId());
        model.setEmail(entity.getEmail());
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setPatronymic(entity.getPatronymic());
        model.setAddress(entity.getAddress());
        return model;
    }


    private Long id;

    private String name;
    private String surname;
    private String patronymic;

    private String email;
    private String address;
}
