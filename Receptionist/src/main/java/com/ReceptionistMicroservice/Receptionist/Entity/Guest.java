package com.ReceptionistMicroservice.Receptionist.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Guest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 2, message = " Name should have atleast 2 characters")
    @Column(name = "Name")
    private String name;
    @Email
    @NotBlank
    @Column(name = "Email")
    private String email;
    @NotNull
    @Min(9)
    @Column(name = "PhoneNo")
    private long phoneNo;
    @Column(name = "RoomNo")
    @NotNull
    @Min(1)
    private int roomNo;
    @NotNull
    private String gender;
    @Column(name = "Address")
    @NotNull
    @Size(min = 2, message = " Name should have atleast 2 characters")
    private String address;
}