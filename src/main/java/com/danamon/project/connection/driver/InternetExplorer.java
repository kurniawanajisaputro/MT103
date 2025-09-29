package com.danamon.project.connection.driver;

/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 06/05/2025 19:20
@Last Modified 06/05/2025 19:20
Version1.0
*/
import com.danamon.project.connection.DriverStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorer implements DriverStrategy{
    @Override
    public WebDriver setStrategy() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();

        return driver;
    }
}
