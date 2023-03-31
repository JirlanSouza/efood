package com.efood.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class State {
    @Id
    private Long id;
    private String name;
}
