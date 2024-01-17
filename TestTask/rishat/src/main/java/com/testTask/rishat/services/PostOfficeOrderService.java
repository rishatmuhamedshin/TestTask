package com.testTask.rishat.services;


import com.testTask.rishat.repo.OrderRepository;
import com.testTask.rishat.repo.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostOfficeOrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PostOfficeRepository postOfficeRepository;






}
