package selenium1.page_objects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AgileTestingPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrialButton");
    protected By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    protected By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the browser and navigates to the platform page.
     */
    public void openBrowser() {
        launchUrl("http://www.qasymphony.com/platform.html");
        Assert.assertTrue(driver.getCurrentUrl().contains("platform.html"), "Failed to open platform page.");
    }

    /**
     * Navigates to the platform page by ensuring the agile testing submenu is visible.
     */
    public void navigateToPlatformPage() {
        waitUntilElementVisible(agileTestingSubMenu, 5);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Agile Testing SubMenu is not visible.");
    }

    /**
     * Clicks on the Agile Testing submenu.
     */
    public void clickAgileTestingSubMenu() {
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(getFreeTrialButton), "Failed to click Agile Testing SubMenu.");
    }

    /**
     * Clicks on the Get Free Trial button.
     */
    public void clickGetFreeTrial() {
        clickElement(getFreeTrialButton);
        Assert.assertTrue(driver.getCurrentUrl().contains("trial"), "Failed to navigate to Free Trial page.");
    }

    /**
     * Clicks on the Scale Agile Learn More link.
     */
    public void clickScaleAgileLearnMore() {
        clickElement(scaleAgileLearnMore);
        Assert.assertTrue(driver.getCurrentUrl().contains("scale-agile"), "Failed to navigate to Scale Agile page.");
    }

    /**
     * Clicks on the Explorer Testing Learn More link.
     */
    public void clickExplorerTestingLearnMore() {
        clickElement(explorerTestingLearnMore);
        Assert.assertTrue(driver.getCurrentUrl().contains("explorer-testing"), "Failed to navigate to Explorer Testing page.");
    }

    /**
     * Clicks on the Distributed Team Learn More link.
     */
    public void clickDistributedTeamLearnMore() {
        clickElement(distributedTeamLearnMore);
        Assert.assertTrue(driver.getCurrentUrl().contains("distributed-team"), "Failed to navigate to Distributed Team page.");
    }

    /**
     * Clicks on the Integration APIs Learn More link.
     */
    public void clickIntegrationAPIsLearnMore() {
        clickElement(integrationAPIsLearnMore);
        Assert.assertTrue(driver.getCurrentUrl().contains("integration-apis"), "Failed to navigate to Integration APIs page.");
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Failed to close the browser.");
    }
}