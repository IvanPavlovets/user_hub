package com.test.userapi.controller;

import com.test.userapi.model.User;
import com.test.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * контроллер описывает CRUD операции
 * и построен по схеме Rest архитектуры:
 * POST /users/ - создает пользователя.
 * GET /users/{id} - получить пользователь по id.
 * PUT /users/{id} - обновляет пользователя.
 * DELETE /users/{id} - удаляет.
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService users;

    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user) {
        return getResponseEntity(this.users.save(user), HttpStatus.CREATED, HttpStatus.CONFLICT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id) {
        return getResponseEntity(this.users.findById(id), HttpStatus.OK, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/")
    public ResponseEntity<User> update(@RequestBody User user) {
        return getResponseEntity(this.users.save(user), HttpStatus.OK, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable int id) {
        return getResponseEntity(this.users.deleteById(id), HttpStatus.OK, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<User> getResponseEntity(Optional<User> user, HttpStatus ok, HttpStatus
            notFound) {
        return new ResponseEntity<User>(
                user.orElse(new User()),
                user.isPresent() ? ok : notFound
        );
    }

}
