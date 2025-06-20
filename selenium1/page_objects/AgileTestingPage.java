package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AgileTestingPage extends WebReusableComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By getFreeTrialButton = By.id("getFreeTrial");
    private final By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    private final By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    private final By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    private final By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        this.driver = WebReusableComponents.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the browser and maximizes the window.
     */
    public void openBrowser() {
        driver.manage().window().maximize();
    }

    /**
     * Navigates to the specified URL.
     * @param url The URL to navigate to.
     */
    public void enterUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL did not match after navigation.");
    }

    /**
     * Clicks on the Agile Testing submenu.
     */
    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu);
        WebElement element = driver.findElement(agileTestingSubMenu);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing submenu is not visible after click.");
    }

    /**
     * Clicks the Get Free Trial button.
     */
    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton);
        WebElement element = driver.findElement(getFreeTrialButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button is not visible after click.");
    }

    /**
     * Clicks the Scale Agile Learn More link.
     */
    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMore);
        WebElement element = driver.findElement(scaleAgileLearnMore);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Scale Agile Learn More link is not visible after click.");
    }

    /**
     * Clicks the Explorer Testing Learn More link.
     */
    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMore);
        WebElement element = driver.findElement(explorerTestingLearnMore);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Explorer Testing Learn More link is not visible after click.");
    }

    /**
     * Clicks the Distributed Team Learn More link.
     */
    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMore);
        WebElement element = driver.findElement(distributedTeamLearnMore);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Distributed Team Learn More link is not visible after click.");
    }

    /**
     * Clicks the Integration APIs Learn More link.
     */
    public void clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMore);
        WebElement element = driver.findElement(integrationAPIsLearnMore);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Integration APIs Learn More link is not visible after click.");
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Driver is not null after quitting.");
    }

    /**
     * Waits until the specified element is visible.
     * @param locator The locator of the element to wait for.
     */
    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}