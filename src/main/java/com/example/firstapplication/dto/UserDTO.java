package com.example.firstapplication.dto;

public record UserDTO(
    String firstName,
    String lastName,
    String email,
    String phoneNumber,
    String dateOfBirth,
    String gender,
    Address address) {
   public record Address(
        String addressLine1,
        String addressLine2,
        String city,
        String state,
        String zipCode
    ) {}
}
