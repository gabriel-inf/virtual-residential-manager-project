package com.vrm.controller;

import java.util.ArrayList;

import com.vrm.data.Database;
import com.vrm.model.Elevator;
import com.vrm.model.User;
import com.vrm.service.CameraService;
import com.vrm.service.ElevatorService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/elevator")
public class ElevatorController {

    @GetMapping("moveAll")
    public String moveAllElevators() throws Exception {

        Database.getInstance().cleanLog();
        Database.getInstance().log("Moving all Elevators");
        ArrayList<Elevator> elevators = Database.getInstance().getCondominiumElevators();

        for (Elevator elevator : elevators) {
            elevator.move();
        }
        return Database.getInstance().getLogs();

    }

    @GetMapping("/callElevator")
    public String userGettingCloseToElevator() throws Exception {

        Database.getInstance().cleanLog();
        ElevatorService elevatorService = new ElevatorService();

        Integer areaFloor = 13;

        Database.getInstance().log("Case 1");

        User user = Database.getInstance().getAllUsers().get(0);
        elevatorService.userCallElevator(user, areaFloor, user.getFloor(), 25);

        return Database.getInstance().getLogs();

    }

    @GetMapping("/jumpsWrongFloor")
    public String userJumpsWrongFlor() throws Exception {

        
        return Database.getInstance().getLogs();

    }

}