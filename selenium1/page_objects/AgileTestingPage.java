
package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By getFreeTrialButton = By.id("getFreeTrial");
    private final By learnMoreScaleAgile = By.id("learnMoreScaleAgile");
    private final By learnMoreExplorerTesting = By.id("learnMoreExplorerTesting");
    private final By learnMoreDistributedTeam = By.id("learnMoreDistributedTeam");
    private final By learnMoreIntegrationAPIs = By.id("learnMoreIntegrationAPIs");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the platform page and verifies the agile testing submenu is visible.
     */
    public void navigateToPlatformPage() {
        launchUrl("http://www.qasymphony.com/platform.html");
        waitUntilElementVisible(agileTestingSubMenu, 5);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Agile Testing SubMenu is not visible.");
    }

    /**
     * Clicks on the Agile Testing SubMenu.
     */
    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(getFreeTrialButton), "Failed to click Agile Testing SubMenu.");
    }

    /**
     * Clicks on the Get Free Trial button.
     */
    public void clickGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 3);
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementVisible(learnMoreScaleAgile), "Failed to click Get Free Trial button.");
    }

    /**
     * Clicks on the Learn More Scale Agile link.
     */
    public void clickLearnMoreScaleAgile() {
        waitUntilElementVisible(learnMoreScaleAgile, 3);
        clickElement(learnMoreScaleAgile);
        Assert.assertTrue(isElementVisible(learnMoreExplorerTesting), "Failed to click Learn More Scale Agile link.");
    }

    /**
     * Clicks on the Learn More Explorer Testing link.
     */
    public void clickLearnMoreExplorerTesting() {
        waitUntilElementVisible(learnMoreExplorerTesting, 3);
        clickElement(learnMoreExplorerTesting);
        Assert.assertTrue(isElementVisible(learnMoreDistributedTeam), "Failed to click Learn More Explorer Testing link.");
    }

    /**
     * Clicks on the Learn More Distributed Team link.
     */
    public void clickLearnMoreDistributedTeam() {
        waitUntilElementVisible(learnMoreDistributedTeam, 3);
        clickElement(learnMoreDistributedTeam);
        Assert.assertTrue(isElementVisible(learnMoreIntegrationAPIs), "Failed to click Learn More Distributed Team link.");
    }

    /**
     * Clicks on the Learn More Integration APIs link.
     */
    public void clickLearnMoreIntegrationAPIs() {
        waitUntilElementVisible(learnMoreIntegrationAPIs, 3);
        clickElement(learnMoreIntegrationAPIs);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Failed to click Learn More Integration APIs link.");
    }

    /**
     * Helper method to check if an element is visible.
     * 
     * @param locator The locator of the element.
     * @return true if the element is visible, false otherwise.
     */
    private boolean isElementVisible(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
