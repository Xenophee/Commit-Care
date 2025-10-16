CREATE OR REPLACE FUNCTION enforce_appointment_exclusivity()
    RETURNS TRIGGER AS
$$
BEGIN
    IF TG_TABLE_NAME = 'consultations' AND
       EXISTS (SELECT 1 FROM surgeries WHERE appointments_id = NEW.appointments_id) THEN
        RAISE EXCEPTION 'Le rendez-vous % est déjà enregistré comme chirurgie.', NEW.appointments_id;
    END IF;

    IF TG_TABLE_NAME = 'surgeries' AND
       EXISTS (SELECT 1 FROM consultations WHERE appointments_id = NEW.appointments_id) THEN
        RAISE EXCEPTION 'Le rendez-vous % est déjà enregistré comme consultation.', NEW.appointments_id;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


-- ---------------------------------------------------
CREATE TRIGGER trg_consult_exclusive
    BEFORE INSERT OR UPDATE
    ON consultations
    FOR EACH ROW
EXECUTE FUNCTION enforce_appointment_exclusivity();

CREATE TRIGGER trg_surgery_exclusive
    BEFORE INSERT OR UPDATE
    ON surgeries
    FOR EACH ROW
EXECUTE FUNCTION enforce_appointment_exclusivity();
