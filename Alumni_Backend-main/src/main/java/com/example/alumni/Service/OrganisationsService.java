package com.example.alumni.Service;

import com.example.alumni.Entity.Organisations;
import com.example.alumni.Repository.OrganisationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationsService {

    @Autowired
    private OrganisationsRepo organisationsRepo;

    public List<Organisations> findAllOrganisations(){
        return organisationsRepo.findAll();
    }

    public Organisations findOrganisationsById(Long id) {
        Organisations organisations;
        organisations = organisationsRepo.findById(id).orElseThrow(() -> new RuntimeException("No organization"));
        return organisations;
    }


    public void createOrg(Organisations organisations)
    {
        organisationsRepo.save(organisations);
    }

    public void deleteOrg(Long id)
    {
        Organisations organisations;
        organisations = organisationsRepo.findById(id).orElseThrow(() -> new RuntimeException("No organization"));
        organisationsRepo.deleteById(organisations.getOrganisation_id());
    }




}
