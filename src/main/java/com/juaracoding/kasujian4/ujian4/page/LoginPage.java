package com.juaracoding.kasujian4.ujian4.page;/*
IntelliJ IDEA 2023.3.6 (Community Edition)
Build #IC-223.8214.52, built on March 21, 2024
@Author MSI a.k.a. Kurniawan Adji Saputro
Java Developer
Created on 02/05/2024 22:10
@Last Modified 02/05/2024 22:10
Version 1.0
*/
import com.juaracoding.kasujian4.ujian4.connection.Constants;
import com.juaracoding.kasujian4.ujian4.connection.DriverSingleton;
import com.juaracoding.kasujian4.ujian4.util.GlobalFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement txtFieldUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement txtFieldPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//h2[normalize-space()='4 Fitur Unggulan']")
    private WebElement labelLogin;
    @FindBy(xpath = "//h1[normalize-space()='Sign In']")
    private WebElement labelSignin;

    @FindBy(xpath = "//li[normalize-space()='Username Tidak Boleh Kosong']")
    private WebElement notifUsernameIsEmpty;

    @FindBy(xpath = "//li[normalize-space()='Invalid Username']")
    private WebElement notifInvalidUsername;

    @FindBy(xpath = "//li[normalize-space()='Password Tidak Boleh Kosong']")
    private WebElement notifPasswordIsEmpty;

    @FindBy(xpath = "//li[normalize-space()='Invalid Password']")
    private WebElement notifInvalidPassword;

    public LoginPage(){
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    public LoginPage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void inputUsername(String username){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldUsername)).sendKeys(username);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }

    public void inputPassword(String password){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldPassword)).sendKeys(password);
        }catch (Exception e){
            System.out.println("Komponen Text Field Password Tidak Ditemukan !!");
        }
    }

    public void clickLogin(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(btnSubmit)).click();
        }catch (Exception e){
            System.out.println("Komponen Tombol Tidak Ditemukan !!");
        }
    }

    public void clear(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            /** Set Field Password Empty String */
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldPassword)).clear();
            /** Set Field Username Empty String */
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldUsername)).clear();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String notificationInvalidUsername() {
        return (this.notifPasswordIsEmpty == null) ? "" : new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(notifInvalidUsername)).getText();
    }

    public String notificationInvalidPassword() {
        return (this.notifPasswordIsEmpty == null) ? "" : new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(notifInvalidPassword)).getText();
    }

    public String notificationUsernameIsEmpty() {
        return (this.notifPasswordIsEmpty == null) ? "" : new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(notifUsernameIsEmpty)).getText();
    }

    public String notificationPasswordIsEmpty() {
        return (this.notifPasswordIsEmpty == null) ? "" : new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(notifPasswordIsEmpty)).getText();
    }


    public String loginFormValidation(){
        return labelLogin==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(labelLogin)).getText();
    }
    public String SignInFormValidation(){
        return labelLogin==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(labelSignin)).getText();
    }
}
