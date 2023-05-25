package com.isa.jjdzr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Embeddable
public class Stats {
    private Double open;
    private Double hold;
    private Double scheduled;
    private Double closed;
    private Percentage percentage;

}