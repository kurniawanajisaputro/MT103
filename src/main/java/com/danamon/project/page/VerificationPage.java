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
import org.openqa.selenium.*;
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

    @FindBy(xpath = "//a[normalize-space()='TESAUTOMATION20']")
    public WebElement trxview;

    @FindBy(xpath = "//input[@id='modified']")
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

    public void BtnAuth() {
        try {
            // 1. Tangani alert terlebih dahulu SEBELUM mencari element
            handleAlertIfPresent();

            // 2. Sekarang cari dan klik element button submit
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(authorizeButton)).click();

            // 3. Tangani alert yang mungkin muncul setelah klik
            handleAlertIfPresent();

        } catch (UnhandledAlertException e) {
            System.out.println("Alert blocked operation: " + e.getAlertText());
            forceHandleAlert();
        }
    }
}
