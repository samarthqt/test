```java
// PartnersPage.java (Page Object Model file)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnersPage {
    private WebDriver driver;
    private By findPartnerButton = By.xpath("//button[contains(text(), 'Find a Partner')]");

    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}

// TestScript.java (Selenium automation script)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://www.qasymphony.com/partners.html");
        
        PartnersPage partnersPage = new PartnersPage(driver);
        partnersPage.clickFindPartnerButton();
        
        driver.quit();
    }
}
```