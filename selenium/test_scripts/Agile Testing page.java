// Test Script File: TestQASymphony.java

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestQASymphony {
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

// Page Object Model File: QASymphonyPage.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QASymphonyPage {
    private WebDriver driver;
    
    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrial = By.linkText("Get Free Trial");
    private By scaleAgileLearnMore = By.linkText("Learn More");
    private By explorerTestingLearnMore = By.linkText("Learn More");
    private By distributedTeamLearnMore = By.linkText("Learn More");
    
    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickAgileTestingSubMenu() {
        driver.findElement(agileTestingSubMenu).click();
    }
    
    public void clickGetFreeTrial() {
        driver.findElement(getFreeTrial).click();
    }
    
    public void clickScaleAgileLearnMore() {
        driver.findElement(scaleAgileLearnMore).click();
    }
    
    public void clickExplorerTestingLearnMore() {
        driver.findElement(explorerTestingLearnMore).click();
    }
    
    public void clickDistributedTeamLearnMore() {
        driver.findElement(distributedTeamLearnMore).click();
    }
}