package com.danamon.project;

/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 23/09/2025 12:04
@Last Modified 23/09/2025 12:04
Version1.0
*/
import io.cucumber.core.cli.Main;
public class RunningAll {
    public static void main(String[] args){
        try {
//            System.out.println("Path User Dir -> "+System.getProperty("user.dir"));
            Main.main(new String[]
                    {
                            "-g","com.danamon.project.impl",
                            "classpath:features",
                            "-p","pretty",
                            "-p","html:data-report/PTA/htmlreport/LoginRunnerOutline.html",
                            "-p","json:data-report/PTA/jsonreport/LoginRunnerOutline.json",
                            "-p","junit:data-report/PTA/junitreport/LoginRunnerOutline.xml",
                            "-m"
                    });
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Main Class Execption : "+e);
        }
    }
}
