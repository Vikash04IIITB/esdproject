package com.example.alumni.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "alumni_education")
public class AlumniEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "alumni_id", nullable = false)
    private Alumni alumni;

    @Column(name = "degree", nullable = false)
    private String degree;

    @Column(name = "passing_year", nullable = false)
    private Integer passingYear;

    @Column(name = "joining_year", nullable = false)
    private Integer joiningYear;

    @Column(name = "college_name")
    private String collegeName;

    @Column(name = "address")
    private String address;
}

