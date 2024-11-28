package com.example.alumni.Service;


import com.example.alumni.Entity.Alumni;
import com.example.alumni.Entity.AlumniEducation;
import com.example.alumni.Entity.AlumniOrganisation;
import com.example.alumni.Entity.Organisations;
import com.example.alumni.Repository.AlumniEducationRepo;
import com.example.alumni.Repository.AlumniOrganisationRepo;
import com.example.alumni.Repository.AlumniRepo;
import com.example.alumni.Repository.OrganisationsRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class AlumniService {

    @Autowired
    private AlumniRepo alumniRepo;
    @Autowired
    private AlumniOrganisationRepo alumniOrganisationRepo;

    @Autowired
    private AlumniEducationRepo alumniEducationRepo;

    @Autowired
    private OrganisationsRepo organisationsRepo;


    @Transactional
    public void saveDetails(Long id, String org_name, String address, String position, LocalDate join_date,LocalDate leave_date)
    {
       Organisations organisations = alumniOrganisationRepo.get_org_id(org_name);

        // If the organization does not exist, create a new one
        if (organisations == null) {
            organisations = new Organisations();
            organisations.setAddress(address);
            organisations.setName(org_name);
            organisationsRepo.save(organisations);
        }

        Alumni alumni=alumniOrganisationRepo.get_alumni_id(id);
        AlumniOrganisation alumniOrganisation=new AlumniOrganisation();

        alumniOrganisation.setAlumni(alumni);
        alumniOrganisation.setOrganisation(organisations);
        alumniOrganisation.setPosition(position);
        alumniOrganisation.setJoiningDate(join_date);
        alumniOrganisation.setLeavingDate(leave_date);

        alumniOrganisationRepo.save(alumniOrganisation);
    }
    public List<Organisations> getDetails()
    {
         List<Organisations> allOrg = alumniOrganisationRepo.getallorg();

         return allOrg;
    }
    public List<AlumniOrganisation> getposition(Long id) {
        return alumniOrganisationRepo.getallposition(id);
    }

    public List<AlumniOrganisation> getDetailById(Long id){
        return alumniOrganisationRepo.getDetailById(id);
    }

    public List<Organisations> getAllOrganisation(Long id)
    {
        List<Organisations> allOrg = alumniOrganisationRepo.getallOrganisation(id);

        return allOrg;
    }

    public List<Organisations> getSpecificOrg(Long id)
    {
        List<Organisations> allOrg = alumniOrganisationRepo.getspecorg(id);

        return allOrg;
    }

    public List<Alumni> getAlumniData(Long id)
    {
        List<Alumni> allAlumni = alumniRepo.findAllById(Collections.singleton(id));

        return allAlumni;
    }
    public List<AlumniEducation> getSpecificEducation(Long id)
    {
        List<AlumniEducation> alumniEdu = alumniEducationRepo.getSpecEdu(id);

        return alumniEdu;
    }

    public void deleteOrg(Long id, Long org_id,String position)
    {
        alumniOrganisationRepo.delete_org_by_id(id,org_id,position);
    }

    public void updateOrg(Long id, String org_name, String position, LocalDate join_date,LocalDate leave_date)
    {
        System.out.println("Alumni ID : "+id+" Org_name: "+org_name+" postion :"+position+" join_data : "+join_date+" leave_data : "+leave_date)   ;
        alumniOrganisationRepo.update_alumni_details(id,org_name,position,join_date,leave_date);
    }
    public void updateContact(Long id,String contact)
    {
        Optional<Alumni> alumni = alumniRepo.findById(id);

        alumni.get().setContactNumber(contact);
        alumniRepo.save(alumni.get());
    }

    public void update_alumni_education(Long id, String collegeName, String degree,Integer joinYear , Integer leaveYear, String address)
    {
       alumniEducationRepo.update_alumni_education_details(id,collegeName,degree,joinYear,leaveYear,address);
    }

}
