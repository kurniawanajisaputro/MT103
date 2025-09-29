package com.danamon.project.util;

/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 23/09/2025 12:04
@Last Modified 23/09/2025 12:04
Version1.0
*/
public class CountPressingTime {
    private static long startProcessing = 1L;
    private static long startProcessingTwo = 1L;
    private static long endProcessing = 1L;
    private static long endProcessingTwo = 1L;

    public static void start (String processName) {
        System.out.println("Proses "+processName+" Dimulai");
        startProcessing = System.currentTimeMillis();
    }

    public static long startWithReturn () {
        startProcessingTwo = System.currentTimeMillis();
        return startProcessingTwo;
    }

    public static void end(){
//        endProcessing = (System.currentTimeMillis()-startProcessing)/1000;
        endProcessing = (System.currentTimeMillis()-startProcessing);
        System.out.println("Selesai Dalam "+endProcessing+" ms");
    }

    public static long endWithReturn(){
        return endProcessingTwo = (System.currentTimeMillis()-startProcessingTwo);
    }

}
