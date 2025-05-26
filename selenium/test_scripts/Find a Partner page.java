// Main Test Script File

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartnerPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("http://www.qasymphony.com/partners.html");
            
            PartnerPage partnerPage = new PartnerPage(driver);
            partnerPage.clickFindPartnerButton();
        } finally {
            driver.quit();
        }
    }
}

// Page Object Model File

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnerPage {
    private WebDriver driver;
    private By findPartnerButton = By.id("findPartnerButtonId"); // Replace with actual ID or locator

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}