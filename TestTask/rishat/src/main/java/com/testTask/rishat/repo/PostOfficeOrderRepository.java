package com.testTask.rishat.repo;

import com.testTask.rishat.entity.PostOfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostOfficeOrderRepository extends JpaRepository<PostOfficeEntity,Long> {

}
