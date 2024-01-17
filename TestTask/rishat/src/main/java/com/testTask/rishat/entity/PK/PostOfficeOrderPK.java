package com.testTask.rishat.entity.PK;

import com.testTask.rishat.entity.OrderEntity;
import com.testTask.rishat.entity.PostOfficeEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;



@Data
@Embeddable
public class PostOfficeOrderPK implements Serializable {


    @ManyToOne
    @JoinColumn(name = "ORDERS_ID")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "POSTOFFICE_ID")
    private PostOfficeEntity postOfficeEntity;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostOfficeOrderPK that = (PostOfficeOrderPK) o;

        if (!Objects.equals(orderEntity, that.orderEntity)) return false;
        return Objects.equals(postOfficeEntity, that.postOfficeEntity);
    }

    @Override
    public int hashCode() {
        int result = orderEntity != null ? orderEntity.hashCode() : 0;
        result = 31 * result + (postOfficeEntity != null ? postOfficeEntity.hashCode() : 0);
        return result;
    }
}
