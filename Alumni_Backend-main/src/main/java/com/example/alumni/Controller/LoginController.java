package com.example.alumni.Controller;

import com.example.alumni.Entity.Alumni;
import com.example.alumni.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;



    @PostMapping("/login")
    public Long loginCheck(@RequestBody Alumni alumni) {
//        System.out.println("Username : "+alumni.getEmail());
//        System.out.println("Password : "+alumni.getPassword());
        Long res = loginService.verifyLogin(alumni);
        if (res != 0) {
                return res;
        }
        else {
            return 0L;
        }
    }
}
