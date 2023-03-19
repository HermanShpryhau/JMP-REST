package com.epam.jmp.service.impl;

import com.epam.jmp.entity.Subscription;
import com.epam.jmp.repository.SubscriptionRepository;
import com.epam.jmp.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> findById(long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId);
    }

    @Override
    public Subscription save(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void delete(long subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }
}
