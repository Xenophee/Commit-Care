package com.clinix.modules.user.infrastructure.persistence.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "doctors")
//@PrimaryKeyJoinColumn(name = "user_id")
public class DoctorEntity {

    @Id
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "license_number", nullable = false, unique = true)
    private String licenseNumber;

    @Column(name = "office_number", nullable = false, unique = true)
    private String officeNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId // permet de réutiliser le même ID que UserEntity
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
