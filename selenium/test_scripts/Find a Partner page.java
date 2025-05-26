// Main Test Script
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class PartnerPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("http://www.qasymphony.com/partners.html");
            
            PartnerPage partnerPage = new PartnerPage(driver);
            partnerPage.clickFindPartnerButton();
        } finally {
            driver.quit();
        }
    }
}

// Page Object Model (POM) File
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PartnerPage {
    private WebDriver driver;
    private By findPartnerButton = By.xpath("//button[contains(text(), 'Find a Partner')]");

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}