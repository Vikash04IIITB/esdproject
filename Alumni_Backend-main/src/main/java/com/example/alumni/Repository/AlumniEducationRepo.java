package com.example.alumni.Repository;

import com.example.alumni.Entity.AlumniEducation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Transactional
public interface AlumniEducationRepo extends JpaRepository<AlumniEducation,Long> {

    @Modifying
    @Query( "UPDATE AlumniEducation ae  SET ae.collegeName=:collegeName, ae.degree=:degree,ae.joiningYear=:joinYear,ae.passingYear=:leaveYear,ae.address=:address WHERE ae.alumni.alumni_id=:id")
    void  update_alumni_education_details(Long id, String collegeName, String degree,Integer joinYear , Integer leaveYear, String address);

    @Query("select ae from AlumniEducation ae where ae.alumni.alumni_id=:id")
    List<AlumniEducation> getSpecEdu(Long id);
}
