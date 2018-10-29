package com.javasampleapproach.springprofiles.bean;

/**
 * Created by ruslansh on 10/29/18.
 */
public class SuperHero {

    String name;

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
        return "My name is " + this.name;
    }
}
