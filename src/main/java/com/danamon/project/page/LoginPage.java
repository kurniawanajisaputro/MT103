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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//img[@src='images/cmdanamon.png']")
    private WebElement logoLoginIn;

    @FindBy(xpath = "//input[@id='floatUserName']")
    private WebElement txtFieldUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement txtFieldPassword;

    @FindBy(xpath = "//input[@name='Login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//div[@class='toast-body text-primary']")
    private WebElement validasiInvalidLDAP;

    @FindBy(xpath = "//*[@id=\"details-button\"]")
    private WebElement buttonAdvance;

    @FindBy(xpath = "//*[@id=\"proceed-link\"]")
    private WebElement buttonIpDanamon;

    //    // Element untuk popup "Ubah sandi Anda"
    @FindBy(xpath = "//div[contains(text(), 'Ubah sandi Anda') or contains(text(), 'Change your password')]")
    private WebElement popupUbahSandi;

    @FindBy(xpath = "//button[contains(text(), 'OK')]")
    private WebElement btnOKUbahSandi;

    public LoginPage(WebDriver driver) {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(this.driver,this);
    }

//        public LoginPage(WebDriver driver) {
//            this.driver= driver;
//            PageFactory.initElements(driver,this);
//        }

    public String LoginValidation(){
        return logoLoginIn==null?"":logoLoginIn.getText();
    }
    public String LoginInvalidValidation(){
        return validasiInvalidLDAP==null?"":validasiInvalidLDAP.getText();
    }

    public void setTxtUsername(String username){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldUsername)).sendKeys(username);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    public void setTxtPassword(String password){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldPassword)).sendKeys(password);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    public void Btnlogin() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnLogin)).click();
    }
    public void Btnadvance() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(buttonAdvance)).click();
    }
    public void Btnipdanamon() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(buttonIpDanamon)).click();
    }
    // Method untuk mengecek apakah popup muncul
    public boolean isPopupUbahSandiDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Coba beberapa alternatif XPath
            List<WebElement> popups = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//div[contains(text(), 'Ubah sandi Anda') or " +
                            "contains(text(), 'Ubah Sandi Anda') or " +
                            "contains(text(), 'Change your password') or " +
                            "contains(text(), 'Ubah Password')]")
            ));

            if (popups.isEmpty()) {
                // Cek modal dialog
                popups = driver.findElements(By.xpath(
                        "//div[contains(@class, 'modal')][.//*[contains(text(), 'Ubah sandi') or contains(text(), 'Change password')]]"
                ));
            }

            return !popups.isEmpty() && popups.get(0).isDisplayed();
        } catch (Exception e) {
            System.out.println("Popup tidak ditemukan: " + e.getMessage());
            return false;
        }
    }
    // Method untuk mengecek apakah popup muncul tanpa melakukan action
    public boolean handlePopupUbahSandiOK() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Tunggu sampai popup visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(), 'Ubah sandi Anda') or contains(text(), 'Change your password')]")
            ));

            // Tunggu sebentar untuk memastikan button sudah render
            GlobalFunction.delay(2);

            // Cari button OK dengan berbagai variasi
            List<WebElement> okButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//button[contains(text(), 'OK') or " +
                            "contains(text(), 'Ok') or " +
                            "contains(text(), 'Ya') or " +
                            "contains(text(), 'Yes') or " +
                            "contains(text(), 'Ubah Sekarang') or " +
                            "contains(text(), 'Change Now')]")
            ));

            for (WebElement button : okButtons) {
                if (button.isDisplayed() && button.isEnabled()) {
                    try {
                        // Coba click biasa dulu
                        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
                        System.out.println("Berhasil klik OK dengan click biasa");
                        return true;
                    } catch (Exception e) {
                        // Jika gagal, gunakan JavaScript click
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
                        System.out.println("Berhasil klik OK dengan JavaScript");
                        return true;
                    }
                }
            }

            // Cari button dengan class tertentu
            List<WebElement> classButtons = driver.findElements(By.xpath(
                    "//button[contains(@class, 'btn-primary') or " +
                            "contains(@class, 'btn-confirm') or " +
                            "contains(@class, 'btn-ok') or " +
                            "contains(@class, 'btn-success')]"
            ));

            for (WebElement button : classButtons) {
                if (button.isDisplayed() && button.isEnabled()) {
                    try {
                        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
                        return true;
                    } catch (Exception e) {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
                        return true;
                    }
                }
            }

            return false;

        } catch (Exception e) {
            System.out.println("Error handling popup: " + e.getMessage());
            return false;
        }
    }// Method untuk scroll ke element (jika diperlukan)
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Method untuk menunggu overlay hilang
    public void waitForOverlayToDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'overlay') or contains(@class,'loading') or contains(@class,'modal-backdrop')]")
            ));
        } catch (Exception e) {
            // Overlay mungkin tidak ada, lanjutkan saja
        }
    }
}
