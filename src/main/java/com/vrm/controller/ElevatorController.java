package com.vrm.controller;

import java.util.ArrayList;

import com.vrm.data.Database;
import com.vrm.model.Elevator;

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

}