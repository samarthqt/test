// Selenium Java Automation Script

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import qasymphony.pages.PartnersPage;

public class QASymphonyTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.qasymphony.com/partners.html");

        PartnersPage partnersPage = new PartnersPage(driver);
        partnersPage.clickFindPartnerButton();

        driver.quit();
    }
}

// Page Object Model File

package qasymphony.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PartnersPage {
    private WebDriver driver;
    private By findPartnerButton = By.id("findPartnerButtonId"); // Replace with actual ID or locator

    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}