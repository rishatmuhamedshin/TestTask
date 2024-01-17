package com.testTask.rishat.controller;


import com.testTask.rishat.entity.OrderEntity;
import com.testTask.rishat.model.Order;
import com.testTask.rishat.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity createOrder(@RequestBody Order order,
                                      @RequestParam Long personId) {
        try{
            return ResponseEntity.ok(orderService.createOrder(order, personId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка !");
        }
    }

    @PutMapping
    public ResponseEntity updateOrder(@RequestParam Long personId) {
        try{
            return ResponseEntity.ok(orderService.updateStatusOrder(personId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка !");
        }
    }
}
