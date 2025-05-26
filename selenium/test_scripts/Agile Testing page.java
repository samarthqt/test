// SeleniumTest.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        PlatformPage platformPage = new PlatformPage(driver);

        driver.get("http://www.qasymphony.com/platform.html");

        platformPage.clickAgileTestingSubMenu();
        platformPage.clickGetFreeTrial();
        platformPage.clickScaleAgileLearnMore();
        platformPage.clickExplorerTestingLearnMore();
        platformPage.clickDistributedTeamLearnMore();

        driver.quit();
    }
}

// PlatformPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlatformPage {
    private WebDriver driver;

    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By scaleAgileLearnMoreButton = By.xpath("//section[@id='scale-agile']//a[contains(text(),'Learn More')]");
    private By explorerTestingLearnMoreButton = By.xpath("//section[@id='explorer-testing']//a[contains(text(),'Learn More')]");
    private By distributedTeamLearnMoreButton = By.xpath("//section[@id='distributed-team']//a[contains(text(),'Learn More')]");

    public PlatformPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAgileTestingSubMenu() {
        WebElement agileTestingElement = driver.findElement(agileTestingSubMenu);
        agileTestingElement.click();
    }

    public void clickGetFreeTrial() {
        WebElement getFreeTrialElement = driver.findElement(getFreeTrialButton);
        getFreeTrialElement.click();
    }

    public void clickScaleAgileLearnMore() {
        WebElement scaleAgileElement = driver.findElement(scaleAgileLearnMoreButton);
        scaleAgileElement.click();
    }

    public void clickExplorerTestingLearnMore() {
        WebElement explorerTestingElement = driver.findElement(explorerTestingLearnMoreButton);
        explorerTestingElement.click();
    }

    public void clickDistributedTeamLearnMore() {
        WebElement distributedTeamElement = driver.findElement(distributedTeamLearnMoreButton);
        distributedTeamElement.click();
    }
}