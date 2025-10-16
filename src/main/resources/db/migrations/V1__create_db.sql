-- Activer l’extension pour Uuid
CREATE EXTENSION IF NOT EXISTS pgcrypto;


---------------------------------------------------
-- Créer la table des spécialités médicales
---------------------------------------------------

CREATE TABLE specialities
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50)  NOT NULL UNIQUE,
    description VARCHAR(200) NOT NULL
);

---------------------------------------------------
-- Créer la table des maladies
---------------------------------------------------

CREATE TABLE diseases
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL UNIQUE,
    description TEXT        NOT NULL,
    treatment   TEXT        NOT NULL
);


---------------------------------------------------
-- Créer la table des associations entre les spécialités et les maladies
---------------------------------------------------

CREATE TABLE speciality_diseases
(
    disease_id     INTEGER NOT NULL REFERENCES diseases (id) ON DELETE CASCADE,
    speciality_id INTEGER NOT NULL REFERENCES specialities (id) ON DELETE RESTRICT,
    PRIMARY KEY (disease_id, speciality_id)
);

---------------------------------------------------
-- Créer la table des rôles
---------------------------------------------------

CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

---------------------------------------------------
-- Créer la table des utilisateurs
---------------------------------------------------

CREATE TABLE users
(
    id         UUID                  DEFAULT gen_random_uuid() PRIMARY KEY,
    email      VARCHAR(150) NOT NULL UNIQUE,
    password   VARCHAR(250) NOT NULL,
    firstname  VARCHAR(70)  NOT NULL,
    lastname   VARCHAR(70)  NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

---------------------------------------------------
-- Créer la table des praticiens
---------------------------------------------------

CREATE TABLE doctors
(
    user_id        UUID PRIMARY KEY NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    speciality_id  INTEGER          NOT NULL REFERENCES specialities (id) ON DELETE RESTRICT,
    license_number VARCHAR(20)      NOT NULL UNIQUE,
    office_number  VARCHAR(10)      NOT NULL UNIQUE,
    created_at     TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP
);

---------------------------------------------------
-- Créer la table des patients
---------------------------------------------------

CREATE TABLE patients
(
    user_id    UUID PRIMARY KEY NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    gender     CHAR(1)          NOT NULL CHECK (gender IN ('M', 'F')),
    birthdate  DATE             NOT NULL,
    address    VARCHAR(255)     NOT NULL,
    phone      VARCHAR(20)      NOT NULL,
    created_at TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);


---------------------------------------------------
-- Créer la table des types de chirurgie
---------------------------------------------------

CREATE TABLE surgery_types
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(50)  NOT NULL UNIQUE,
    description     VARCHAR(200) NOT NULL,
    duration_minute INTEGER      NOT NULL CHECK (duration_minute > 0),
    operating_room  VARCHAR(5)   NOT NULL
);

---------------------------------------------------
-- Créer la table des rendez-vous
---------------------------------------------------

CREATE TABLE appointments
(
    id              UUID                 DEFAULT gen_random_uuid() PRIMARY KEY,
    doctor_id       UUID        REFERENCES doctors (user_id) ON DELETE SET NULL,
    patient_id      UUID        REFERENCES patients (user_id) ON DELETE SET NULL,
    scheduled_start TIMESTAMP   NOT NULL,
    status          VARCHAR(20) NOT NULL CHECK (status IN ('PLANIFIÉ', 'TERMINÉ', 'ANNULÉ')),
    created_at      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP
);

---------------------------------------------------
-- Créer la table des interventions chirurgicales
---------------------------------------------------

CREATE TABLE surgeries
(
    appointments_id UUID PRIMARY KEY NOT NULL REFERENCES appointments (id) ON DELETE CASCADE,
    surgery_type_id INTEGER          NOT NULL REFERENCES surgery_types (id) ON DELETE RESTRICT,
    notes           TEXT
);

---------------------------------------------------
-- Créer la table des consultations
---------------------------------------------------

CREATE TABLE consultations
(
    appointments_id UUID PRIMARY KEY NOT NULL REFERENCES appointments (id) ON DELETE CASCADE,
    diagnosis       TEXT             NOT NULL
);

---------------------------------------------------
-- Créer la table des maladies associées aux consultations
---------------------------------------------------

CREATE TABLE consultation_diseases
(
    diseases_id      INTEGER NOT NULL REFERENCES diseases (id) ON DELETE RESTRICT,
    consultations_id UUID    NOT NULL REFERENCES consultations (appointments_id) ON DELETE CASCADE,
    PRIMARY KEY (diseases_id, consultations_id)
);


---------------------------------------------------
-- Créer la table des dossiers médicaux
---------------------------------------------------
CREATE TABLE medical_records
(
    patient_id  UUID PRIMARY KEY NOT NULL REFERENCES patients (user_id) ON DELETE CASCADE,
    blood_group VARCHAR(3)       NOT NULL CHECK (blood_group IN ('A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-')),
    height_cm   INTEGER          NOT NULL CHECK (height_cm > 0),
    weight_kg   INTEGER          NOT NULL CHECK (weight_kg > 0),
    created_at  TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP
);


---------------------------------------------------
-- Créer la table des notes de suivi médical
---------------------------------------------------
CREATE TABLE medical_notes
(
    id                UUID               DEFAULT gen_random_uuid() PRIMARY KEY,
    medical_record_id UUID      NOT NULL REFERENCES medical_records (patient_id) ON DELETE CASCADE,
    note              TEXT      NOT NULL,
    created_at        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


---------------------------------------------------
-- Créer la table d'association entre les utilisateurs et les rôles
---------------------------------------------------

CREATE TABLE user_roles
(
    user_id UUID    NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    role_id INTEGER NOT NULL REFERENCES roles (id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);



CREATE INDEX idx_users_email ON users (email);
CREATE INDEX idx_appointments_date_time ON appointments (scheduled_start);