package com.danamon.project.impl;

/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 07/05/2025 15:31
@Last Modified 07/05/2025 15:31
Version1.0
*/
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/main/resources/features/CMT001 Login Message.feature",
                "src/main/resources/features/CMT002 Create Message MT103.feature",
                "src/main/resources/features/CMT003 MOD VER AUTH MT103.feature"
        },
        glue = "com.danamon.project.impl",
        monochrome=true,
        plugin = {"pretty","html:target/PTA/htmlreport/LoginRunnerOutline.html",
                "json:target/PTA/jsonreport/LoginRunnerOutline.json",
                "junit:target/PTA/junitreport/LoginRunnerOutline.xml"})
public class LoginOutlineRunner extends AbstractTestNGCucumberTests{}
