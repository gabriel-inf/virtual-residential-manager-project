package com.vrm.controller;

import java.util.ArrayList;

import com.vrm.model.Person;
import com.vrm.service.CameraService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.util.SystemInfo;

@RestController
public class CameraController{

    private CameraService camService = new CameraService();
    

    /**
     * This method receives an array of people and retruns an array of identified people
     * @param entring arraylist of people
     * @param camId the camera that is processing the entry
     * @throws Exception
     */

    @PutMapping
    public boolean identifyCameraAction(Person p, Integer camId) throws Exception {
        try {
            this.camService.identifyPerson(p, camId);
            return true; 
        } catch (Exception e) {
            return false;
        }
        
    }

}