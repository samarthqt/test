import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class QASymphonyTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        driver.get("http://www.qasymphony.com/platform.html");
        
        Actions actions = new Actions(driver);
        WebElement agileTestingMenu = driver.findElement(By.xpath("//a[contains(text(),'Agile Testing')]"));
        actions.moveToElement(agileTestingMenu).perform();
        
        WebElement getFreeTrialButton = driver.findElement(By.xpath("//a[contains(text(),'Get Free Trial')]"));
        getFreeTrialButton.click();
        
        WebElement scaleAgileLearnMore = driver.findElement(By.xpath("//a[contains(text(),'Learn More') and contains(@href, 'scale-agile')]"));
        scaleAgileLearnMore.click();
        
        WebElement explorerTestingLearnMore = driver.findElement(By.xpath("//a[contains(text(),'Learn More') and contains(@href, 'explorer-testing')]"));
        explorerTestingLearnMore.click();
        
        WebElement distributedTeamLearnMore = driver.findElement(By.xpath("//a[contains(text(),'Learn More') and contains(@href, 'distributed-team')]"));
        distributedTeamLearnMore.click();
        
        driver.quit();
    }
}