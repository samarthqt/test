package selenium1.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
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

    public void enterUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL did not load correctly.");
    }

    public void clickAgileTestingSubMenu() {
        WebElement agileTestingSubMenu = driver.findElement(By.id("agileTestingSubMenu"));
        agileTestingSubMenu.click();
        Assert.assertTrue(agileTestingSubMenu.isDisplayed(), "Agile Testing SubMenu is not displayed.");
    }

    public void callGetFreeTrial() {
        WebElement getFreeTrialButton = driver.findElement(By.id("getFreeTrial"));
        getFreeTrialButton.click();
        Assert.assertTrue(getFreeTrialButton.isDisplayed(), "Get Free Trial button is not displayed.");
    }

    public boolean clickScaleAgileLearnMore() {
        WebElement scaleAgileLearnMoreButton = driver.findElement(By.id("scaleAgileLearnMore"));
        scaleAgileLearnMoreButton.click();
        boolean isDisplayed = scaleAgileLearnMoreButton.isDisplayed();
        Assert.assertTrue(isDisplayed, "Scale Agile Learn More button is not displayed.");
        return isDisplayed;
    }

    public boolean clickExplorerTestingLearnMore() {
        WebElement explorerTestingLearnMoreButton = driver.findElement(By.id("explorerTestingLearnMore"));
        explorerTestingLearnMoreButton.click();
        boolean isDisplayed = explorerTestingLearnMoreButton.isDisplayed();
        Assert.assertTrue(isDisplayed, "Explorer Testing Learn More button is not displayed.");
        return isDisplayed;
    }

    public boolean clickDistributedTeamLearnMore() {
        WebElement distributedTeamLearnMoreButton = driver.findElement(By.id("distributedTeamLearnMore"));
        distributedTeamLearnMoreButton.click();
        boolean isDisplayed = distributedTeamLearnMoreButton.isDisplayed();
        Assert.assertTrue(isDisplayed, "Distributed Team Learn More button is not displayed.");
        return isDisplayed;
    }

    public boolean clickIntegrationAPIsLearnMore() {
        WebElement integrationAPIsLearnMoreButton = driver.findElement(By.id("integrationAPIsLearnMore"));
        integrationAPIsLearnMoreButton.click();
        boolean isDisplayed = integrationAPIsLearnMoreButton.isDisplayed();
        Assert.assertTrue(isDisplayed, "Integration APIs Learn More button is not displayed.");
        return isDisplayed;
    }

    public void closeBrowser() {
        driver.quit();
    }
}