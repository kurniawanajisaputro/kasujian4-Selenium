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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Practice']")
    private WebElement btnMenuPractice;

    //    @FindBy(xpath = "//strong[contains(text(),'Congratulations student. You successfully logged i')]")
    @FindBy(xpath = "//h2[normalize-space()='4 Fitur Unggulan']")
    private WebElement homepageLogo;

    @FindBy(xpath = "//a[normalize-space()='logout']")
    private WebElement btnLogout;

    @FindBy(xpath = "//a[normalize-space()='Soal-1.1']")
    private WebElement btnSoal11;

    @FindBy(xpath = "//a[normalize-space()='SOAL-1']")
    private WebElement btnSoal1;

    @FindBy(xpath = "//h1[normalize-space()='Ujian Selenium']")
    private WebElement pageSoal1;

    public HomePage() {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    public HomePage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public String homePageValidation(){
        return homepageLogo==null?"":homepageLogo.getText();
    }
//    public String soal11Validation(){
//        return pageSoal1==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
//                .until(ExpectedConditions.visibilityOf(pageSoal1)).getText();
//    }

    public void logout(){
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnLogout)).click();
    }
    public void soal11(){
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnSoal11)).click();
    }

    public void soal1() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(btnSoal1)).click();
        } catch (Exception e) {
            System.out.println("Komponen Tombol Tidak Ditemukan !!");
        }
    }
    public WebElement goToMenuPractice(){
        return btnLogout;
    }
    public WebElement goToMenuSoal1(){
        return btnSoal1;
    }
    public WebElement subMenuSoal1() {
        return this.btnSoal11;
    }
}
