```java
// Main Test Script
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class QASymphonyTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        QASymphonyPage qaSymphonyPage = new QASymphonyPage(driver);
        
        driver.get("http://www.qasymphony.com/platform.html");
        qaSymphonyPage.clickAgileTestingSubMenu();
        qaSymphonyPage.clickGetFreeTrial();
        qaSymphonyPage.clickScaleAgileLearnMore();
        qaSymphonyPage.clickExplorerTestingLearnMore();
        qaSymphonyPage.clickDistributedTeamLearnMore();
        qaSymphonyPage.clickIntegrationAPIsLearnMore();

        driver.quit();
    }
}

// Page Object Model File
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QASymphonyPage {
    WebDriver driver;

    By agileTestingSubMenu = By.linkText("Agile Testing");
    By getFreeTrialButton = By.linkText("Get Free Trial");
    By scaleAgileLearnMore = By.xpath("//section[contains(@id, 'scale-agile')]//a[text()='Learn More']");
    By explorerTestingLearnMore = By.xpath("//section[contains(@id, 'explorer-testing')]//a[text()='Learn More']");
    By distributedTeamLearnMore = By.xpath("//section[contains(@id, 'distributed-team')]//a[text()='Learn More']");
    By integrationAPIsLearnMore = By.xpath("//section[contains(@id, 'integration-apis')]//a[text()='Learn More']");

    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAgileTestingSubMenu() {
        driver.findElement(agileTestingSubMenu).click();
    }

    public void clickGetFreeTrial() {
        driver.findElement(getFreeTrialButton).click();
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

    public void clickIntegrationAPIsLearnMore() {
        driver.findElement(integrationAPIsLearnMore).click();
    }
}
```