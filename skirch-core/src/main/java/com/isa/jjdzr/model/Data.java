package com.isa.jjdzr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resorts")
@Entity
public class Data {
    private String country;
    private String region;
    private String href;
    @OneToOne(mappedBy = "data", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Location location;
    @OneToOne(mappedBy = "data", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Lifts lifts;
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public void setLocation(Location location){
        this.location = location;
        this.location.setData(this);
    }

    public void setLifts(Lifts lifts){
        this.lifts = lifts;
        this.lifts.setData(this);
    }

}