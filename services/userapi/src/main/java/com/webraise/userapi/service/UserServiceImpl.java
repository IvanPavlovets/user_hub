package com.webraise.userapi.service;

import com.webraise.userapi.model.User;
import com.webraise.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Слой бизнес обработки модели User
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Optional<User> save(User user) {
        Optional<User> result = Optional.empty();
        try {
            result = Optional.of(this.userRepository.save(user));
        } catch (Exception e) {
            log.error("Feedback save error: {}", e.getMessage());
        }
        return result;
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> update(Long id, User user) {
        var findedUser = userRepository.findById(id);
        if (findedUser.isPresent()) {
            User updatedUser = findedUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            return this.save(updatedUser);
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
