package com.webraise.subscription.service;

import com.webraise.subscription.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "userapi", url = "${userapi-url}")
public interface UserServiceClient {

    @GetMapping("/{id}")
    Optional<User> findById(@PathVariable Long id);
}
