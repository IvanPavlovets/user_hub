package com.webraise.userapi.service;

import com.webraise.userapi.model.User;
import com.webraise.userapi.model.UserRecord;

import java.util.Optional;

/**
 * CRUD operations for User entity:
 * save - save User;
 * findById - get User by id;
 * update - update user;
 * deleteById - delete user by id.
 */
public interface UserService {
    Optional<User> save(User user);

    Optional<User> findById(long id);

    Optional<User> update(Long id, UserRecord user);

    Optional<User> deleteById(long userId);

}
