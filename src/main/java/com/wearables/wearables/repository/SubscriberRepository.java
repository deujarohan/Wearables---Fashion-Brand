package com.wearables.wearables.repository;

import com.wearables.wearables.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

    boolean existsByEmailIgnoreCase(String email);
}
