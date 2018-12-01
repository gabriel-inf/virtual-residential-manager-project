package com.vrm.controller;

import java.util.ArrayList;

import com.vrm.data.Database;
import com.vrm.model.Person;
import com.vrm.model.User;
import com.vrm.model.Visitor;
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

    private ArrayList<Person> authorizedPeople;
    private ArrayList<Person> enteringPeople;

    @PutMapping
    public String openGate(@RequestParam Integer c) throws Exception {

        authorizedPeople = new ArrayList<>();
        enteringPeople = new ArrayList<>();

        Database.getInstance().cleanLog();
        this.authorizedPeople.addAll(Database.getInstance().getAllUsers());

        

        switch (c) {
        case 1:

            this.enteringPeople.add(Database.getInstance().getAllUsers().get(0));
            Database.getInstance().log("Entering " + this.enteringPeople.size() + " people");
            this.gateService.openGateService(this.authorizedPeople, this.enteringPeople);

            return Database.getInstance().getLogs();

        case 2:

            Visitor visitor = Database.getInstance().getAllVisitors().get(0);
            User user = Database.getInstance().getAllUsers().get(1);

            gateService.sendNotification(10);

            this.enteringPeople.add(visitor);

            gateService.answerNotification(true, visitor, this.enteringPeople, 10);

            return Database.getInstance().getLogs();

        default:
            return "";

        }

    }

}