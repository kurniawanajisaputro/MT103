package com.danamon.project.impl;

/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 23/09/2025 12:04
@Last Modified 23/09/2025 12:04
Version1.0
*/
import com.danamon.project.page.*;
import com.danamon.project.connection.Constants;
import com.danamon.project.util.GlobalFunction;
import static com.danamon.project.util.GlobalFunction.delay;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class ModifyMT103Testing {
    public WebDriver driver;
    private static ExtentTest extentTest;
    public LoginPage loginPage;
    public HomePage homePage;
    public ModificationPage modificationPage;
    public VerificationPage verificationPage;
    public ModifyMT103Testing() {
        this.driver = LoginOutlineHooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        modificationPage = new ModificationPage(driver);
        verificationPage = new VerificationPage(driver);
        extentTest = LoginOutlineHooks.extentTest;
    }
    @When("MT103003 Validasi Log In")
    public void mt103003_validasi_log_in() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        String LoginValidation = loginPage.LoginValidation();
        Assert.assertEquals(LoginValidation, "");
    }
    @And("^MT103003 Input Username (.*) Yang Valid")
    public void mt103003_input_textfield_username_yang_valid_one(String receiver) {
        this.loginPage.setTxtUsername(receiver);
        extentTest.log(LogStatus.PASS, "MT103001 Input TextField <receiver> Yang Valid One");
    }
    @And("^MT103003 Input Password (.*) Yang Valid")
    public void mt103003_input_textfield_password_yang_valid_one(String password) {
        this.loginPage.setTxtPassword(password);
        extentTest.log(LogStatus.PASS, "MT103001 Input TextField <password> Yang Valid One");
    }
    @And("MT103003 Click Button Login Form")
    public void mt103003_click_button_log_in_form() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.loginPage.Btnlogin();
        extentTest.log(LogStatus.PASS, "MT103001 Click Button Login Form");
    }
    @And("MT103003 Validasi Homepage")
    public void mt103003_validasi_homepage() {
        delay(Constants.TIMEOUT_DELAY);
        String HomePageValidation = homePage.homePageValidation();
        System.out.println("Berhasil masuk homepage danamon sebagai checker");
        Assert.assertEquals(HomePageValidation, "");
    }
    @And("MT103003 Click Button Verification Page")
    public void mt103003_click_button_verification_page() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.homePage.BtnVerification();
        extentTest.log(LogStatus.PASS, "MT103001 Click Button Verification Page");
    }
    @And("MT103003 Click Button View TRX")
    public void mt103003_click_button_view_trx() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.verificationPage.ViewTRXVER();
        extentTest.log(LogStatus.PASS, "MT103001 Click Button View TRX");
    }
    @And("MT103003 Click Button Modification")
    public void mt103003_click_button_modification() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.verificationPage.BtnMod();
        extentTest.log(LogStatus.PASS, "MT103001 Click Button Verification Page");
    }
    @And("MT103003 Validasi MOD")
    public void mt103003_validasi_VER() {
        delay(Constants.TIMEOUT_DELAY);
        String modValidation = homePage.modValidation();
        System.out.println("Berhasil Berubah MOD");
        Assert.assertEquals(modValidation, "MOD");
    }
    @Then("MT103003 Click Log Out")
    public void mt103003_klik_log_out(){
        delay(Constants.TIMEOUT_DELAY);
        this.homePage.Btnlogout();
        System.out.println("Berhasil Log Out");
        extentTest.log(LogStatus.PASS, "MT103002 Click Log Out");
    }
    @When("MT103004 Validasi Log In")
    public void mt103004_validas2_log_in() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        String LoginValidation = loginPage.LoginValidation();
        Assert.assertEquals(LoginValidation, "");
    }
    @And("^MT103004 Input Username (.*) Yang Valid")
    public void mt103004_input_textfield_username_yang_valid_one(String username) {
        this.loginPage.setTxtUsername(username);
        extentTest.log(LogStatus.PASS, "MT103001 Input TextField <receiver> Yang Valid One");
    }
    @And("^MT103004 Input Password (.*) Yang Valid")
    public void mt103004_input_textfield_password_yang_valid_one(String password) {
        this.loginPage.setTxtPassword(password);
        extentTest.log(LogStatus.PASS, "MT103001 Input TextField <password> Yang Valid One");
    }
    @And("MT103004 Validasi Homepage")
    public void mt103004_validasi_homepage() {
        delay(Constants.TIMEOUT_DELAY);
        String HomePageValidation = homePage.homePageValidation();
        System.out.println("Berhasil masuk homepage danamon sebagai maker");
        Assert.assertEquals(HomePageValidation, "");
    }
    @And("MT103004 Click Button Verification Page")
    public void mt103004_click_button_verification_page() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.homePage.BtnModification();
        extentTest.log(LogStatus.PASS, "MT103001 Click Button Verification Page");
    }
    @And("MT103004 Click Button View TRX")
    public void mt103004_click_button_view_trx() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.modificationPage.ViewTRXMOD();
        extentTest.log(LogStatus.PASS, "MT103001 Click Button View TRX");
    }
}
