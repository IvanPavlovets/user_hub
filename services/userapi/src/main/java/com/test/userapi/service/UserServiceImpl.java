package com.test.userapi.service;

import com.test.userapi.model.User;
import com.test.userapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Слой бизнес обработки модели User
 */
@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public Optional<User> save(User user) {
        Optional<User> result = Optional.empty();
        try {
            result = Optional.of(this.userRepository.save(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> update(User user) {
        var findedUser = userRepository.findById(user.getId());
        if (findedUser.isPresent()) {
            userRepository.save(user);
        }
        return findedUser;
    }

    @Override
    public Optional<User> deleteById(long userId) {
        var findedUser = userRepository.findById(userId);
        if (findedUser.isPresent()) {
            userRepository.deleteById(userId);
        }
        return findedUser;
    }

}
