package com.vrm.controller;

import com.vrm.model.camera.Elevator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElevatorController{

    Camera cam1 = new Camera("1");
    
    @GetMapping
    public String teste(){
        return cam1.checkInput();
    }

}