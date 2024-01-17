package com.testTask.rishat.entity;


import com.testTask.rishat.entity.PK.PostOfficeOrderPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "PostOfficeOrderRepository")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostOfficesOrderEntity {

    @EmbeddedId
    private PostOfficeOrderPK pk;

    @Column(name = "date_arrival")
    private LocalDateTime dateArrival;

    @Column(name = "date_depature")
    private LocalDateTime dateDepature;





}
