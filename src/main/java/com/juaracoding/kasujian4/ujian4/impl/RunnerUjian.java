package com.juaracoding.kasujian4.ujian4.impl;/*
IntelliJ IDEA 2023.3.6 (Community Edition)
Build #IC-223.8214.52, built on March 21, 2024
@Author MSI a.k.a. Kurniawan Adji Saputro
Java Developer
Created on 02/05/2024 22:12
@Last Modified 02/05/2024 22:12
Version 1.0
*/
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
public class RunnerUjian {
    public static void main(String[] args) {
        String rootProject = System.getProperty("user.dir");
        TestNG runner = new TestNG();
        runner.setOutputDirectory(rootProject + "\\output-testng\\selenium\\" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss")));
        List<String> suitefiles = new ArrayList<String>();
        suitefiles.add(rootProject + "\\ujianloginpositif.xml");
        suitefiles.add(rootProject + "\\ujianloginnegatif.xml");
        suitefiles.add(rootProject + "\\ujiansoal11.xml");
        runner.setTestSuites(suitefiles);
        runner.run();
    }
}
