package com.isa.jjdzr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resorts")
@Entity
public class Data {
    private String country;
    private String region;
    private String href;
    @Transient
    private Location location;
    @Transient
    private Lifts lifts;

    @Id
    private String name;

}