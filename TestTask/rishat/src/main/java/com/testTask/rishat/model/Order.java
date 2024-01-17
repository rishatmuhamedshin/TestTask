package com.testTask.rishat.model;


import com.testTask.rishat.entity.OrderEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {

    private String address;

    private Long idPerson;


    public static void toEntity(OrderEntity ordersEntity){


        ordersEntity.setAddress(ordersEntity.getAddress());


    }


}
