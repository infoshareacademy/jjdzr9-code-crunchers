package com.isa.jjdzr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Embeddable
@JsonIgnoreProperties(value = {"status"})

public class Lifts {
//    @Embedded
    private Status status;
//    @Embedded
    private Stats stats;
}