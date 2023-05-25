package com.isa.jjdzr.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Embeddable
public class Stats {
    @Column(insertable=false, updatable=false)
    private Double open;
    @Column(insertable=false, updatable=false)
    private Double hold;
    @Column(insertable=false, updatable=false)
    private Double scheduled;
    @Column(insertable=false, updatable=false)
    private Double closed;
//    @Embedded
    private Percentage percentage;

}