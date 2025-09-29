package com.danamon.project.scenariomapping;

/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 23/09/2025 12:04
@Last Modified 23/09/2025 12:04
Version1.0
*/
public enum SkenarioCreateUser {
    T1("CMT001 Login Message"),
    T2("CMT002 Create Message MT103"),
    T3("CMT003 VER Message MT103"),
    T4("CMT004 MOD Message MT103"),
    T5("CMT003 AUTH Message MT103");
    private String testName;
    private SkenarioCreateUser(String value) {
        testName = value;
    }

    public String getTestName() {
        return testName;
    }
}
