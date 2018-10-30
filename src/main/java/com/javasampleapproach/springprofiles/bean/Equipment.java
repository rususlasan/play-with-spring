package com.javasampleapproach.springprofiles.bean;

/**
 * Created by ruslansh on 10/30/18.
 */
public class Equipment {

    String eq;

    public Equipment(String eq) {
        this.eq = eq;
    }

    public String getEq() {
        return eq;
    }

    public void setEq(String eq) {
        this.eq = eq;
    }

    @Override
    public String toString() {
        return this.eq;
    }
}
