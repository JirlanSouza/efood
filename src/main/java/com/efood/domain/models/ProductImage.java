package com.efood.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductImage {
    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String description;
    private String contentType;
    private Long size;
}
