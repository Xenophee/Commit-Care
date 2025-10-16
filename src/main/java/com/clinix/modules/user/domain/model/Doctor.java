package com.clinix.modules.user.domain.model;

import com.clinix.modules.user.domain.valueobject.Email;

import java.util.UUID;

public final class Doctor extends User {

    private String licenseNumber;
    private String officeNumber;

    public Doctor(UUID id, Email email, String passwordHash, String firstname, String lastname, String licenseNumber, String officeNumber) {
        super(id, email, passwordHash, firstname, lastname);
        this.licenseNumber = licenseNumber;
        this.officeNumber = officeNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}
