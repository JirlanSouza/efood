package com.efood.domain.repositories;

import com.efood.domain.models.Kitchen;

import java.util.List;
import java.util.Optional;

public interface KitchenRepository {
    List<Kitchen> all();

    Optional<Kitchen> find(Long id);

    Kitchen save(Kitchen kitchen);

    void delete(Long id);
}
