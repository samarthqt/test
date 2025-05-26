```java
// Main Test Script
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QASymphonyTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            QASymphonyPage qaSymphonyPage = new QASymphonyPage(driver);
            qaSymphonyPage.open();
            qaSymphonyPage.clickAgileTesting();
            qaSymphonyPage.clickGetFreeTrial();
            qaSymphonyPage.clickScaleAgileLearnMore();
            qaSymphonyPage.clickExplorerTestingLearnMore();
            qaSymphonyPage.clickDistributedTeamLearnMore();
        } finally {
            driver.quit();
        }
    }
}

// Page Object Model (POM) File
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QASymphonyPage {
    private WebDriver driver;
    private String url = "http://www.qasymphony.com/platform.html";
    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By scaleAgileLearnMore = By.xpath("//section[@id='scale-agile']//a[contains(text(),'Learn More')]");
    private By explorerTestingLearnMore = By.xpath("//section[@id='explorer-testing']//a[contains(text(),'Learn More')]");
    private By distributedTeamLearnMore = By.xpath("//section[@id='distributed-team']//a[contains(text(),'Learn More')]");

    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void clickAgileTesting() {
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
}
```