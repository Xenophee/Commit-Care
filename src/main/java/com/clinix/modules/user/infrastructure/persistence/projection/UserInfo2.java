package com.clinix.modules.user.infrastructure.persistence.projection;

import java.util.UUID;

public class UserInfo2 {

    private UUID id;
    private String email;
    private String firstname;
    private String lastname;
    private DoctorInfo doctor;

    public UserInfo2(UUID id, String email, String firstname, String lastname, String officeNumber, String licenseNumber) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        if (officeNumber != null || licenseNumber != null) {
            this.doctor = new DoctorInfo(officeNumber, licenseNumber);
        }
    }

    public UserInfo2(UUID id, String email, String firstname, String lastname, DoctorInfo doctor) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.doctor = doctor;
    }

    // Getters
    public UUID getId() { return id; }
    public String getEmail() { return email; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public DoctorInfo getDoctor() { return doctor; }

    // DTO imbriqué
    public static class DoctorInfo {
        private String officeNumber;
        private String licenseNumber;

        public DoctorInfo(String officeNumber, String licenseNumber) {
            this.officeNumber = officeNumber;
            this.licenseNumber = licenseNumber;
        }

        public String getOfficeNumber() { return officeNumber; }
        public String getLicenseNumber() { return licenseNumber; }
    }
}
