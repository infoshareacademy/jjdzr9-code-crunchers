package com.isa.jjdzr.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//@Embeddable
public class Location {
    private Double latitude;
    private Double longitude;

    public Location() {

    }
}
