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
import com.danamon.project.util.GlobalFunction;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.*;
import java.time.Duration;
public class MT103Page {
    private WebDriver driver;
    @FindBy(xpath = "//div[@id='judul']")
    private WebElement validasiMT103;
    @FindBy(css = "div#judul")
    private WebElement judulCssElement;
    @FindBy(xpath = "//div[@id='judul']")
    private WebElement judulElement;
    @FindBy(xpath = "//div[text()='MT 103 Single Customer Credit Transfer']")
    private WebElement judulTextElement;
    // XPath Selector untuk select box
    @FindBy(xpath = "//select[@id='sender_logical_terminal']")
    private WebElement senderTerminalSelect;
    @FindBy(xpath = "//input[@id='receiver_institution']")
    private WebElement Receiveheader;
    @FindBy(xpath = "//a[normalize-space()='Body']")
    private WebElement klikbody;
    @FindBy(xpath = "//input[@id='_010_mf20_sender_reference']")
    private WebElement tag20;
    @FindBy(css = "#_030_mf23b_bank_code option[value='CRED']")
    private WebElement tag23B;
    @FindBy(xpath = "//input[@id='_061_mf32a_currency']")
    private WebElement tag32ACurr;
    @FindBy(xpath = "//input[@id='_062_mf32a_amount']")
    private WebElement tag32AAmount;
    @FindBy(xpath = "//select[@id='type_mf50_ordering_customer']/option[@value='a']")
    private WebElement tag50;
    @FindBy(xpath = "//input[@id='_091_mf50a_identifier_code']")
    private WebElement tag50ABIC;
    @FindBy(css = "#type_of59_59a_ option[value='59a']")
    private WebElement tag59;
    @FindBy(xpath = "//input[@id='_183_mf59a_identifier_code']")
    private WebElement tag59ABIC;
    @FindBy(xpath = "//select[@id='_210_of71a_details_charges']/option[@value='OUR']")
    private WebElement tag71A;
    @FindBy(xpath = "//input[@id='btn-validate']")
    private WebElement klikbuttonvalidate;
    @FindBy(xpath = "//input[@id='submit_mt']")
    private WebElement klikbuttonsubmit;
    //inisiaisi driver Mt103page
    public MT103Page(WebDriver driver) {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(this.driver,this);
    }
    //validasi mt103 page
    public String MT103Validation(){
        if (driver == null || validasiMT103 == null) {
            return "";
        }
        return validasiMT103.getText();
    }

    //klik sender receiver
    public void senderheader() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('select#sender_logical_terminal').value = 'BDINIDJAXCUS';");
    }
    //Mengisi bagian receiver header
    public void receiverheader(String receiver){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(Receiveheader)).sendKeys(receiver);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    //klik body
    public void BodyMT103() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(klikbody)).click();
    }
    //Mengisi bagian tag20
    public void TAG20(String reference){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(tag20)).sendKeys(reference);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    //Klik bagian tag23b
    public void TAG23B() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(tag23B)).click();
    }
    //Mengisi bagian tag32Acurr
    public void TAG32ACURR(String tag32Acurr){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(tag32ACurr)).sendKeys(tag32Acurr);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    //Mengisi bagian tag32AAmount
    public void TAG32AAMOUNT(String tag32Aamount){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(tag32AAmount)).sendKeys(tag32Aamount);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    //klik Tag50 A - Identifier Code
    public void Tag50AIdentifierCode() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(tag50)).click();
    }
    //Mengisi bagian tag50Abic
    public void TAG50ABIC(String tag50Abic){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(tag50ABIC)).sendKeys(tag50Abic);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    //klik Tag59 A - Identifier Code
    public void Tag59AIdentifierCode() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(tag59)).click();
    }
    //Mengisi bagian tag59Abic
    public void TAG59ABIC(String tag59Abic){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(tag59ABIC)).sendKeys(tag59Abic);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    //klik Tag71 OUR
    public void Tag71AOUR() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(tag71A)).click();
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
