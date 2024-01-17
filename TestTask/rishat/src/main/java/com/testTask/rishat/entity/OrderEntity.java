package com.testTask.rishat.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "dateCreation")
    private LocalDateTime dateCreation;

    @Column(name = "datePossibleArrival")
    private LocalDateTime datePossibleArrival;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity personEntity;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
    mappedBy = "orderEntity")
    List<PostageEntity> postagesEntities = new ArrayList<>();

    public enum Status {
        INPROGRESS(1),DONE(2),DELIVERY(3), ;

        private int number;

        Status(int number) {
            this.number = number;
        }


        public static Status yourStatus(int x) {
            Status ret = null;
            for(Status type : Status.values()){
                if(type.getNumber() == x){
                    ret = type;
                }
            }
            return ret;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
