package com.isa.jjdzr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="stats_percentage")
@Entity
public class Percentage {
    private Double open;
    private Double hold;
    private Double scheduled;
    private Double closed;
    @Id
    @Column(name = "stats_id")
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name="stats_id")
    private Stats stats;

}
