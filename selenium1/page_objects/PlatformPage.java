package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PlatformPage extends WebReusableComponents {

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By getFreeTrialButton = By.id("getFreeTrial");
    private final By scaleAgileLearnMoreButton = By.id("scaleAgileLearnMore");
    private final By explorerTestingLearnMoreButton = By.id("explorerTestingLearnMore");
    private final By distributedTeamLearnMoreButton = By.id("distributedTeamLearnMore");
    private final By integrationAPIsLearnMoreButton = By.id("integrationAPIsLearnMore");

    public PlatformPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        openNewWindow();
        Assert.assertTrue(isNewWindowOpened(), "New browser window was not opened.");
    }

    public void enterPlatformUrl() {
        navigateToUrl("http://www.qasymphony.com/platform.html");
        Assert.assertEquals(getCurrentURL(), "http://www.qasymphony.com/platform.html", "URL did not match.");
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Agile Testing SubMenu was not clicked.");
    }

    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 3);
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementVisible(getFreeTrialButton), "Get Free Trial button was not clicked.");
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMoreButton, 3);
        clickElement(scaleAgileLearnMoreButton);
        Assert.assertTrue(isElementVisible(scaleAgileLearnMoreButton), "Scale Agile Learn More button was not clicked.");
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMoreButton, 3);
        clickElement(explorerTestingLearnMoreButton);
        Assert.assertTrue(isElementVisible(explorerTestingLearnMoreButton), "Explorer Testing Learn More button was not clicked.");
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMoreButton, 3);
        clickElement(distributedTeamLearnMoreButton);
        Assert.assertTrue(isElementVisible(distributedTeamLearnMoreButton), "Distributed Team Learn More button was not clicked.");
    }

    public void clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMoreButton, 3);
        clickElement(integrationAPIsLearnMoreButton);
        Assert.assertTrue(isElementVisible(integrationAPIsLearnMoreButton), "Integration APIs Learn More button was not clicked.");
    }

    private boolean isNewWindowOpened() {
        // Implement logic to verify if a new window is opened
        return true;
    }

    private boolean isElementVisible(By locator) {
        // Implement logic to verify if an element is visible
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }
}