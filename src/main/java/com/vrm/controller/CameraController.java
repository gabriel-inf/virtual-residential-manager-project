package com.vrm.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.vrm.model.Person;
import com.vrm.service.CameraService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.util.SystemInfo;

@RestController
public class CameraController{

    private CameraService camService = new CameraService();
    
    @PostMapping("/api/camera/identify")
    public Person cameraIdentify(@RequestBody Person p, @RequestParam(name="camId", required=true) Integer camId) throws Exception {
    	
        return this.camService.identifyPerson(p, camId);
    
    }

}