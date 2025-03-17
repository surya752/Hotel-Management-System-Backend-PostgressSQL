package com.OwnerMicroservice.Owner.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SetRates")
public class SetRates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Min(1)
    @Column(name = "Guest")
    private int guest;
    @NotNull
    @Min(1)
    @Column(name = "Days")
    private int days;
    @NotNull
    @Min(1)
    @Column(name = "NightPrice")
    private int nightPrice;
    @NotNull

    @Column(name = "Extension")
    private int extension;
}