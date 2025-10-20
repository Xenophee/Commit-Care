package com.clinix.modules.user.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
    @NamedQuery(
            name = "UserEntity.findByUUID",
            query = """
                    SELECT user.id as id, user.email as email, user.firstname as firstname, user.lastname as lastname
                    FROM UserEntity user
                    WHERE user.id = :id
                """
    )
})
public class UserEntity {

    public static final String FIND_BY_UUID = "UserEntity.findByUUID";

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public UUID getId() {
        return id;
    }

    public UserEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public UserEntity setFirstname(String firstName) {
        this.firstname = firstName;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UserEntity setLastname(String lastName) {
        this.lastname = lastName;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UserEntity setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public UserEntity setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
