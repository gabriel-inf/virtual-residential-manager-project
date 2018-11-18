package com.vrm.model.camera.recognition;

import java.util.ArrayList;
import java.util.Random;

import com.vrm.model.person.Person;

public class Recognition {

    private ArrayList<Person> knownPeople = new ArrayList<>();
    

    public Recognition(){
        Person p1 = new Person("Gabriel", 1);
        Person p2 = new Person("Andrea", 2);
        Person p3 = new Person("Giusepe", 3);
        Person p4 = new Person("Eder", 4);

        this.knownPeople.add(p1);
        this.knownPeople.add(p2);
        this.knownPeople.add(p3);
        this.knownPeople.add(p4);

        System.out.println(knownPeople.get(0).getName());

    }


    public Person verifyPersonAuth(String personImage){

        // we would have here a method from some image processing lib to match the image with the known people database
        Random r = new Random();
        
        // will recognize in 90%
        if (r.nextFloat() < 0.9){
            return this.knownPeople.get(0); //TODO: change to randomize
        }
        return null;
    }


}