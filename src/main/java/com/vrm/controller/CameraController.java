package com.vrm.controller;


import org.springframework.web.bind.annotation.GetMapping;
import com.vrm.model.Person;
import com.vrm.service.CameraService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PutMapping
    public boolean identifyCameraAction(@RequestBody Person p, @RequestParam Integer camId) throws Exception {
        Database.getInstance().cleanLog();
        Database.getInstance().log("-> Camera " + camId + " identifies a person " + p.getName());

        try {
            this.camService.identifyPerson(p, camId);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}