package com.ReceptionistMicroservice.Receptionist.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Min(0)
    @Column(name = "RoomNo")
    private int roomNo;
    @NotNull
    @Min(0)
    @Column(name = "Children")
    private int children;
    @NotNull
    @Min(1)
    @Column(name = "Adults")
    private int adults;
    @NotNull
    @Size(min = 1, message = " Room should have atleast 1 Number")
    @Column(name = "CheckInDate")
    private String checkindate;
    @NotNull
    @Column(name = "CheckOutDate")
    private String checkoutdate;
}