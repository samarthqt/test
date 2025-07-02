package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    private By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private By getFreeTrialButton = By.id("getFreeTrial");
    private By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    private By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    private By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    private By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the platform page and verifies the visibility of the agile testing submenu.
     */
    public void navigateToPlatformPage() {
        launchUrl("http://www.qasymphony.com/platform.html");
        waitUntilElementVisible(agileTestingSubMenu, 5);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Agile Testing SubMenu is not visible.");
    }

    /**
     * Clicks on the agile testing submenu and verifies the action.
     */
    public void clickAgileTestingSubMenu() {
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(getFreeTrialButton), "Failed to click Agile Testing SubMenu.");
    }

    /**
     * Clicks on the 'Get Free Trial' button and verifies the action.
     */
    public void clickGetFreeTrial() {
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementVisible(scaleAgileLearnMore), "Failed to click Get Free Trial button.");
    }

    /**
     * Clicks on the 'Scale Agile Learn More' link and verifies the action.
     */
    public void clickScaleAgileLearnMore() {
        clickElement(scaleAgileLearnMore);
        Assert.assertTrue(isElementVisible(explorerTestingLearnMore), "Failed to click Scale Agile Learn More link.");
    }

    /**
     * Clicks on the 'Explorer Testing Learn More' link and verifies the action.
     */
    public void clickExplorerTestingLearnMore() {
        clickElement(explorerTestingLearnMore);
        Assert.assertTrue(isElementVisible(distributedTeamLearnMore), "Failed to click Explorer Testing Learn More link.");
    }

    /**
     * Clicks on the 'Distributed Team Learn More' link and verifies the action.
     */
    public void clickDistributedTeamLearnMore() {
        clickElement(distributedTeamLearnMore);
        Assert.assertTrue(isElementVisible(integrationAPIsLearnMore), "Failed to click Distributed Team Learn More link.");
    }

    /**
     * Clicks on the 'Integration APIs Learn More' link and verifies the action.
     */
    public void clickIntegrationAPIsLearnMore() {
        clickElement(integrationAPIsLearnMore);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Failed to click Integration APIs Learn More link.");
    }

    /**
     * Helper method to check if an element is visible.
     * @param locator The locator of the element.
     * @return True if the element is visible, false otherwise.
     */
    public boolean isElementVisible(By locator) {
        WebElement element = findElement(locator);
        return element != null && element.isDisplayed();
    }
}