package com.efood.domain.repositories;

import com.efood.domain.models.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {
    List<Restaurant> all();

    Optional<Restaurant> find(Long id);

    Restaurant save(Restaurant restaurant);

    void delete(Long id);
}
