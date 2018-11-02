package com.javasampleapproach.springprofiles;

import com.javasampleapproach.springprofiles.bean.AnotherBean;
import com.javasampleapproach.springprofiles.bean.Data;
import com.javasampleapproach.springprofiles.bean.SuperHero;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;


public class MainApp {

    public static void main(String args[]) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");

        System.out.println("=============================================================================" + System.getProperty("line.separator"));

        Environment environment = context.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();
        System.out.println("Count of active profiles is : " + activeProfiles.length);
        String profiles = "";
        if (activeProfiles.length > 0) {
            System.out.println("These are:");
            for (String profile: activeProfiles) {
                profiles += profile + ", ";
            }
            profiles = profiles.substring(0, profiles.length() - 2);
            System.out.println(profiles);
        }

        String[] beanNames = new String[]{"profileIndependentBean", "beanFromImportedXML"};

        for (String name: beanNames) {
            try {
                Data dataBean = (Data) context.getBean(name);
                System.out.println(dataBean);
            } catch (NoSuchBeanDefinitionException e) {
                System.out.println("ERROR: could not found bean with name " + name);
            }
        }

        // try get superHero
        try {
            SuperHero hero = (SuperHero) context.getBean("superHero");
            System.out.println(hero);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("ERROR: could not found bean with name superHero");
        }

        AnotherBean anotherBean = (AnotherBean) context.getBean("anotherBeanClass");
        System.out.println("anotherBeanClass: " + anotherBean.getMyValue());
    }

}
