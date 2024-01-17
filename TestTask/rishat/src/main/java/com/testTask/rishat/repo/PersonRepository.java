package com.testTask.rishat.repo;

import com.testTask.rishat.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity,Long> {


    PersonEntity findByEmail(String Email);
}
