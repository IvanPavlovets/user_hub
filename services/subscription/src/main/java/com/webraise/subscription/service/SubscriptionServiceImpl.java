package com.webraise.subscription.service;

import com.webraise.subscription.model.Subscription;
import com.webraise.subscription.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService {
    private final UserServiceClient userClient;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return this.userClient.findById(id);
    }

    @Override
    public Optional<Subscription> saveSubscription(Long userId, Subscription subs) {
        return Optional.empty();
    }

    @Override
    public List<Subscription> findAllSubscriptionByUserId(Long userId) {
        return null;
    }

    @Override
    public Optional<Subscription> deleteSubscriptionById(Long userId, Long subId) {
        return Optional.empty();
    }
}
