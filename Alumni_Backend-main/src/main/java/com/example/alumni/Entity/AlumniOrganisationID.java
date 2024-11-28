package com.example.alumni.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class AlumniOrganisationID implements Serializable {
    private Long organisation_id;
    private Long alumni_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumniOrganisationID that = (AlumniOrganisationID) o;
        return Objects.equals(organisation_id, that.organisation_id) && Objects.equals(alumni_id, that.alumni_id);
    }

    public Long getOrganisation_id() {
        return organisation_id;
    }

    public void setOrganisation_id(Long organisation_id) {
        this.organisation_id = organisation_id;
    }

    public Long getAlumni_id() {
        return alumni_id;
    }

    public void setAlumni_id(Long alumni_id) {
        this.alumni_id = alumni_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(organisation_id, alumni_id);
    }
}
