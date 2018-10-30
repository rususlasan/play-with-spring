package com.javasampleapproach.springprofiles.bean;

/**
 * Created by ruslansh on 10/29/18.
 */
public class SuperHero {

    String name;

    Equipment equipment;

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public SuperHero(String name, Equipment equipment) {

        this.name = name;
        this.equipment = equipment;
    }

    public SuperHero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "My name is " + this.name + " and I have " + this.equipment.toString().toUpperCase();
    }
}
