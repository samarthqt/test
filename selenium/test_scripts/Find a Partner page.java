// Page Object Model class for the Partners Page
package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PartnersPage {
    private WebDriver driver;
    private By findPartnerButton = By.linkText("Find a Partner");

    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFindPartner() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}

// Test script using Selenium WebDriver
package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.example.pages.PartnersPage;

public class FindPartnerTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://www.qasymphony.com/partners.html");
            PartnersPage partnersPage = new PartnersPage(driver);
            partnersPage.clickFindPartner();
        } finally {
            driver.quit();
        }
    }
}