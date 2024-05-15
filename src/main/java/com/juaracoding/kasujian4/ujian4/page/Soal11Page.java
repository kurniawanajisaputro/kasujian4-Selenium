package com.juaracoding.kasujian4.ujian4.page;/*
IntelliJ IDEA 2023.3.6 (Community Edition)
Build #IC-223.8214.52, built on March 21, 2024
@Author MSI a.k.a. Kurniawan Adji Saputro
Java Developer
Created on 02/05/2024 22:11
@Last Modified 02/05/2024 22:11
Version 1.0
*/
import com.juaracoding.kasujian4.ujian4.connection.Constants;
import com.juaracoding.kasujian4.ujian4.connection.DriverSingleton;
import com.juaracoding.kasujian4.ujian4.util.GlobalFunction;
import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Soal11Page {
    WebDriver driver;

    @FindBy(xpath = "//h1[normalize-space()='Ujian Selenium']")
    private WebElement menuTitle;

    @FindBy(xpath = "//input[@id='namaDepan']")
    private WebElement textFieldNamaDepan;

    @FindBy(xpath = "//input[@id='namaBelakang']")
    private WebElement textFieldNamaBelakang;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement textFieldPassword;

    @FindBy(xpath = "//textarea[@id='alamatLengkap']")
    private WebElement textAreaAlamatLengkap;

    @FindBy(xpath = "//input[@id='noHp']")
    private WebElement textFieldNoHp;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement textFieldEmail;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//span[@id='xnamadepan']")
    private WebElement spanNamaDepan;

    @FindBy(xpath = "//span[@id='xnamabelakang']")
    private WebElement spanNamaBelakang;

    @FindBy(xpath = "//span[@id='xpassword']")
    private WebElement spanPassword;

    @FindBy(xpath = "//span[@id='xalamatlengkap']")
    private WebElement spanAlamatLengkap;

    @FindBy(xpath = "//span[@id='xnohp']")
    private WebElement spanNoHp;

    @FindBy(xpath = "//span[@id='xemail']")
    private WebElement spanEmail;


    public Soal11Page(WebDriver driver) {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(this.driver,this);
    }

    public void inputTextFieldNamaDepan(String strNamaDepan) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try {
            ((WebElement)(new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY)))
                    .until((Function)ExpectedConditions.visibilityOf(textFieldNamaDepan))).sendKeys(new CharSequence[] { strNamaDepan });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputTextFieldNamaBelakang(String strNamaBelakang) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try {
            ((WebElement)(new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY)))
                    .until((Function)ExpectedConditions.visibilityOf(textFieldNamaBelakang))).sendKeys(new CharSequence[] { strNamaBelakang });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputTextFieldPassword(String strPassword) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try {
            ((WebElement)(new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY)))
                    .until((Function)ExpectedConditions.visibilityOf(textFieldPassword))).sendKeys(new CharSequence[] { strPassword });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputTextAreaAlamatLengkap(String strAlamatLengkap) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try {
            ((WebElement)(new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY)))
                    .until((Function)ExpectedConditions.visibilityOf(textAreaAlamatLengkap))).sendKeys(new CharSequence[] { strAlamatLengkap });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputTextFieldNoHp(String strNoHp) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try {
            ((WebElement)(new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY)))
                    .until((Function)ExpectedConditions.visibilityOf(textFieldNoHp))).sendKeys(new CharSequence[] { strNoHp });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputTextFieldEmail(String strEmail) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try {
            ((WebElement)(new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY)))
                    .until((Function)ExpectedConditions.visibilityOf(textFieldEmail))).sendKeys(new CharSequence[] { strEmail });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickBtnSubmit() {
        btnSubmit.click();
    }

    public String soal11Validation() {
        return menuTitle==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
            .until(ExpectedConditions.visibilityOf(menuTitle)).getText();
    }

    public String getSpanNamaDepan() {
        return (spanNamaDepan == null) ? "" : (
                (WebElement)(new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))).until((Function)ExpectedConditions.visibilityOf(spanNamaDepan))).getText();
    }

    public String getSpanNamaBelakang() {
        return (spanNamaBelakang == null) ? "" : (
                (WebElement)(new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))).until((Function)ExpectedConditions.visibilityOf(spanNamaBelakang))).getText();
    }

    public String getSpanPassword() {
        return (spanPassword == null) ? "" : (
                (WebElement)(new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))).until((Function)ExpectedConditions.visibilityOf(spanPassword))).getText();
    }

    public String getSpanAlamatLengkap() {
        return (spanAlamatLengkap == null) ? "" : (
                (WebElement)(new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))).until((Function)ExpectedConditions.visibilityOf(spanAlamatLengkap))).getText();
    }

    public String getSpanNoHp() {
        return (spanNoHp == null) ? "" : (
                (WebElement)(new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))).until((Function)ExpectedConditions.visibilityOf(spanNoHp))).getText();
    }

    public String getSpanEmail() {
        return (spanEmail == null) ? "" : (
                (WebElement)(new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))).until((Function)ExpectedConditions.visibilityOf(spanEmail))).getText();
    }
}
