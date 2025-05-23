package com.webraise.subscription.web;

import com.webraise.subscription.model.Subscription;
import com.webraise.subscription.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * контроллер описывает CRUD операции
 * и построен по схеме Rest архитектуры:
 * POST /users/{id}/subscriptions - добавить подписку пользователю.
 * GET /users/{id}/subscriptions - получить подписки пользователя.
 * DELETE /users/{id}/subscriptions/{subId} - удалить подписку у пользователя.
 */
@RestController
@RequestMapping("/users/{userId}/subscriptions")
@AllArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subService;

    @PostMapping("/")
    public ResponseEntity<Subscription> addSubscription(@PathVariable Long userId, @RequestBody Subscription subscription) {
        return getResponseEntity(this.subService.saveSubscription(userId, subscription), HttpStatus.CREATED, HttpStatus.CONFLICT);
    }

    @GetMapping("/")
    public ResponseEntity<List<Subscription>> getUserSubscriptions(@PathVariable Long userId) {
        var findedList = this.subService.findAllSubscriptionByUserId(userId);
        return new ResponseEntity<>(findedList, HttpStatus.OK);
    }

    @DeleteMapping("/{subId}")
    public ResponseEntity<Subscription> deleteSubscription(@PathVariable Long userId, @PathVariable Long subId) {
        var deleted = subService.deleteSubscriptionById(userId, subId);
        return getResponseEntity(this.subService.deleteSubscriptionById(userId, subId), HttpStatus.OK, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Subscription> getResponseEntity(Optional<Subscription> subscription, HttpStatus ok, HttpStatus notFound) {
        return new ResponseEntity<>(
                subscription.orElse(new Subscription()),
                subscription.isPresent() ? ok : notFound
        );
    }

}
