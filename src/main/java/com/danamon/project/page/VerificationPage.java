package com.danamon.project.page;

/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 23/09/2025 12:04
@Last Modified 23/09/2025 12:04
Version1.0
*/
import com.danamon.project.connection.Constants;
import com.danamon.project.connection.DriverSingleton;
import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.*;
import java.time.Duration;

public class VerificationPage {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = "a[href*='ViewDataTransaksiOutgoing'][href*='id=1003198']")
    public WebElement trxview;

    @FindBy(how = How.CSS, using = "input#modified[name='modified']")
    public WebElement modifyButton;

    // XPath Selector untuk authorize button
    @FindBy(xpath = "//input[@id='authorized']")
    private WebElement authorizeButton;

    public VerificationPage(WebDriver driver) {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(this.driver,this);
    }
    //View TRX
    public void ViewTRXVER() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(trxview)).click();
    }
    //Button Modification
    public void BtnMod() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(modifyButton)).click();
    }

    public void BtnAuth() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(authorizeButton)).click();
    }
}
