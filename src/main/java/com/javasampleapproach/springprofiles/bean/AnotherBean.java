package com.javasampleapproach.springprofiles.bean;

import org.springframework.beans.factory.annotation.Value;

public class AnotherBean {

    @Value("#{commonProperties['some.important.value']}")
    public int myValue;

    public AnotherBean() {}

    public AnotherBean(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}
