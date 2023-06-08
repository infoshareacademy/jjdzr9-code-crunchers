package com.isa.jjdzr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lifts")
//@JsonIgnoreProperties(value = {"status"})

public class Lifts {
    @OneToMany(mappedBy = "lifts")
    private Map<String,String> status;
    @OneToOne(mappedBy = "lifts", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Stats stats;
    @Id
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
    public void setStatus(Map<String, String> status){
        this.status = status;
        this.status.setLifts(this);
    }


}