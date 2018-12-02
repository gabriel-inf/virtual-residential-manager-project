package com.vrm.controller;


import org.springframework.web.bind.annotation.GetMapping;

import com.vrm.model.Camera;
import com.vrm.model.Person;
import com.vrm.model.User;
import com.vrm.service.CameraService;
import com.vrm.service.ElevatorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.crypto.Data;

import com.vrm.data.Database;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/camera")
public class CameraController {

    private CameraService camService = new CameraService();

    /**
     * This method receives an array of people and retruns an array of identified
     * people
     * 
     * @param entring arraylist of people
     * @param camId   the camera that is processing the entry
     * @throws Exception
     */

    @GetMapping
    public String identifyCameraAction(@RequestBody Person p, @RequestParam Integer camId) throws Exception {
        Database.getInstance().cleanLog();
        Database.getInstance().log("-> Camera " + camId + " identifies a person " + p.getName());

        try {
            this.camService.identifyPerson(p, camId);
            return Database.getInstance().getLogs();
        } catch (Exception e) {
            return Database.getInstance().getLogs();
        }

    }


    @GetMapping("/callElevator")
    public String userGettingCloseToElevator() throws Exception {
        
        
        Database.getInstance().cleanLog();
        ElevatorService elevatorService = new ElevatorService();
        Integer areaFloor = 3;

        
        Database.getInstance().log("Case 1");
      

        Camera cameraThatIdentified = Database.getInstance().getAllCameras().get(0);
        User user = Database.getInstance().getAllUsers().get(0);
        elevatorService.userCallElevator(user, areaFloor, user.getFloor(), 10);



        return Database.getInstance().getLogs();

    }

}