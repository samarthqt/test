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
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "Navigation to URL failed.");
    }

    public void clickAgileTestingSubMenu() {
        WebElement agileTestingSubMenu = driver.findElement(By.id("agileTestingSubMenu"));
        agileTestingSubMenu.click();
        Assert.assertTrue(agileTestingSubMenu.isDisplayed(), "Agile Testing SubMenu is not displayed.");
    }

    public void clickGetFreeTrial() {
        WebElement getFreeTrialButton = driver.findElement(By.id("getFreeTrial"));
        getFreeTrialButton.click();
        Assert.assertTrue(getFreeTrialButton.isDisplayed(), "Get Free Trial button is not displayed.");
    }

    public boolean clickScaleAgileLearnMore() {
        WebElement scaleAgileLearnMore = driver.findElement(By.id("scaleAgileLearnMore"));
        scaleAgileLearnMore.click();
        boolean isDisplayed = scaleAgileLearnMore.isDisplayed();
        Assert.assertTrue(isDisplayed, "Scale Agile Learn More is not displayed.");
        return isDisplayed;
    }

    public boolean clickExplorerTestingLearnMore() {
        WebElement explorerTestingLearnMore = driver.findElement(By.id("explorerTestingLearnMore"));
        explorerTestingLearnMore.click();
        boolean isDisplayed = explorerTestingLearnMore.isDisplayed();
        Assert.assertTrue(isDisplayed, "Explorer Testing Learn More is not displayed.");
        return isDisplayed;
    }

    public boolean clickDistributedTeamLearnMore() {
        WebElement distributedTeamLearnMore = driver.findElement(By.id("distributedTeamLearnMore"));
        distributedTeamLearnMore.click();
        boolean isDisplayed = distributedTeamLearnMore.isDisplayed();
        Assert.assertTrue(isDisplayed, "Distributed Team Learn More is not displayed.");
        return isDisplayed;
    }

    public boolean clickIntegrationAPIsLearnMore() {
        WebElement integrationAPIsLearnMore = driver.findElement(By.id("integrationAPIsLearnMore"));
        integrationAPIsLearnMore.click();
        boolean isDisplayed = integrationAPIsLearnMore.isDisplayed();
        Assert.assertTrue(isDisplayed, "Integration APIs Learn More is not displayed.");
        return isDisplayed;
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Browser did not close properly.");
    }
}