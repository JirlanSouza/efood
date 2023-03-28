package com.efood.domain.repositories;

import com.efood.domain.models.PaymentMethod;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodRepository {
    List<PaymentMethod> all();

    Optional<PaymentMethod> find(Long id);

    PaymentMethod save(PaymentMethod PaymentMethod);

    void delete(Long id);
}
