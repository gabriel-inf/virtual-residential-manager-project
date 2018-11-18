package com.vrm.controller.camera;

import com.vrm.model.camera.Camera;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CameraController{

    Camera cam1 = new Camera("1");
    
    @GetMapping
    public String teste(){
        return cam1.checkInput();
    }

}