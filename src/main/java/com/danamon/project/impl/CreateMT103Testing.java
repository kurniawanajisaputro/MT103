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
public class CreateMT103Testing {
    public WebDriver driver;
    private static ExtentTest extentTest;
    public LoginPage loginPage;
    public HomePage homePage;
    public CreateMT103Testing() {
        this.driver = LoginOutlineHooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        extentTest = LoginOutlineHooks.extentTest;
    }
    @When("MT103001 Membuka Halaman CM")
    public void mt103001_membuka_halaman_login() {
        delay(Constants.TIMEOUT_DELAY);
        this.driver.get(Constants.URL_LOGIN);
        extentTest.log(LogStatus.PASS, "MT103001 Membuka Website");
    }
    @And("MT103001 Klik Button Advance")
    public void mt103001_klik_button_advance(){
        delay(Constants.TIMEOUT_DELAY);
        this.loginPage.Btnadvance();
        System.out.println("Berhasil klik");
        extentTest.log(LogStatus.PASS, "MT103001 Click Button Create User");
    }
    @And("MT103001 Klik Button IP Danamon")
    public void mt103001_klik_button_ip_danamon(){
        delay(Constants.TIMEOUT_DELAY);
        this.loginPage.Btnipdanamon();
        System.out.println("Berhasil masuk ip danamon");
        extentTest.log(LogStatus.PASS, "MT103001 Click Button Create User");
    }
    @And("MT103001 Validasi Log In")
    public void mt103001_validasi_log_in() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        String LoginValidation = loginPage.LoginValidation();
        Assert.assertEquals(LoginValidation, "");
    }
    @And("^MT103001 Input Username (.*) Yang Valid")
    public void mt103001_input_textfield_username_yang_valid_one(String receiver) {
        this.loginPage.setTxtUsername(receiver);
        extentTest.log(LogStatus.PASS, "MT103001 Input TextField <receiver> Yang Valid One");
    }

    @And("^MT103001 Input Password (.*) Yang Valid")
    public void mt103001_input_textfield_password_yang_valid_one(String password) {
        this.loginPage.setTxtPassword(password);
        extentTest.log(LogStatus.PASS, "MT103001 Input TextField <password> Yang Valid One");
    }

    @And("MT103001 Click Button Login Form")
    public void mt103001_click_button_log_in_form() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        this.loginPage.Btnlogin();
        extentTest.log(LogStatus.PASS, "MT103001 Click Button Login Form");
    }

    @And("MT103001 Validasi Homepage")
    public void mt103001_validasi_homepage() {
        delay(Constants.TIMEOUT_DELAY);
        String HomePageValidation = homePage.homePageValidation();
        System.out.println("Berhasil masuk homepage danamon sebagai maker");
        Assert.assertEquals(HomePageValidation, "");
    }
    @Then("MT103001 Klik Create Message MT103")
    public void mt103001_klik_user(){
        delay(Constants.TIMEOUT_DELAY);
        this.homePage.BtnCreditTransferMT103();
        System.out.println("Berhasil masuk MT103 page");
        extentTest.log(LogStatus.PASS, "MT103001 Klik Create Message MT103");
    }
//    @Then("MT103001 Validasi User Page")
//    public void MT103001_validasi_user_page(){
//        delay(Constants.TIMEOUT_DELAY);
//        String ValidationUserPage = userPage.UserPageValidation();
//        Assert.assertEquals(ValidationUserPage, "List of User Add User List Of Disable Permanent User");
//    }
//    @Then("MT103001 Klik Create User")
//    public void MT103001_klik_create_user(){
//        delay(Constants.TIMEOUT_DELAY);
//        userPage.BtnCreate();
//        System.out.println("Berhasil masuk create user");
//        extentTest.log(LogStatus.PASS, "MT103001 Click Button Create User");
//    }
}
