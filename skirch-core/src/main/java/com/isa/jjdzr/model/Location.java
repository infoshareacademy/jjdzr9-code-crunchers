package com.isa.jjdzr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location {
    private Double latitude;
    private Double longitude;
    @Id
    @Column(name = "data_id")
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name="data_id")
    private Data data;

}
