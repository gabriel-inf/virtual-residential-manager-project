package com.vrm.controller;

import java.util.ArrayList;

import com.vrm.data.Database;
import com.vrm.model.Person;
import com.vrm.service.GateService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/gate")
public class GateController {

    private GateService gateService = new GateService();


    private ArrayList<Person> authorizedPeople = new ArrayList<>();
    private ArrayList<Person> enteringPeople = new ArrayList<>();
    

    @PutMapping
    public String openGate(@RequestParam Integer c) throws Exception {
        Boolean callAlarm = false;
        switch (c){
            case 1:
                this.authorizedPeople.addAll(Database.getInstance().getAllUsers());
                this.enteringPeople.add(Database.getInstance().getAllUsers().get(0));

                Database.getInstance().log("Entering " + this.enteringPeople.size() + " people");
                this.gateService.openGateService(this.authorizedPeople, this.enteringPeople);

                


                return Database.getInstance().getLogs();
            
            default:
                return "";

        }




    }

}