package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By getFreeTrialButton = By.id("getFreeTrialButton");
    private final By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    private final By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    private final By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    private final By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the browser.
     */
    public void openBrowser() {
        launchBrowser();
        Assert.assertTrue(isBrowserOpen(), "Browser did not open successfully.");
    }

    /**
     * Enters the specified URL.
     * @param url The URL to navigate to.
     */
    public void enterUrl(String url) {
        launchUrl(url);
        Assert.assertEquals(getCurrentURL(), url, "URL did not match the expected value.");
    }

    /**
     * Clicks on the Agile Testing submenu.
     */
    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Agile Testing submenu was not clicked successfully.");
    }

    /**
     * Clicks the Get Free Trial button.
     */
    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 3);
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementVisible(getFreeTrialButton), "Get Free Trial button was not clicked successfully.");
    }

    /**
     * Clicks the Scale Agile Learn More link.
     */
    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMore, 3);
        clickElement(scaleAgileLearnMore);
        Assert.assertTrue(isElementVisible(scaleAgileLearnMore), "Scale Agile Learn More link was not clicked successfully.");
    }

    /**
     * Clicks the Explorer Testing Learn More link.
     */
    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMore, 3);
        clickElement(explorerTestingLearnMore);
        Assert.assertTrue(isElementVisible(explorerTestingLearnMore), "Explorer Testing Learn More link was not clicked successfully.");
    }

    /**
     * Clicks the Distributed Team Learn More link.
     */
    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMore, 3);
        clickElement(distributedTeamLearnMore);
        Assert.assertTrue(isElementVisible(distributedTeamLearnMore), "Distributed Team Learn More link was not clicked successfully.");
    }

    /**
     * Clicks the Integration APIs Learn More link.
     */
    public void clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMore, 3);
        clickElement(integrationAPIsLearnMore);
        Assert.assertTrue(isElementVisible(integrationAPIsLearnMore), "Integration APIs Learn More link was not clicked successfully.");
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        quitBrowser();
        Assert.assertFalse(isBrowserOpen(), "Browser did not close successfully.");
    }

    /**
     * Checks if the browser is open.
     * @return true if the browser is open, false otherwise.
     */
    private boolean isBrowserOpen() {
        // Implement logic to check if the browser is open
        return driver != null;
    }

    /**
     * Checks if an element is visible.
     * @param locator The locator of the element.
     * @return true if the element is visible, false otherwise.
     */
    private boolean isElementVisible(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }
}