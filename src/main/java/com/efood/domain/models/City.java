package com.efood.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class City {
    @Id
    private Long id;
    private String name;
    @OneToOne
    private State state;
}
