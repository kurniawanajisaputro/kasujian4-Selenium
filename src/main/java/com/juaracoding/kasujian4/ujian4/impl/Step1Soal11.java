package com.juaracoding.kasujian4.ujian4.impl;/*
IntelliJ IDEA 2023.3.6 (Community Edition)
Build #IC-223.8214.52, built on March 21, 2024
@Author MSI a.k.a. Kurniawan Adji Saputro
Java Developer
Created on 02/05/2024 22:12
@Last Modified 02/05/2024 22:12
Version 1.0
*/

import com.juaracoding.kasujian4.ujian4.connection.Constants;
import com.juaracoding.kasujian4.ujian4.connection.DriverSingleton;
import com.juaracoding.kasujian4.ujian4.page.HomePage;
import com.juaracoding.kasujian4.ujian4.page.LoginPage;
import com.juaracoding.kasujian4.ujian4.page.Soal11Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Step1Soal11 {
    public static WebDriver driver;
    private LoginPage loginPage ;
    private HomePage homePage;
    private Soal11Page soal11Page;

    @BeforeTest
    public void initCase(){
        DriverSingleton.getInstance(Constants.CHROME);
        this.driver = DriverSingleton.getDriver();
        this.driver.get(Constants.URL_LOGIN);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        soal11Page = new Soal11Page(driver);
    }

    @Test(priority = 0)
    public void validLogin()throws InterruptedException{
        System.out.println("Ujian Login Soal11");
        System.out.println("Masuk validLogin !!");
        loginPage.clear();//STEP-1
        loginPage.inputUsername("Admin");//STEP-2
        loginPage.inputPassword("Admin@123");//STEP-3
        loginPage.clickLogin();//STEP-4
        Thread.sleep(2000);
        String strValidation = homePage.homePageValidation();
        System.out.println("Sign In\n"+strValidation);
        Assert.assertEquals("4 Fitur Unggulan",strValidation);//STEP-5
    }

    @Test(priority = 1)
    public void homeToSoal11(){
        System.out.println("Masuk homeToSoal11 !!");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", new Object[] { this.homePage.subMenuSoal1() });
        System.out.println("Validatoin Soal 11 - ");
        System.out.println(this.soal11Page.soal11Validation());
        String strUjian = this.soal11Page.soal11Validation();
        Assert.assertEquals("Ujian Selenium", strUjian);
    }

    @Test(priority = 2)
    public void inputDataSoal11()throws InterruptedException{
        System.out.println("Masuk Soal11 Ujian Selenium !!");
        soal11Page.inputTextFieldNamaDepan("Kurniawan");
        soal11Page.inputTextFieldNamaBelakang("Adji Saputro");
        soal11Page.inputTextFieldPassword("Awan123");
        ((JavascriptExecutor)driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)", new Object[0]);
        soal11Page.inputTextAreaAlamatLengkap("Jalan Kenangan Bersama Dia no.55");
        soal11Page.inputTextFieldNoHp("85155556666");
        soal11Page.inputTextFieldEmail("kurniawancute@gmail.com");
        soal11Page.clickBtnSubmit();
        Thread.sleep(5000);
        ((JavascriptExecutor)driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)", new Object[0]);
        boolean isValid = (this.soal11Page.getSpanNamaDepan().equals("Kurniawan") && this.soal11Page.getSpanNamaBelakang().equals("Adji Saputro") && this.soal11Page.getSpanAlamatLengkap().equals("Jalan Kenangan Bersama Dia no.55") && this.soal11Page.getSpanEmail().equals("kurniawancute@gmail.com") && this.soal11Page.getSpanPassword().equals("Awan123") && this.soal11Page.getSpanNoHp().equals("+6285155556666"));
        Assert.assertTrue(isValid, "OK");
    }
    @AfterTest
    public void closeDriver(){
        DriverSingleton.closeObjectInstance();
    }
}
