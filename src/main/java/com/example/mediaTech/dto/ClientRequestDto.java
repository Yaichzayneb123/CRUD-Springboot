package com.example.mediaTech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private String address;
    private String phoneNumber;
    private String job;
}
