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
public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//img[@class='homePage']")
    private WebElement validasiCM;

    @FindBy(xpath = "//span[normalize-space()='Create Message']")
    private WebElement createMessageMenu;

    @FindBy(xpath = "//span[normalize-space()='MT']")
    private WebElement mtMenu;

    @FindBy(xpath = "//span[normalize-space()='Message Category 1']")
    private WebElement messageCategoryMenu;

    @FindBy(xpath = "//a[normalize-space()='103 - Single Customer Credit Transfer']")
    private WebElement creditTransferLink;

    @FindBy(xpath = "//a[@href='ServletControllerLogout' and @class='log' and contains(text(), 'Logout')]")
    private WebElement btnLogOut;

    @FindBy(xpath = "//span[normalize-space()='Process']")
    private WebElement btnProcess;

    @FindBy(xpath = "//a[normalize-space()='Message List']")
    private WebElement btnMessageList;

    @FindBy(xpath = "//tr[@class='odd']/td[text()='VER']")
    private WebElement validasiVERTrx;

    @FindBy(xpath = "//tr[@class='odd']/td[text()='MOD']")
    private WebElement validasiMODTrx;

    @FindBy(how = How.XPATH, using = "//span[@class='dir']")
    public WebElement processText;

    @FindBy(how = How.CSS, using = "span.dir")
    public WebElement outgoingText;

    @FindBy(how = How.CSS, using = "a[href*='controllerHeaders'][href*='flag=VER']")
    public WebElement verificationLink;

    @FindBy(how = How.CSS, using = "a[href*='controllerHeaders'][href*='flag=MOD']")
    public WebElement modificationLink;

    public HomePage(WebDriver driver) {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(this.driver,this);
    }

    public String homePageValidation(){
        if (driver == null || validasiCM == null) {
            return "";
        }
        return validasiCM.getText();
    }
//    public String administatorValidation(){
//        return validasiAdministrator==null?"":validasiAdministrator.getText();
//    }

    public void setBtnLogOut() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnLogOut)).click();
    }
    public void Btnlogout() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnLogOut)).click();
    }
    //    public void Btnadministrator() {
//        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
//                .until(ExpectedConditions.visibilityOf(btnAdministrator)).click();
//    }
//    public void Btnuser() {
//        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
//                .until(ExpectedConditions.visibilityOf(btnUser)).click();
//    }
    public void BtnCreditTransferMT103(){
        // TAMBAHKAN VALIDASI DRIVER
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null! Pastikan driver sudah di-set sebelum memanggil method ini.");
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(createMessageMenu)
                .moveToElement(mtMenu)
                .moveToElement(messageCategoryMenu)
                .perform();
        creditTransferLink.click();
    }
    public void BtnMessageList() {

    }
    public String verValidation(){
        if (driver == null || validasiVERTrx == null) {
            return "";
        }
        return validasiVERTrx.getText();
    }

    public String modValidation(){
        if (driver == null || validasiMODTrx == null) {
            return "";
        }
        return validasiMODTrx.getText();
    }
    public void BtnVerification() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null! Pastikan driver sudah di-set sebelum memanggil method ini.");
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(processText)
                .moveToElement(outgoingText)
                .moveToElement(verificationLink)
                .perform();
        verificationLink.click();
    }
    public void BtnModification() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null! Pastikan driver sudah di-set sebelum memanggil method ini.");
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(processText)
                .moveToElement(outgoingText)
                .moveToElement(modificationLink)
                .perform();
        modificationLink.click();
    }
}
