package com.example.alumni.DTO;

import jakarta.annotation.Nullable;

import java.time.LocalDate;
import java.util.Date;

public class AddAlumniOrganisation {
   public  Long alumni_id;
    public String org_name;

    public String address;

    public String position;

    public LocalDate start_date;

    @Nullable
    public  LocalDate leaving_date;


}


