package com.testTask.rishat.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "postage")
public class PostageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "index_recepient")
    @NotBlank(message = "Index is required")
    private long indexRecepient;

    @Column(name = "type")
    @NotBlank(message = "Type is required")
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private OrderEntity orderEntity;


    public enum Type {
        LETTER("Letter"), PARCEL("Parcel"), PACKAGE("Package"), POSTCARD("Postcrad");

        private String name;


        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


}
