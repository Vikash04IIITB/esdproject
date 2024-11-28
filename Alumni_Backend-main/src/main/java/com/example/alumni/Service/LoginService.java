package com.example.alumni.Service;

import com.example.alumni.Entity.Alumni;
import com.example.alumni.Repository.AlumniRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AlumniRepo alumniRepo;

    public Long verifyLogin(Alumni login) {
        // Retrieve Login from the database based on the provided username
//        System.out.println(login.getEmail());
//        System.out.println(login.getPassword());
        Alumni storedLogin = alumniRepo.findByEmail(login.getEmail());
//        System.out.println("stored id: " + storedLogin.getEmail());
//        System.out.println("stored pass: " + storedLogin.getPassword());

        // Check if Login exists and the provided password matches the stored password
//        System.out.println("Login : "+(login.getPassword().equals(storedLogin.getPassword())));
        Long response = 0L;
        if(login.getPassword().equals(storedLogin.getPassword()))
        {
//            System.out.println("Alumni id is "+storedLogin.getAlumni_id());
            response = storedLogin.getAlumni_id();
        }
        return response;
    }
}
