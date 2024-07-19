package com.itau.password.adapters.controller;

import com.itau.password.core.ports.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {
    private Password passwordPort;

    @Autowired
    PasswordController(Password passwordPort){
        this.passwordPort = passwordPort;
    }

    @PostMapping("/validate")
    ResponseEntity<Boolean> validatePassword(@RequestBody String password){
       return ResponseEntity.ok(passwordPort.validatePassword(password));
    }
}
