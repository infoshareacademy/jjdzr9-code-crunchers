package com.isa.jjdzr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lifts")
@JsonIgnoreProperties(value = {"status"})

public class Lifts {
    @Transient
    private Status status;
    @OneToOne(mappedBy = "lifts", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Stats stats;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_id")
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "data_id")
    private Data data;

    public void setStats(Stats stats){
        this.stats = stats;
        this.stats.setLifts(this);
    }


}