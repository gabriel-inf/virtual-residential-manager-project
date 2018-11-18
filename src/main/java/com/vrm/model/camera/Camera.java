package com.vrm.model.camera;

import java.io.Console;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import com.vrm.enums.*;
import com.vrm.model.camera.recognition.Recognition;
import com.vrm.model.person.Person;



public class Camera {


    private State status; 
    private String network_address;
    //private Location location; 
    private Recognition recognition;


    public Camera(){
        this.recognition = new Recognition();
    }

    public Camera(String network_address){
        this.network_address = network_address;
    }

    public String checkInput(){
        
        String image = "xxxxxxxxxxxxxx";
        
        ArrayList<Person> recognizedPeople = new ArrayList<>();
        ArrayList<String> identidiedPeople = this.splitImageByPerson(image);


        System.out.println(identidiedPeople.toString());

        for (String personImage : identidiedPeople) {
            recognizedPeople.add(this.recognition.verifyPersonAuth(personImage));
        }

        System.out.println("Processing image " + image);
        

        return image;
    }

    /**
     * 
     * @param image
     * @return array of the images files that contains each person in the image separately
     */
    private ArrayList<String> splitImageByPerson(String image){

        Random r = new Random();
        ArrayList<String> splittedImagesAddresses = new ArrayList<>();

        int peopleInTheImage = r.nextInt(10);

        for (int i = 0; i < peopleInTheImage; i++){
            splittedImagesAddresses.add("person-" + i + ".jpg");
        }
        return splittedImagesAddresses;

    }




}