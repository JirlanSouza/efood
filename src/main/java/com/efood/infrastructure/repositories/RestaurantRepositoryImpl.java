package com.efood.infrastructure.repositories;

import com.efood.domain.models.Restaurant;
import com.efood.domain.repositories.RestaurantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class RestaurantRepositoryImpl implements RestaurantRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurant> all() {
        return manager.createQuery("from Restaurant", Restaurant.class).getResultList();
    }

    @Override
    public Optional<Restaurant> find(Long id) {
        var result = manager.find(Restaurant.class, id);
        return Optional.ofNullable(result);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return manager.merge(restaurant);
    }

    @Override
    public void delete(Long id) {
        var restaurant = manager.find(Restaurant.class, id);
        manager.remove(restaurant);
    }
}
