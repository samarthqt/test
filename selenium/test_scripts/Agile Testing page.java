import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://www.qasymphony.com/platform.html");
        
        WebElement agileTestingMenu = driver.findElement(By.linkText("Agile Testing"));
        agileTestingMenu.click();
        
        WebElement getFreeTrial = driver.findElement(By.linkText("Get Free Trial"));
        getFreeTrial.click();
        
        WebElement scaleAgileLearnMore = driver.findElement(By.xpath("//section[@id='scale-agile']//a[contains(text(),'Learn More')]"));
        scaleAgileLearnMore.click();
        
        WebElement explorerTestingLearnMore = driver.findElement(By.xpath("//section[@id='explorer-testing']//a[contains(text(),'Learn More')]"));
        explorerTestingLearnMore.click();
        
        WebElement distributedTeamLearnMore = driver.findElement(By.xpath("//section[@id='distributed-team']//a[contains(text(),'Learn More')]"));
        distributedTeamLearnMore.click();
        
        driver.quit();
    }
}