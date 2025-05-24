package com.webraise.userapi.model;

/**
 * User DTO for HTTP Response
 */
public record UserResponse(Long userId, String name, String password, String email) {
}
