package com.danamon.project.page;

import com.danamon.project.util.GlobalFunction;
import org.openqa.selenium.*;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.*;
import java.time.Duration;

public class ModificationPage {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = "a[href*='ViewDataTransaksiOutgoing'][href*='id=1003187']")
    public WebElement trxview;
    @FindBy(xpath = "//input[@id='_010_mf20_sender_reference']")
    private WebElement tag20;
    @FindBy(xpath = "//input[@id='btn-validate']")
    private WebElement klikbuttonvalidate;
    @FindBy(xpath = "//input[@id='submit_mt']")
    private WebElement klikbuttonsubmit;

    public ModificationPage(WebDriver driver) {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(this.driver,this);
    }
    //View TRX
    public void ViewTRXMOD() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(trxview)).click();
    }
    //Input Reference
    public void TAG20(String reference){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(tag20)).sendKeys(reference);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    //klik Button Validate
    public void clickValidateButton() {
        try {
            // 1. Tangani alert terlebih dahulu SEBELUM mencari element
            handleAlertIfPresent();

            // 2. Sekarang cari element btn-validate
            WebElement validateButton = driver.findElement(By.xpath("//input[@id='btn-validate']"));
            validateButton.click();

            // 3. Tangani alert yang mungkin muncul setelah klik
            handleAlertIfPresent();

        } catch (UnhandledAlertException e) {
            System.out.println("Alert blocked operation: " + e.getAlertText());
            forceHandleAlert();
        }
    }

    private void handleAlertIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String alertText = alert.getText();
            System.out.println("Alert detected: " + alertText);

            if (alertText.contains("All inputs are valid!")) {
                System.out.println("✅ Accepting validation alert");
                alert.accept();
            } else {
                System.out.println("⚠️ Unexpected alert, accepting anyway");
                alert.accept();
            }

        } catch (Exception e) {
            // No alert present, continue silently
            System.out.println("No alert present");
        }
    }

    private void forceHandleAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Force handling alert: " + alert.getText());
            alert.accept();
            Thread.sleep(1000); // Tunggu sebentar setelah handle alert
        } catch (Exception e) {
            System.out.println("No alert to force handle");
        }
    }
    //klik Button Validate
    public void btnSubmit() {
        try {
            // 1. Tangani alert terlebih dahulu SEBELUM mencari element
            handleAlertIfPresent();

            // 2. Sekarang cari dan klik element button submit
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(klikbuttonsubmit)).click();

            // 3. Tangani alert yang mungkin muncul setelah klik
            handleAlertIfPresent();

        } catch (UnhandledAlertException e) {
            System.out.println("Alert blocked operation: " + e.getAlertText());
            forceHandleAlert();
        }
    }
}
