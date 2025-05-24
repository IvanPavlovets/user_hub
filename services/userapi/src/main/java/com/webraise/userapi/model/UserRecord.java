package com.webraise.userapi.model;

/**
 * User DTO for update endopoint
 * @param name
 * @param password
 * @param email
 */
public record UserRecord(String name, String password, String email) {
}
