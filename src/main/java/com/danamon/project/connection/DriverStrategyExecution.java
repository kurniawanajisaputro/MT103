package com.danamon.project.connection;

/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 06/05/2025 19:18
@Last Modified 06/05/2025 19:18
Version1.0
*/
import com.danamon.project.connection.driver.*;
public class DriverStrategyExecution {
    public static DriverStrategy chooseStrategy(String strategy) {

        switch (strategy) {
            case Constants.CHROME:
                return new Chrome();
            case Constants.FIREFOX:
                return new Firefox();
            case Constants.EDGE:
                return new Edge();
            case Constants.SAFARI:
                return new Safari();
            case Constants.IE:
                return new InternetExplorer();
            case Constants.OPERA:
                return new Opera();
            default:
                return null;
        }
    }
}
