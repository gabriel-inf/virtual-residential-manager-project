package com.vrm.controller;

import com.vrm.model.Person;
import com.vrm.service.CameraService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.util.SystemInfo;

@RestController
public class CameraController{

    private CameraService camService = new CameraService();
    
    @PutMapping
    public void cameraIdentify(Person p, Integer camId) throws Exception {

        this.camService.identifyPerson(p, camId);
    
    }

}