package com.efood.infrastructure.repositories;

import com.efood.domain.models.Kitchen;
import com.efood.domain.repositories.KitchenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class KitchenRepositoryImpl implements KitchenRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Kitchen> all() {
        return manager.createQuery("from Kitchen", Kitchen.class).getResultList();
    }

    @Override
    public Optional<Kitchen> find(Long id) {
        var result = manager.find(Kitchen.class, id);
        return Optional.ofNullable(result);
    }

    @Override
    public Kitchen save(Kitchen kitchen) {
        return manager.merge(kitchen);
    }

    @Override
    public void delete(Long id) {
        var kitchen = manager.find(Kitchen.class, id);
        manager.remove(kitchen);
    }
}
