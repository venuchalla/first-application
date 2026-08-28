package com.example.firstapplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "address")
@NoArgsConstructor
@Setter
@Getter
public class Address {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    UUID guid;
    @Column(name = "address_line_one")
    String addressLineOne;
    @Column(name = "address_line_two")
    String addressLineTwo;
    @Column(name = "city")
    String city;
    @Column(name = "state")
    String state;
    @Column(name = "zip_code")
    String zipCode;
}
