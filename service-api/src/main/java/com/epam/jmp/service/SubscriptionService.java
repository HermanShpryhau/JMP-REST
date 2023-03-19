package com.epam.jmp.service;

import com.epam.jmp.entity.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {
    List<Subscription> findAll();

    Optional<Subscription> findById(long subscriptionId);

    Subscription save(Subscription subscription);

    void delete(long subscriptionId);
}
