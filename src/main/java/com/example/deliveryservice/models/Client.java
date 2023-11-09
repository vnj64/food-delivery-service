package com.example.deliveryservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@ToString
@NoArgsConstructor
@Table(name = "clients")
public class Client implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private String id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

}
