```java
// Main Test Script
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QASymphonyTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        QASymphonyPage qaSymphonyPage = new QASymphonyPage(driver);
        
        driver.get("http://www.qasymphony.com/platform.html");
        
        qaSymphonyPage.clickAgileTestingSubMenu();
        qaSymphonyPage.clickGetFreeTrial();
        qaSymphonyPage.clickScaleAgileLearnMore();
        qaSymphonyPage.clickExplorerTestingLearnMore();
        qaSymphonyPage.clickDistributedTeamLearnMore();
        
        driver.quit();
    }
}

// Page Object Model (POM) File
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QASymphonyPage {
    WebDriver driver;
    
    By agileTestingSubMenu = By.linkText("Agile Testing");
    By getFreeTrialButton = By.linkText("Get Free Trial");
    By scaleAgileLearnMore = By.linkText("Learn More");
    By explorerTestingLearnMore = By.linkText("Learn More");
    By distributedTeamLearnMore = By.linkText("Learn More");
    
    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickAgileTestingSubMenu() {
        WebElement agileTesting = driver.findElement(agileTestingSubMenu);
        agileTesting.click();
    }
    
    public void clickGetFreeTrial() {
        WebElement getFreeTrial = driver.findElement(getFreeTrialButton);
        getFreeTrial.click();
    }
    
    public void clickScaleAgileLearnMore() {
        WebElement scaleAgile = driver.findElements(scaleAgileLearnMore).get(0);
        scaleAgile.click();
    }
    
    public void clickExplorerTestingLearnMore() {
        WebElement explorerTesting = driver.findElements(explorerTestingLearnMore).get(1);
        explorerTesting.click();
    }
    
    public void clickDistributedTeamLearnMore() {
        WebElement distributedTeam = driver.findElements(distributedTeamLearnMore).get(2);
        distributedTeam.click();
    }
}
```