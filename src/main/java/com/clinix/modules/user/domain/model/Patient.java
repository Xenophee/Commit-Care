package com.clinix.modules.user.domain.model;

import com.clinix.modules.user.domain.valueobject.Email;
import com.clinix.modules.user.domain.valueobject.Gender;

import java.time.LocalDate;
import java.util.UUID;

public final class Patient extends User {

    private Gender gender;
    private LocalDate birthdate;
    private String address;
    private String phone;

    public Patient(UUID id, Email email, String passwordHash, String firstname, String lastname, Gender gender, LocalDate birthdate, String address, String phone) {
        super(id, email, passwordHash, firstname, lastname);
        this.gender = gender;
        this.birthdate = birthdate;
        this.address = address;
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
