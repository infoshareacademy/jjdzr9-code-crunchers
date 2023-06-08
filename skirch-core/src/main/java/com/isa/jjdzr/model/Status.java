package com.isa.jjdzr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="status")
public class Status {
    @ManyToOne
    private Lifts lifts;
    @Id
    @Column(name = "lifts_id")
    private Long id;

}
