package org.joe.appointment.finder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by AbdallaY on 05/10/2019.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        //new ApplicantInfoReader().getApplicantInfoInFile();
        WebDriverManager.chromedriver().setup();
        //WebDriver webDriver = new ChromeDriver(new ChromeOptions().setHeadless(true));
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://burghquayregistrationoffice.inis.gov.ie/Website/AMSREG/AMSRegWeb.nsf/AppSelect?OpenForm");
        webDriver.manage().window().maximize();
        FormPage formPage = PageFactory.initElements(webDriver, FormPage.class);
        formPage.setCategoryToAll();
        try {
            formPage.setSubcategoryToAll();
        } catch (WebDriverException wde) {
        }

    }

}
