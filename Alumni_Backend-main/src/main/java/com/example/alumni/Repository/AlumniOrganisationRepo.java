package com.example.alumni.Repository;

import com.example.alumni.DTO.GetIdAndName;
import com.example.alumni.Entity.Alumni;
import com.example.alumni.Entity.AlumniEducation;
import com.example.alumni.Entity.AlumniOrganisation;
import com.example.alumni.Entity.Organisations;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Transactional
public interface AlumniOrganisationRepo extends JpaRepository<AlumniOrganisation,Long> {

    @Query("select o from Organisations o where o.name=:name")
    Organisations get_org_id(String name);

    @Query("select o from Alumni o where o.alumni_id=:id")
    Alumni get_alumni_id(Long id);

    @Query("select o from Organisations o")
    List<Organisations> getallorg();

    @Query("select o from AlumniOrganisation o join fetch o.organisation where o.alumni.alumni_id = :id")
    List<AlumniOrganisation> getallposition(Long id);

    @Query("select o from AlumniOrganisation o join fetch o.organisation where o.gen_id = :id")
    List<AlumniOrganisation> getDetailById(Long id);

    @Query("select o.organisation from AlumniOrganisation o where o.alumni.alumni_id=:id")
    List<Organisations> getallOrganisation(Long id);

    @Query("select o from AlumniOrganisation a,Organisations o where a.alumni.alumni_id=:id and o.organisation_id=a.organisation.organisation_id")
    List<Organisations> getspecorg(Long id);

    @Modifying
    @Query( "DELETE FROM AlumniOrganisation ao WHERE ao.alumni.alumni_id = :id AND ao.organisation.organisation_id = :org_id AND ao.position=:position")
    void delete_org_by_id(Long id, Long org_id,String position);

    @Modifying
    @Query("UPDATE AlumniOrganisation ao SET ao.position=:position, ao.joiningDate=:joinDate, ao.leavingDate=:leaveDate WHERE ao.alumni.alumni_id=:id and ao.organisation.name=:org_name")
    void update_alumni_details(@Param("id") Long id, @Param("org_name") String org_name, @Param("position") String position, @Param("joinDate") LocalDate joinDate, @Param("leaveDate") LocalDate leaveDate);

}
