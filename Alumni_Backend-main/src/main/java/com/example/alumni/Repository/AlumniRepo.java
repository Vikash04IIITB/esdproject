package com.example.alumni.Repository;

import com.example.alumni.Entity.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlumniRepo extends JpaRepository<Alumni,Long> {
//    @Modifying
//    @Query(" Alumni a WHERE a.alumni_id = :id AND a.contactNumber=:contact_no AND a.email=:email and a.student.studentId")
//    public void update_alumni_contact(Long id, String email,String contact_no);

    @Query("SELECT a from Alumni a where a.email = :email")
    Alumni findByEmail(String email);

}
