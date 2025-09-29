package com.danamon.project.impl;
/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 07/05/2025 15:28
@Last Modified 07/05/2025 15:28
Version1.0
*/
import com.danamon.project.connection.Constants;
import com.danamon.project.connection.DriverSingleton;
import com.danamon.project.scenariomapping.SkenarioCreateUser;
import com.danamon.project.util.GlobalFunction;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class LoginOutlineHooks {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static ExtentReports reports = new ExtentReports(GlobalFunction.rootProject + "/practiceautomation-report/extentreport/login.html");
    private static SkenarioCreateUser[] tests = SkenarioCreateUser.values();
    private static final int[] DATA_OUTLINE = {1, 1, 1, 1, 1, 1};
    private String testReport = "";

    @Before
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        testReport = tests[GlobalFunction.testCount].getTestName();
        extentTest = reports.startTest(testReport);
        if (GlobalFunction.countOutline == DATA_OUTLINE[GlobalFunction.testCount]) {
            GlobalFunction.countOutline = 0;
            GlobalFunction.testCount++;
        }
        GlobalFunction.countOutline++;
    }

    @AfterStep
    public void getResultStatus(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String screenshotPath = GlobalFunction.getScreenshot(driver, "PTA_LoginOutlineHooks" + scenario.getName().replace(" ", "_"));
            extentTest.log(LogStatus.FAIL, scenario.getName() + "\n"
                    + extentTest.addScreenCapture(screenshotPath));
            ;
        }
    }

    @After
    public void closeObject() {
        reports.endTest(extentTest);
        reports.flush();
    }

    @AfterAll
    public static void closeBrowser() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY, Constants.GLOB_PARAM_DELAY);
        DriverSingleton.closeObjectInstance();
    }
}