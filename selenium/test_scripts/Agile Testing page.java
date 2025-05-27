import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BrowserAutomationTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        try {
            driver.get("http://www.qasymphony.com/platform.html");
            
            WebElement agileTestingMenu = driver.findElement(By.linkText("Agile Testing"));
            agileTestingMenu.click();
            
            WebElement getFreeTrialButton = driver.findElement(By.linkText("Get Free Trial"));
            getFreeTrialButton.click();
            
            WebElement scaleAgileLearnMore = driver.findElement(By.xpath("//section[contains(@class, 'scale-agile')]//a[contains(text(), 'Learn More')]"));
            scaleAgileLearnMore.click();
            
            WebElement explorerTestingLearnMore = driver.findElement(By.xpath("//section[contains(@class, 'explorer-testing')]//a[contains(text(), 'Learn More')]"));
            explorerTestingLearnMore.click();
            
            WebElement distributedTeamLearnMore = driver.findElement(By.xpath("//section[contains(@class, 'distributed-team')]//a[contains(text(), 'Learn More')]"));
            distributedTeamLearnMore.click();
            
        } finally {
            driver.quit();
        }
    }
}