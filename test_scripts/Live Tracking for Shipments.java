package com.example.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.example.pageobjects.FormPage;
import java.time.Duration;

public class FormSubmissionTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private FormPage formPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        formPage = new FormPage(driver, wait);
    }

    @Test
    public void testFormSubmission() {
        driver.get("http://example.com/form");
        formPage.fillForm("John Doe", "john.doe@example.com", "This is a test message.");
        formPage.submitForm();
        Assert.assertTrue(formPage.isConfirmationMessageDisplayed(), "Form submission failed");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}