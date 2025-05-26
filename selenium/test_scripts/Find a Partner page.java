// Selenium Test Case Script
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class PartnerPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        PartnerPage partnerPage = new PartnerPage(driver);
        driver.get("http://www.qasymphony.com/partners.html");
        partnerPage.clickFindPartnerButton();
        
        driver.quit();
    }
}

// Page Object Model File
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnerPage {
    WebDriver driver;
    
    By findPartnerButton = By.xpath("//button[text()='Find a Partner']");
    
    public PartnerPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}