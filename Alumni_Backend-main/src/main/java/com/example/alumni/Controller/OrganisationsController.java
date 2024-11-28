package com.example.alumni.Controller;

import com.example.alumni.Entity.Organisations;
import com.example.alumni.Service.OrganisationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrganisationsController {
    @Autowired
    private OrganisationsService organisationsService;

        @GetMapping("/showOrg")
    public List<Organisations> getDetails()
    {
        return  organisationsService.findAllOrganisations();
    }

    @PostMapping("/saveOrg")

    public void saveOrg(@RequestBody Organisations organisations)
    {
        organisationsService.createOrg(organisations);
    }


}
