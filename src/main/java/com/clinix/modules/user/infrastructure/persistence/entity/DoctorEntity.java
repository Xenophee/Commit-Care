package com.clinix.modules.user.infrastructure.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "user_id")
public class DoctorEntity extends UserEntity {

    @Column(name = "license_number", nullable = false, unique = true)
    private String licenseNumber;

    @Column(name = "office_number", nullable = false, unique = true)
    private String officeNumber;
}
