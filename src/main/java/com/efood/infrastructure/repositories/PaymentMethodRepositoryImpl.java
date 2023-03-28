package com.efood.infrastructure.repositories;

import com.efood.domain.models.PaymentMethod;
import com.efood.domain.repositories.PaymentMethodRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<PaymentMethod> all() {
        return manager.createQuery("from PaymentMethod", PaymentMethod.class).getResultList();
    }

    @Override
    public Optional<PaymentMethod> find(Long id) {
        var result = manager.find(PaymentMethod.class, id);
        return Optional.ofNullable(result);
    }

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return manager.merge(paymentMethod);
    }

    @Override
    public void delete(Long id) {
        var paymentMethod = manager.find(PaymentMethod.class, id);
        manager.remove(paymentMethod);
    }
}
