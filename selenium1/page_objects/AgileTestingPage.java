package selenium1.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AgileTestingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AgileTestingPage() {
        this.driver = WebDriverManager.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void navigateToPlatformPage() {
        driver.get("http://www.qasymphony.com/platform.html");
    }

    public void clickAgileTestingSubMenu() {
        WebElement agileTestingSubMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("agileTestingSubMenu")));
        agileTestingSubMenu.click();
        Assert.assertTrue(agileTestingSubMenu.isDisplayed(), "Agile Testing SubMenu is not displayed after clicking.");
    }

    public void clickGetFreeTrial() {
        WebElement getFreeTrialButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("getFreeTrialButton")));
        getFreeTrialButton.click();
        Assert.assertTrue(getFreeTrialButton.isDisplayed(), "Get Free Trial button is not displayed after clicking.");
    }

    public boolean clickScaleAgileLearnMore() {
        WebElement scaleAgileLearnMoreButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("scaleAgileLearnMoreButton")));
        scaleAgileLearnMoreButton.click();
        boolean isDisplayed = scaleAgileLearnMoreButton.isDisplayed();
        Assert.assertTrue(isDisplayed, "Scale Agile Learn More button is not displayed after clicking.");
        return isDisplayed;
    }

    public boolean clickExplorerTestingLearnMore() {
        WebElement explorerTestingLearnMoreButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("explorerTestingLearnMoreButton")));
        explorerTestingLearnMoreButton.click();
        boolean isDisplayed = explorerTestingLearnMoreButton.isDisplayed();
        Assert.assertTrue(isDisplayed, "Explorer Testing Learn More button is not displayed after clicking.");
        return isDisplayed;
    }

    public boolean clickDistributedTeamLearnMore() {
        WebElement distributedTeamLearnMoreButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("distributedTeamLearnMoreButton")));
        distributedTeamLearnMoreButton.click();
        boolean isDisplayed = distributedTeamLearnMoreButton.isDisplayed();
        Assert.assertTrue(isDisplayed, "Distributed Team Learn More button is not displayed after clicking.");
        return isDisplayed;
    }

    public boolean clickIntegrationAPIsLearnMore() {
        WebElement integrationAPIsLearnMoreButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("integrationAPIsLearnMoreButton")));
        integrationAPIsLearnMoreButton.click();
        boolean isDisplayed = integrationAPIsLearnMoreButton.isDisplayed();
        Assert.assertTrue(isDisplayed, "Integration APIs Learn More button is not displayed after clicking.");
        return isDisplayed;
    }

    public void closeBrowser() {
        driver.quit();
    }
}