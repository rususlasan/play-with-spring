package com.javasampleapproach.springprofiles.bean;

/**
 * Created by ruslansh on 2/7/19.
 */
public class BeanWithFactoryMethod {

    private String address;
    private int port;
    private static String defaultAddress = "127.0.0.1";

    private BeanWithFactoryMethod(int port) {
        this.port = port;
        this.address = defaultAddress;
    }

    private BeanWithFactoryMethod(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public static BeanWithFactoryMethod createInstance(int port) {
        return new BeanWithFactoryMethod(port);
    }

    public static BeanWithFactoryMethod createInstance(String address, int port) {
        return new BeanWithFactoryMethod(address, port);
    }

    @Override
    public String toString() {
        return "BeanWithFactoryMethod{" +
                "address='" + address + '\'' +
                ", port=" + port +
                '}';
    }
}
