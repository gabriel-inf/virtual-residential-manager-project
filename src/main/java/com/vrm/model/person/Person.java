package com.vrm.model.person;

public class Person{

    private String name;
    private int floor;


    public Person(){


    }


    public Person(String name, int floor){
        this.name = name;
        this.floor = floor;
    }

    /**
     * @return the floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}