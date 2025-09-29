package com.danamon.project.connection;

/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 23/09/2025 12:04
@Last Modified 23/09/2025 12:04
Version1.0
*/
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;

    private DriverSingleton(String driver) {
        instantiate(driver);
    }

    public WebDriver instantiate(String strategy) {
        DriverStrategy driverStrategy = DriverStrategyExecution.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static DriverSingleton getInstance(String driver) {
        if (instance == null) {
            instance = new DriverSingleton(driver);
        }

        return instance;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeObjectInstance() {
        instance = null;
        try {
            driver.quit();
        } catch (NullPointerException e) {
            System.out.println("END!!");
//            	getInstance(Constants.CHROME);
        }
//        driver.quit();
    }
}
