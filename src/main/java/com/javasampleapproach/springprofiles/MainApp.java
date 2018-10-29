package com.javasampleapproach.springprofiles;

import com.javasampleapproach.springprofiles.bean.Data;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;


public class MainApp {

    public static void main(String args[]) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");

        System.out.println("=============================================================================" + System.getProperty("line.separator"));

        Data profileIndependent = (Data) context.getBean("profileIndependentBean");
        System.out.println(profileIndependent);

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

        // try to load bean from default profile
        try {
            Data dataBean = (Data) context.getBean("dataBean");
            System.out.println(dataBean.getConfig());
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("  ************** Could not find bean with name dataBean in [" + profiles + "] profiles");
        }

        try {
            Data beanFromAnotherXML = (Data) context.getBean("beanFromImportedXML");
            System.out.println(beanFromAnotherXML);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("  ************** Could not find bean with name beanFromImportedXML in [" + profiles + "] profiles");
        }

       // System.out.println("valueFromPropertyFile = " + profileIndependent.valueFromPropertyFile);
       // System.out.println("secondValue = " + profileIndependent.secondValue);
        //PropertyPlaceholderConfigurer ppc = (PropertyPlaceholderConfigurer) context.getBean("placeholderConfigurer");
        //System.out.println(ppc.SYSTEM_PROPERTIES_MODE_FALLBACK + " " + ppc.SYSTEM_PROPERTIES_MODE_NEVER + " " + ppc.SYSTEM_PROPERTIES_MODE_OVERRIDE);

    }

}
