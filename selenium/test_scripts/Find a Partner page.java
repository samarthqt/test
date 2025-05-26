// TestScript.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            PartnerPage partnerPage = new PartnerPage(driver);
            partnerPage.open();
            partnerPage.clickFindPartnerButton();
        } finally {
            driver.quit();
        }
    }
}

// PartnerPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PartnerPage {
    private WebDriver driver;
    private String url = "http://www.qasymphony.com/partners.html";
    private By findPartnerButton = By.linkText("Find a Partner");

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}