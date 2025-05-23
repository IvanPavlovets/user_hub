package com.webraise.userapi.model;

/**
 * User DTO for HTTP Request
 * @param name
 * @param email
 */
public record UserRequest(String name, String email) {
}
