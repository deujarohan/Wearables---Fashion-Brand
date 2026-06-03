package com.wearables.wearables.service;

import com.wearables.wearables.exception.DuplicateSubscriberException;
import com.wearables.wearables.model.Subscriber;
import com.wearables.wearables.repository.SubscriberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubscriberService {

    private final SubscriberRepository subscriberRepository;

    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @Transactional
    public Subscriber subscribe(String email) {
        String normalizedEmail = email.trim().toLowerCase();

        if (subscriberRepository.existsByEmailIgnoreCase(normalizedEmail)) {
            throw new DuplicateSubscriberException("This email is already subscribed to Wearables.");
        }

        return subscriberRepository.save(new Subscriber(normalizedEmail));
    }
}
