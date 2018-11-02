package com.javasampleapproach.springprofiles.bean;


import org.springframework.beans.factory.annotation.Value;


public class Data {

    @Value("#{commonProperties['some.important.value']}")
    //@Value("${some.important.value}")
    public int valueFromPropertyFile;

    @Value("#{commonProperties['second.value']}")
    //@Value("F${second.value}")
    public String secondValue = "";

    private String config;

    public Data() {}

    public Data(String config) {
        this.config = config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Data(String config, int valueFromPropertyFile, String secondValue) {
        this.valueFromPropertyFile = valueFromPropertyFile;
        this.secondValue = secondValue;
        this.config = config;
    }

    public String getConfig() {

        return config;
    }

    @Override
    public String toString() {
        String vfpf = this.valueFromPropertyFile + "";
        return "-> [config=" + this.config +
                " valueFromPropertyFile=" + vfpf +
                " secondValue=" + this.secondValue + "]";
    }
}
