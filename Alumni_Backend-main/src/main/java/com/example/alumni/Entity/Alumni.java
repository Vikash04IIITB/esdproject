package com.example.alumni.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "alumni")
public class Alumni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumni_id")
    private Long alumni_id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "contact_number", unique = true, nullable = false)
    private String contactNumber;

    @Column(name = "password", nullable = false)
    private String password;


    @JsonIgnore
    @OneToMany(mappedBy = "alumni",cascade = CascadeType.ALL)
    private Set<AlumniOrganisation> alumniOrganisations ;



    @JsonIgnore
    @OneToMany(mappedBy = "alumni",cascade = CascadeType.ALL)
    private Set<AlumniEducation>alumniEducations ;






}