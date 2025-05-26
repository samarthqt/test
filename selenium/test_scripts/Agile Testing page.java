import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SeleniumTestAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            
            driver.get("http://www.qasymphony.com/platform.html");
            
            WebElement agileTestingMenu = driver.findElement(By.linkText("Agile Testing"));
            agileTestingMenu.click();
            
            WebElement getFreeTrial = driver.findElement(By.linkText("Get Free Trial"));
            getFreeTrial.click();
            
            WebElement scaleAgileLearnMore = driver.findElement(By.xpath("//section[contains(@class, 'scale-agile')]//a[contains(text(), 'Learn More') or contains(text(), 'content')]"));
            scaleAgileLearnMore.click();
            
            WebElement explorerTestingLearnMore = driver.findElement(By.xpath("//section[contains(@class, 'explorer-testing')]//a[contains(text(), 'Learn More') or contains(text(), 'content')]"));
            explorerTestingLearnMore.click();
            
            WebElement distributedTeamLearnMore = driver.findElement(By.xpath("//section[contains(@class, 'distributed-team')]//a[contains(text(), 'Learn More') or contains(text(), 'content')]"));
            distributedTeamLearnMore.click();
            
        } finally {
            driver.quit();
        }
    }
}