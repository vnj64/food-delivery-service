package com.example.deliveryservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity(name = "client")
@Getter
@Setter
@ToString
@NoArgsConstructor
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
