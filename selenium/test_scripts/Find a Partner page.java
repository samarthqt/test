// Page Object Model File: PartnersPage.java

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PartnersPage {
    WebDriver driver;

    @FindBy(linkText = "Find a Partner")
    WebElement findPartnerButton;

    public PartnersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFindPartner() {
        findPartnerButton.click();
    }
}

// Test Script File: TestPartnersPage.java

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPartnersPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.qasymphony.com/partners.html");

        PartnersPage partnersPage = new PartnersPage(driver);
        partnersPage.clickFindPartner();

        driver.quit();
    }
}