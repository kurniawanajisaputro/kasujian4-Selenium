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
import com.juaracoding.kasujian4.ujian4.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginNegatif {
    public static WebDriver driver;
    private LoginPage loginPage ;

    @BeforeTest
    public void initCase(){
        DriverSingleton.getInstance(Constants.CHROME);
        this.driver = DriverSingleton.getDriver();
        this.driver.get(Constants.URL_LOGIN);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 0)
    public void emptyLogin(){
        System.out.println("Ujian Login Negatif");
        System.out.println("Username dan Password Kosong");
        loginPage.clear();
        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickLogin();
        boolean isValid = (loginPage.notificationPasswordIsEmpty().equals("password tidak boleh kosong") && loginPage.notificationInvalidPassword().equals("invalid password") && loginPage.notificationInvalidUsername().equals("invalid username") && loginPage.notificationUsernameIsEmpty().equals("username tidak boleh kosong"));
        Assert.assertTrue(isValid);
        System.out.println("Empty Login End");
    }

    @Test(priority = 1)
    public void invalidPassword(){
        System.out.println("Password Salah");
        loginPage.clear();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin@123");
        loginPage.clickLogin();
        Assert.assertEquals("invalid password", loginPage.notificationInvalidPassword());
        System.out.println("Invalid Password End");
    }

    @Test(priority = 2)
    public void invalidUsername(){
        System.out.println("Username Salah");
        loginPage.clear();
        loginPage.inputUsername("admin");
        loginPage.inputPassword("Admin@123");
        loginPage.clickLogin();
        Assert.assertEquals("invalid username", loginPage.notificationInvalidUsername());
        System.out.println("Invalid Username End");
    }

    @Test(priority = 3)
    public void invalidLogin(){
        System.out.println("Username dan Password Salah");
        loginPage.clear();
        loginPage.inputUsername("admin");
        loginPage.inputPassword("admin@123");
        loginPage.clickLogin();
        boolean isValid = (loginPage.notificationInvalidPassword().equals("invalid password") && loginPage.notificationInvalidUsername().equals("invalid username"));
        Assert.assertTrue(isValid);
        System.out.println("Invalid Login End");
    }

    @AfterTest
    public void closeDriver(){
        DriverSingleton.closeObjectInstance();
    }
}
