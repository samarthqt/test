package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrial");
    protected By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    protected By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
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
        waitUntilElementVisible(agileTestingSubMenu, 3);
        WebElement element = driver.findElement(agileTestingSubMenu);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing submenu is not displayed.");
    }

    /**
     * Clicks the 'Get Free Trial' button.
     */
    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 3);
        WebElement element = driver.findElement(getFreeTrialButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button is not displayed.");
    }

    /**
     * Clicks the 'Scale Agile Learn More' link.
     * @return True if the link is displayed after clicking.
     */
    public boolean clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMore, 3);
        WebElement element = driver.findElement(scaleAgileLearnMore);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Scale Agile Learn More link is not displayed.");
        return isDisplayed;
    }

    /**
     * Clicks the 'Explorer Testing Learn More' link.
     * @return True if the link is displayed after clicking.
     */
    public boolean clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMore, 3);
        WebElement element = driver.findElement(explorerTestingLearnMore);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Explorer Testing Learn More link is not displayed.");
        return isDisplayed;
    }

    /**
     * Clicks the 'Distributed Team Learn More' link.
     * @return True if the link is displayed after clicking.
     */
    public boolean clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMore, 3);
        WebElement element = driver.findElement(distributedTeamLearnMore);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Distributed Team Learn More link is not displayed.");
        return isDisplayed;
    }

    /**
     * Clicks the 'Integration APIs Learn More' link.
     * @return True if the link is displayed after clicking.
     */
    public boolean clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMore, 3);
        WebElement element = driver.findElement(integrationAPIsLearnMore);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Integration APIs Learn More link is not displayed.");
        return isDisplayed;
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Driver is not null after quitting.");
    }
}