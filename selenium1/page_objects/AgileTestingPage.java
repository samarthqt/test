package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AgileTestingPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrial");
    protected By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    protected By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void enterUrl(String url) {
        driver.get(url);
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(agileTestingSubMenu));
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing SubMenu is not displayed after click.");
    }

    public void callGetFreeTrial() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getFreeTrialButton));
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button is not displayed after click.");
    }

    public boolean clickScaleAgileLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(scaleAgileLearnMore));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Scale Agile Learn More is not displayed after click.");
        return isDisplayed;
    }

    public boolean clickExplorerTestingLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(explorerTestingLearnMore));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Explorer Testing Learn More is not displayed after click.");
        return isDisplayed;
    }

    public boolean clickDistributedTeamLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(distributedTeamLearnMore));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Distributed Team Learn More is not displayed after click.");
        return isDisplayed;
    }

    public boolean clickIntegrationAPIsLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(integrationAPIsLearnMore));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Integration APIs Learn More is not displayed after click.");
        return isDisplayed;
    }

    public void closeBrowser() {
        driver.quit();
    }
}