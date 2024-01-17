package com.testTask.rishat.services;


import com.testTask.rishat.entity.OrderEntity;
import com.testTask.rishat.entity.PersonEntity;
import com.testTask.rishat.model.Order;
import com.testTask.rishat.repo.OrderRepository;
import com.testTask.rishat.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PersonRepository personRepository;

    public OrderEntity createOrder(Order order,Long id){
        Optional<PersonEntity> person = personRepository.findById(id);
        OrderEntity orderEntity = new OrderEntity();

        if(person.isPresent()){
            String address = person.get().getAddress();

            Order.toEntity(orderEntity);

            person.ifPresent(orderEntity::setPersonEntity);
            orderEntity.setDateCreation(LocalDateTime.now());
            orderEntity.setStatus(OrderEntity.Status.INPROGRESS);

            orderEntity.setDatePossibleArrival(distance(address,order.getAddress()));
        }

        return orderEntity;
    }

    private LocalDateTime distance(String address, String address1) {
        return LocalDateTime.now();
    }


    public OrderEntity updateStatusOrder(Long id){
        OrderEntity orderEntity = orderRepository.findById(id).get();
        int x = orderEntity.getStatus().getNumber();
        if(x < OrderEntity.Status.values().length){
            orderEntity.setStatus(OrderEntity.Status.yourStatus(x + 1));
        }
        return orderRepository.save(orderEntity);
    }
}
