package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AgileTestingPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrial");
    protected By scaleAgileLearnMoreButton = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMoreButton = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMoreButton = By.id("distributedTeamLearnMore");
    protected By integrationAPIsLearnMoreButton = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver = initializeDriver();
        Assert.assertNotNull(driver, "Driver initialization failed.");
    }

    public void enterUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL did not match.");
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 5);
        WebElement element = driver.findElement(agileTestingSubMenu);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing SubMenu is not displayed.");
    }

    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 5);
        WebElement element = driver.findElement(getFreeTrialButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button is not displayed.");
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMoreButton, 5);
        WebElement element = driver.findElement(scaleAgileLearnMoreButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Scale Agile Learn More button is not displayed.");
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMoreButton, 5);
        WebElement element = driver.findElement(explorerTestingLearnMoreButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Explorer Testing Learn More button is not displayed.");
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMoreButton, 5);
        WebElement element = driver.findElement(distributedTeamLearnMoreButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Distributed Team Learn More button is not displayed.");
    }

    public void clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMoreButton, 5);
        WebElement element = driver.findElement(integrationAPIsLearnMoreButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Integration APIs Learn More button is not displayed.");
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Driver did not quit successfully.");
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}