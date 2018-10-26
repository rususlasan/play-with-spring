package com.javasampleapproach.springprofiles.bean;


import org.springframework.beans.factory.annotation.Value;


public class Data {

    @Value("${some.important.value}")
    public int VALUE_FROM_PROPERTY_FILE;

    private String config;

    public Data() {}

    public Data(String config) {
        this.config = config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getConfig() {

        return config;
    }
}
