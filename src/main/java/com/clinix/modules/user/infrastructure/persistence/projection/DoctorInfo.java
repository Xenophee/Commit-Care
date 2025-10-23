package com.clinix.modules.user.infrastructure.persistence.projection;

import io.quarkus.hibernate.orm.panache.common.ProjectedFieldName;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.UUID;

@RegisterForReflection
public class DoctorInfo {

    public UUID id;
    public String email;
    public String firstname;
    public String lastname;
    public String officeNumber;
    public String licenseNumber;

    public DoctorInfo(UUID id, String email, String firstname, String lastname,
                      @ProjectedFieldName("doctor.officeNumber") String officeNumber,
                      @ProjectedFieldName("doctor.licenseNumber") String licenseNumber) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.officeNumber = officeNumber;
        this.licenseNumber = licenseNumber;
    }
}
