// Page Object Model class (PartnersPage.java)
package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PartnersPage {
    WebDriver driver;

    By findPartnerButton = By.xpath("//a[contains(text(), 'Find a Partner')]");

    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}

// Test Script class (TestPartnersPage.java)
package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.example.pages.PartnersPage;

public class TestPartnersPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.qasymphony.com/partners.html");

        PartnersPage partnersPage = new PartnersPage(driver);
        partnersPage.clickFindPartnerButton();

        driver.quit();
    }
}