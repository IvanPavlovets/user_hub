package com.webraise.userapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id must be non null")
    private Long id;

    @NotBlank(message = "name must be not empty")
    @Column(unique = true, name = "name")
    private String name;
    @NotBlank(message = "password must be not empty")
    @Column(name = "password")
    private String password;
    @NotBlank(message = "email must be not empty")
    @Column(name = "email")
    private String email;
}
