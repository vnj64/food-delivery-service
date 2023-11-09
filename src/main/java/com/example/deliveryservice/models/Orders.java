package com.example.deliveryservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.sql.Date;

import static java.sql.Types.NULL;

@Data
@Entity(name = "orders")
public class Orders implements Serializable {
    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Client client_id;

    @Column(name = "restaurant_id")
    private Integer restaurant_id;

    @Column(name = "status")
    private String status;

    @Column(name = "courier_id")
    private Integer courier_id = NULL;

    @Column(name = "timestamp")
    private Date timestamp;
}
