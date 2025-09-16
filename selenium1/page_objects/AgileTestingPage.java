package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AgileTestingPage {

    private WebDriver driver;

    public AgileTestingPage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void navigateToPlatformPage() {
        driver.get("http://www.qasymphony.com/platform.html");
        Assert.assertTrue(driver.getCurrentUrl().contains("platform"), "Failed to navigate to platform page.");
    }

    public void clickAgileTestingSubMenu() {
        WebElement agileTestingSubMenu = driver.findElement(By.linkText("Agile Testing"));
        agileTestingSubMenu.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("agile-testing"), "Failed to navigate to Agile Testing sub-menu.");
    }

    public void clickGetFreeTrial() {
        WebElement getFreeTrialButton = driver.findElement(By.id("getFreeTrial"));
        getFreeTrialButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"), "Failed to navigate to Free Trial page.");
    }

    public boolean clickScaleAgileLearnMore() {
        WebElement scaleAgileLearnMore = driver.findElement(By.id("scaleAgileLearnMore"));
        scaleAgileLearnMore.click();
        boolean isCorrectPage = driver.getCurrentUrl().contains("scale-agile");
        Assert.assertTrue(isCorrectPage, "Failed to navigate to Scale Agile page.");
        return isCorrectPage;
    }

    public boolean clickExplorerTestingLearnMore() {
        WebElement explorerTestingLearnMore = driver.findElement(By.id("explorerTestingLearnMore"));
        explorerTestingLearnMore.click();
        boolean isCorrectPage = driver.getCurrentUrl().contains("explorer-testing");
        Assert.assertTrue(isCorrectPage, "Failed to navigate to Explorer Testing page.");
        return isCorrectPage;
    }

    public boolean clickDistributedTeamLearnMore() {
        WebElement distributedTeamLearnMore = driver.findElement(By.id("distributedTeamLearnMore"));
        distributedTeamLearnMore.click();
        boolean isCorrectPage = driver.getCurrentUrl().contains("distributed-team");
        Assert.assertTrue(isCorrectPage, "Failed to navigate to Distributed Team page.");
        return isCorrectPage;
    }

    public boolean clickIntegrationAPIsLearnMore() {
        WebElement integrationAPIsLearnMore = driver.findElement(By.id("integrationAPIsLearnMore"));
        integrationAPIsLearnMore.click();
        boolean isCorrectPage = driver.getCurrentUrl().contains("integration-apis");
        Assert.assertTrue(isCorrectPage, "Failed to navigate to Integration APIs page.");
        return isCorrectPage;
    }

    public void closeBrowser() {
        driver.quit();
    }
}