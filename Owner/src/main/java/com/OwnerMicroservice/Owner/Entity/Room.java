package com.OwnerMicroservice.Owner.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(name = "RoomNo")
    private int roomNo;
    @NotNull
    @Size(min = 1, message = " Room should have atleast 1 Number")
    @Column(name = "RoomType")
    private String roomType;
    @NotNull
    @Column(name = "IsOccupied")
    private String isOccupied;
    @NotNull
    @Min(1)
    @Column(name = "RoomCost")
    private int roomCost;
    @Column(name = "CheckIn")
    private String checkIn;
    @Column(name = "CheckOut")
    private String checkOut;
}
