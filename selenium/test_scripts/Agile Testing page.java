Page Object Model file (PlatformPage.java):

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlatformPage {
    WebDriver driver;

    By agileTestingSubMenu = By.linkText("Agile Testing");
    By getFreeTrialButton = By.xpath("//a[contains(text(),'Get Free Trial')]");
    By scaleAgileLearnMoreButton = By.xpath("//a[contains(text(),'Scale Agile')]");
    By explorerTestingLearnMoreButton = By.xpath("//a[contains(text(),'eXplorer Testing')]");
    By distributedTeamLearnMoreButton = By.xpath("//a[contains(text(),'Distributed Team')]");

    public PlatformPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAgileTestingSubMenu() {
        driver.findElement(agileTestingSubMenu).click();
    }

    public void clickGetFreeTrial() {
        driver.findElement(getFreeTrialButton).click();
    }

    public void clickScaleAgileLearnMore() {
        driver.findElement(scaleAgileLearnMoreButton).click();
    }

    public void clickExplorerTestingLearnMore() {
        driver.findElement(explorerTestingLearnMoreButton).click();
    }

    public void clickDistributedTeamLearnMore() {
        driver.findElement(distributedTeamLearnMoreButton).click();
    }
}
```

Selenium Automation Script (TestPlatformPage.java):

```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPlatformPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.qasymphony.com/platform.html");

        PlatformPage platformPage = new PlatformPage(driver);

        platformPage.clickAgileTestingSubMenu();
        platformPage.clickGetFreeTrial();
        platformPage.clickScaleAgileLearnMore();
        platformPage.clickExplorerTestingLearnMore();
        platformPage.clickDistributedTeamLearnMore();

        driver.quit();
    }
}
```