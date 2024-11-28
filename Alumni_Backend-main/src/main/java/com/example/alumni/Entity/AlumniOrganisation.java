package com.example.alumni.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alumni_organisation")
public class AlumniOrganisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gen_id;

    @Column(name = "position")
    private String position;

    @Column(name = "joining_date", nullable = false)
    private LocalDate joiningDate;

    @Column(name = "leaving_date")
    private LocalDate leavingDate;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alumni_id", referencedColumnName = "alumni_id", nullable = false)
    private Alumni alumni;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organisation_id", referencedColumnName = "organisation_id", nullable = false)
    private Organisations organisation;

    // Getter method to retrieve organisation_id
    public String getOrganisationName() {
        return organisation != null ? organisation.getName() : null;
    }
    public Long getOrganisationId(){ return organisation != null ? organisation.getOrganisation_id() : null; }
}
