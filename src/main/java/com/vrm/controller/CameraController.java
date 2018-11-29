package com.vrm.controller;

import com.vrm.model.Person;
import com.vrm.service.CameraService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CameraController{

    CameraService camService = new CameraService();
    
    @PutMapping
    public void teste(Person p, Integer camId) throws Exception {
        
        
        camService.identifyPerson(p, camId);
    
    
    }

}