import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class QASymphonyAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            
            // Open the browser and navigate to the URL
            driver.get("http://www.qasymphony.com/platform.html");
            
            // Click on the "Agile Testing" sub-menu
            WebElement agileTestingMenu = driver.findElement(By.linkText("Agile Testing"));
            agileTestingMenu.click();
            
            // Call Get Free Trial
            WebElement getFreeTrialButton = driver.findElement(By.linkText("Get Free Trial"));
            getFreeTrialButton.click();
            
            // Click on the "Learn More" button of Scale Agile section
            WebElement scaleAgileLearnMore = driver.findElement(By.xpath("//section[@id='scale-agile']//a[contains(text(),'Learn More')]"));
            scaleAgileLearnMore.click();
            
            // Click on the "Learn More" button of eXplorer Testing section
            WebElement explorerTestingLearnMore = driver.findElement(By.xpath("//section[@id='explorer-testing']//a[contains(text(),'Learn More')]"));
            explorerTestingLearnMore.click();
            
            // Click on the "Learn More" button of Distributed Team section
            WebElement distributedTeamLearnMore = driver.findElement(By.xpath("//section[@id='distributed-team']//a[contains(text(),'Learn More')]"));
            distributedTeamLearnMore.click();
            
        } finally {
            driver.quit();
        }
    }
}