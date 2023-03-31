package com.efood.api.controllers;

import com.efood.domain.models.Kitchen;
import com.efood.domain.repositories.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {
    @Autowired
    private KitchenRepository repository;

    @GetMapping
    List<Kitchen> all() {
        return repository.findAll();
    }

    @GetMapping("/{kitchenId}")
    Kitchen find(@PathVariable String kitchenId) {
        var foundedKitchen = repository.findById(Long.valueOf(kitchenId));
        foundedKitchen.orElseThrow(
            () -> new RuntimeException("kitchen with id: %s does not exists".formatted(kitchenId))
        );
        return foundedKitchen.get();
    }

    @PostMapping
    Kitchen create(@RequestBody String name) {
        var kitchen = new Kitchen();
        kitchen.setName(name);
        return repository.save(kitchen);
    }
}
