// Test Script using Selenium WebDriver and Page Object Model

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class PartnerPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        PartnerPage partnerPage = new PartnerPage(driver);
        partnerPage.open();
        partnerPage.clickFindPartnerButton();
        
        driver.quit();
    }
}

// Page Object Model for the partners page

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartnerPage {
    private WebDriver driver;
    private String url = "http://www.qasymphony.com/partners.html";
    private By findPartnerButton = By.id("findPartnerButton"); // Assuming the button has an id attribute

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void clickFindPartnerButton() {
        driver.findElement(findPartnerButton).click();
    }
}