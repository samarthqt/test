package selenium1.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AgileTestingPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrial");
    protected By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    protected By integrationApisLearnMore = By.id("integrationApisLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        // Initialize WebDriver and open browser
        driver = new WebDriver(); // Example initialization, replace with actual driver setup
        driver.manage().window().maximize();
    }

    public void enterUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL did not load correctly");
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = waitUntilElementVisible(agileTestingSubMenu, 3);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing SubMenu is not visible");
    }

    public void clickGetFreeTrial() {
        WebElement element = waitUntilElementVisible(getFreeTrialButton, 3);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button is not visible");
    }

    public boolean clickScaleAgileLearnMore() {
        WebElement element = waitUntilElementVisible(scaleAgileLearnMore, 3);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Scale Agile Learn More is not visible");
        return true;
    }

    public boolean clickExplorerTestingLearnMore() {
        WebElement element = waitUntilElementVisible(explorerTestingLearnMore, 3);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Explorer Testing Learn More is not visible");
        return true;
    }

    public boolean clickDistributedTeamLearnMore() {
        WebElement element = waitUntilElementVisible(distributedTeamLearnMore, 3);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Distributed Team Learn More is not visible");
        return true;
    }

    public boolean clickIntegrationApisLearnMore() {
        WebElement element = waitUntilElementVisible(integrationApisLearnMore, 3);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Integration APIs Learn More is not visible");
        return true;
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Browser did not close properly");
    }

    private WebElement waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}