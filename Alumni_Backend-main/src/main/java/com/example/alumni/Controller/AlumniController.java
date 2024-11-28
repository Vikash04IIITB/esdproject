package com.example.alumni.Controller;


import com.example.alumni.DTO.*;
import com.example.alumni.Entity.Alumni;
import com.example.alumni.Entity.AlumniEducation;
import com.example.alumni.Entity.AlumniOrganisation;
import com.example.alumni.Entity.Organisations;
import com.example.alumni.Service.AlumniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AlumniController {
    @Autowired
    private AlumniService alumniService;


    @PostMapping("/addAlumniOrg/")
    public void postDetails(@RequestBody AddAlumniOrganisation addAlumniOrganisation)
    {
        alumniService.saveDetails(addAlumniOrganisation.alumni_id,addAlumniOrganisation.org_name, addAlumniOrganisation.address,addAlumniOrganisation.position,addAlumniOrganisation.start_date,addAlumniOrganisation.leaving_date);
    }

    @GetMapping("/getPosition/{id}")
    public List<AlumniOrganisation> getposition(@PathVariable Long id) {
        System.out.println("Get Position ID: " + id);
        List<AlumniOrganisation> org = alumniService.getposition(id);
        return org;
    }


    @GetMapping ("/getOrg/{id}")
    public List<Organisations>getorgofalumni(@PathVariable Long id)
    {
        List<Organisations> orgList = alumniService.getSpecificOrg(id);
        return orgList;
    }
    @GetMapping ("/getAlumni/{id}")
    public List<Alumni> getDetailofAlumni(@PathVariable Long id)
    {
       List<Alumni> alumni= alumniService.getAlumniData(id);
        return alumni;
    }
    @GetMapping ("/getAllOrg/{id}")
    public List<Organisations>getAllOrganisationofAlumni(@PathVariable Long id)
    {
        List<Organisations> orgList = alumniService.getAllOrganisation(id);
        return orgList;
    }
    @GetMapping("/getOrgDetailById/{id}")
    public List<AlumniOrganisation> getOrgDetailByID(@PathVariable Long id)
    {
        List<AlumniOrganisation> data = alumniService.getDetailById(id);
        return data;
    }

    @DeleteMapping ("/deleteAlumniOrg/")
    public void deleteDetails(@RequestBody GetIdAndName getnameid )
    {
        alumniService.deleteOrg(getnameid.alumni_id,getnameid.org_id,getnameid.position);
    }

    @PutMapping("/updateAlumniOrg/")
    public void updateDetails(@RequestBody UpdateDetail updateDetail)
    {
        alumniService.updateOrg(updateDetail.alumni_id,updateDetail.org_name,updateDetail.position,updateDetail.joiningDate,updateDetail.leavingDate) ;
    }

    @GetMapping ("/getEdu/{id}")
    public List<AlumniEducation>get_particular_education(@PathVariable Long id)
    {
        List<AlumniEducation> alumniEdu = alumniService.getSpecificEducation(id);
        return alumniEdu;
    }

   @PutMapping("/updateAlumniContact/")
    public void updateContact(@RequestBody UpdateContact updateContact)
    {
        System.out.println("Contact number and ID  : "+updateContact.contact_no+" "+updateContact.alumni_id);
        alumniService.updateContact(updateContact.alumni_id,updateContact.contact_no);
    }

    @PutMapping("/updateAlumniEducation/")
    public void updateEducation(@RequestBody UpdateEducation updateEducation)
    {
        alumniService.update_alumni_education(updateEducation.id,updateEducation.collegeName,updateEducation.degree,updateEducation.joiningYear,updateEducation.passingYear,updateEducation.address);
    }

    @GetMapping ("/showAllOrg/")
    public List<Organisations> getDetails()
    {
        List<Organisations> orgList = alumniService.getDetails();
        return orgList;
    }
}
