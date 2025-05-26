import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QASymphonyAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            // Opening new browser window
            driver.manage().window().maximize();
            
            // Enter "http://www.qasymphony.com/platform.html" URL
            driver.get("http://www.qasymphony.com/platform.html");
            
            // Click on the "Agile Testing" sub-menu
            WebElement agileTestingMenu = driver.findElement(By.linkText("Agile Testing"));
            agileTestingMenu.click();
            
            // Call Get Free Trial
            WebElement getFreeTrialButton = driver.findElement(By.linkText("Get Free Trial"));
            getFreeTrialButton.click();
            
            // Click on the content or Learn More button of Scale Agile section
            WebElement scaleAgileLearnMore = driver.findElement(By.linkText("Learn More"));
            scaleAgileLearnMore.click();
            
            // Click on the content or Learn More button of eXplorer Testing section
            WebElement explorerTestingLearnMore = driver.findElement(By.linkText("Learn More"));
            explorerTestingLearnMore.click();
            
            // Click on the content or Learn More button of Distributed Team section
            WebElement distributedTeamLearnMore = driver.findElement(By.linkText("Learn More"));
            distributedTeamLearnMore.click();
            
        } finally {
            // Close browser
            driver.quit();
        }
    }
}