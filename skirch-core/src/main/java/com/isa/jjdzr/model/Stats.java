package com.isa.jjdzr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stats")
@Entity
public class Stats {

    private Double open;
    private Double hold;
    private Double scheduled;
    private Double closed;
    @OneToOne(mappedBy = "stats", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Percentage percentage;
    @OneToOne
    @MapsId
    @JoinColumn(name="lifts_id")
    private Lifts lifts;
    @Id
    @Column(name = "lifts_id")
    private Long id;

    public void setPercentage(Percentage percentage){
        this.percentage = percentage;
        this.percentage.setStats(this);
    }

}