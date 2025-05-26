import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class SeleniumTestCase {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("http://www.qasymphony.com/platform.html");

            WebElement agileTestingMenu = driver.findElement(By.linkText("Agile Testing"));
            agileTestingMenu.click();

            WebElement getFreeTrialButton = driver.findElement(By.linkText("Get Free Trial"));
            getFreeTrialButton.click();

            List<WebElement> learnMoreButtons = driver.findElements(By.linkText("Learn More"));
            for (WebElement learnMoreButton : learnMoreButtons) {
                learnMoreButton.click();
            }
        } finally {
            driver.quit();
        }
    }
}