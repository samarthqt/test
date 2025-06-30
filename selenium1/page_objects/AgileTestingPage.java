package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

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
        maximizeWindow();
    }

    /**
     * Navigates to the platform page by ensuring the agile testing submenu is visible.
     */
    public void navigateToPlatformPage() {
        waitUntilElementVisible(agileTestingSubMenu, 5);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Agile Testing SubMenu is not visible.");
    }

    /**
     * Clicks on the Agile Testing SubMenu.
     */
    public void clickAgileTestingSubMenu() {
        clickElement(agileTestingSubMenu);
    }

    /**
     * Clicks on the Get Free Trial button.
     */
    public void clickGetFreeTrial() {
        clickElement(getFreeTrialButton);
    }

    /**
     * Checks if the Scale Agile section is visible.
     * @return true if visible, false otherwise
     */
    public boolean isScaleAgileSectionVisible() {
        boolean isVisible = isElementVisible(scaleAgileLearnMore);
        Assert.assertTrue(isVisible, "Scale Agile section is not visible.");
        return isVisible;
    }

    /**
     * Clicks on the Scale Agile Learn More link.
     */
    public void clickScaleAgileLearnMore() {
        clickElement(scaleAgileLearnMore);
    }

    /**
     * Checks if the Explorer Testing section is visible.
     * @return true if visible, false otherwise
     */
    public boolean isExplorerTestingSectionVisible() {
        boolean isVisible = isElementVisible(explorerTestingLearnMore);
        Assert.assertTrue(isVisible, "Explorer Testing section is not visible.");
        return isVisible;
    }

    /**
     * Clicks on the Explorer Testing Learn More link.
     */
    public void clickExplorerTestingLearnMore() {
        clickElement(explorerTestingLearnMore);
    }

    /**
     * Checks if the Distributed Team section is visible.
     * @return true if visible, false otherwise
     */
    public boolean isDistributedTeamSectionVisible() {
        boolean isVisible = isElementVisible(distributedTeamLearnMore);
        Assert.assertTrue(isVisible, "Distributed Team section is not visible.");
        return isVisible;
    }

    /**
     * Clicks on the Distributed Team Learn More link.
     */
    public void clickDistributedTeamLearnMore() {
        clickElement(distributedTeamLearnMore);
    }

    /**
     * Checks if the Integration APIs section is visible.
     * @return true if visible, false otherwise
     */
    public boolean isIntegrationAPIsSectionVisible() {
        boolean isVisible = isElementVisible(integrationAPIsLearnMore);
        Assert.assertTrue(isVisible, "Integration APIs section is not visible.");
        return isVisible;
    }

    /**
     * Clicks on the Integration APIs Learn More link.
     */
    public void clickIntegrationAPIsLearnMore() {
        clickElement(integrationAPIsLearnMore);
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        driver.quit();
    }
}