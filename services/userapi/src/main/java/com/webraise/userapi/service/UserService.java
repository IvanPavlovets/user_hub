package com.webraise.userapi.service;

import com.webraise.userapi.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> save(User user);

    Optional<User> findById(long id);

    Optional<User> update(User user);

    Optional<User> deleteById(long userId);

}
