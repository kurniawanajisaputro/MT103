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
import com.danamon.project.page.LoginPage;
import com.danamon.project.page.HomePage;
import com.danamon.project.page.MT103Page;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MT103MessageTesting {
    public WebDriver driver;
    private static ExtentTest extentTest;
    public LoginPage loginPage;
    public HomePage homePage;
    public MT103Page mt103Page;
    public MT103MessageTesting() {
        this.driver = LoginOutlineHooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        mt103Page = new MT103Page(driver);
        extentTest = LoginOutlineHooks.extentTest;
    }
//    @When("MT103002 Validasi MT103Page")
//    public void mt103002_validasi_mt103page() {
//        String MT103Validation = mt103Page.MT103Validation();
//        System.out.println("Berhasil masuk MT103 Page");
//        Assert.assertEquals(MT103Validation, "");
//    }
    @When("MT103002 Click Sender Header")
    public void mt103002_click_sender_header() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.mt103Page.senderheader();
        extentTest.log(LogStatus.PASS, "MT103002 Click Sender Header");
    }
    @And("^MT103002 Input Receiver Header (.*) Yang Valid")
    public void mt103002_input_receiver_header(String receiver) {
        this.mt103Page.receiverheader(receiver);
        extentTest.log(LogStatus.PASS, "MT103002 Input TextField (.*) Yang Valid Pertama");
    }
    @And("MT103002 Click Body")
    public void mt103002_click_body() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.mt103Page.BodyMT103();
        extentTest.log(LogStatus.PASS, "MT103002 Click Body");
    }
    @And("^MT103002 Input Reference (.*) Yang Valid")
    public void mt103002_input_reference(String tag20) {
        this.mt103Page.TAG20(tag20);
        extentTest.log(LogStatus.PASS, "MT103002 Input TextField (.*) Yang Valid Kedua");
    }
    @And("MT103002 Click Tag23B")
    public void mt103002_click_tag23() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.mt103Page.TAG23B();
        extentTest.log(LogStatus.PASS, "MT103002 Click Tag23B");
    }
    @And("^MT103002 Input tag32Acurr (.*) Yang Valid")
    public void mt103002_input_tag32Acurr(String tag32Acurr) {
        this.mt103Page.TAG32ACURR(tag32Acurr);
        extentTest.log(LogStatus.PASS, "MT103002 Input TextField (.*) Yang Valid Ketiga");
    }
    @And("^MT103002 Input tag32AAmount (.*) Yang Valid")
    public void mt103002_input_tag32AAmount(String tag32Aamount) {
        this.mt103Page.TAG32AAMOUNT(tag32Aamount);
        extentTest.log(LogStatus.PASS, "MT103002 Input TextField (.*) Yang Valid Keempat");
    }
    @And("MT103002 Click Tag50 A Identifiercode")
    public void mt103002_click_tag50aidentifiercode() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.mt103Page.Tag50AIdentifierCode();
        extentTest.log(LogStatus.PASS, "MT103002 Click Tag50 A Identifiercode");
    }
    @And("^MT103002 Input Tag 50 Bic (.*) Yang Valid")
    public void mt103002_input_tag50Abic(String tag50Abic) {
        this.mt103Page.TAG50ABIC(tag50Abic);
        extentTest.log(LogStatus.PASS, "MT103002 Input TextField(.*) Yang Valid Kelima");
    }
    @And("MT103002 Click Tag59 A Identifiercode")
    public void mt103002_click_tag59aidentifiercode() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.mt103Page.Tag59AIdentifierCode();
        extentTest.log(LogStatus.PASS, "MT103002 Click Tag59 A Identifiercode");
    }
    @And("^MT103002 Input Tag 59 Bic (.*) Yang Valid")
    public void mt103002_input_tag59Abic(String tag59Abic) {
        this.mt103Page.TAG59ABIC(tag59Abic);
        extentTest.log(LogStatus.PASS, "MT103002 Input TextField (.*) Yang Valid Kelima");
    }
    @And("MT103002 Click Tag 71 OUR")
    public void mt103002_click_tag71our() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.mt103Page.Tag71AOUR();
        extentTest.log(LogStatus.PASS, "MT103002 Click Tag 71 OUR");
    }
    @And("MT103002 Click Validate")
    public void mt103002_click_validate() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.mt103Page.clickValidateButton();
        System.out.println("Berhasil Validate");
        extentTest.log(LogStatus.PASS, "MT103002 Click Validate");
    }
    @And("MT103002 Click Submit")
    public void mt103002_click_submit() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.mt103Page.btnSubmit();
        System.out.println("Berhasil Submit");
        extentTest.log(LogStatus.PASS, "MT103002 Click Submit");
    }
    @And("MT103002 Validasi VER")
    public void mt103002_validasi_VER() {
        delay(Constants.TIMEOUT_DELAY);
        String verValidation = homePage.verValidation();
        System.out.println("Berhasil masuk TRX VER");
        Assert.assertEquals(verValidation, "VER");
    }
    @And("MT103002 Click Log Out")
    public void mt103002_klik_log_out(){
        delay(Constants.TIMEOUT_DELAY);
        this.homePage.Btnlogout();
        System.out.println("Berhasil Log Out");
        extentTest.log(LogStatus.PASS, "MT103002 Click Log Out");
    }
    @Then("MT103002 Validasi Log In")
    public void mt103001_validas2_log_in() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        String LoginValidation = loginPage.LoginValidation();
        Assert.assertEquals(LoginValidation, "");
    }
}
