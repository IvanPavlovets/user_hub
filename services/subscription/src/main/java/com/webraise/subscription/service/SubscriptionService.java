package com.webraise.subscription.service;

import com.webraise.subscription.model.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {

    Optional<Subscription> saveSubscription(Long userId, Subscription subs);

    List<Subscription> findAllSubscriptionByUserId(Long userId);

    Optional<Subscription> deleteSubscriptionById(Long userId, Long subId);

}
