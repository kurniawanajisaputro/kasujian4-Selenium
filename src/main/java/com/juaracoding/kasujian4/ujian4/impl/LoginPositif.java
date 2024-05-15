package com.juaracoding.kasujian4.ujian4.impl;/*
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
import com.juaracoding.kasujian4.ujian4.page.HomePage;
import com.juaracoding.kasujian4.ujian4.page.LoginPage;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPositif {
    public static WebDriver driver;
    private LoginPage loginPage ;
    private HomePage homePage;

    @BeforeTest
    public void initCase(){
        DriverSingleton.getInstance(Constants.CHROME);
        this.driver = DriverSingleton.getDriver();
        this.driver.get(Constants.URL_LOGIN);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(priority = 0)
    public void validLogin()throws InterruptedException{
        System.out.println("Ujian Login Positf");
        System.out.println("Masuk validLogin");
        loginPage.clear();//STEP-1
        loginPage.inputUsername("Admin");//STEP-2
        loginPage.inputPassword("Admin@123");//STEP-3
        loginPage.clickLogin();//STEP-4
        Thread.sleep(2000);
        String strValidation = homePage.homePageValidation();
        System.out.println("Home Page Validation "+strValidation);
        Assert.assertEquals("4 Fitur Unggulan",strValidation);//STEP-5
    }

    @Test(priority = 1)
    public void logout(){
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].click()",homePage.goToMenuPractice());
        String strLoginFormValidation = loginPage.SignInFormValidation();//setelah logout
        Assert.assertEquals("Sign In",strLoginFormValidation);
    }

    @AfterTest
    public void closeDriver(){
        DriverSingleton.closeObjectInstance();
    }
}

