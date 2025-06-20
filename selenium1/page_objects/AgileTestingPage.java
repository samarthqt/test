package selenium1.page_objects;

import org.openqa.selenium.By;
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

    public void openBrowser() {
        launchUrl("http://www.qasymphony.com/platform.html");
        maximizeWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("platform.html"), "Failed to open the browser with the correct URL.");
    }

    public void navigateToPlatformPage() {
        waitUntilElementVisible(agileTestingSubMenu, 5);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Agile Testing SubMenu is not visible.");
    }

    public void clickAgileTestingSubMenu() {
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(getFreeTrialButton), "Failed to click Agile Testing SubMenu.");
    }

    public void callGetFreeTrial() {
        clickElement(getFreeTrialButton);
        Assert.assertTrue(driver.getCurrentUrl().contains("trial"), "Failed to navigate to Free Trial page.");
    }

    public void clickScaleAgileLearnMore() {
        clickElement(scaleAgileLearnMore);
        Assert.assertTrue(driver.getCurrentUrl().contains("scale-agile"), "Failed to navigate to Scale Agile Learn More page.");
    }

    public void clickExplorerTestingLearnMore() {
        clickElement(explorerTestingLearnMore);
        Assert.assertTrue(driver.getCurrentUrl().contains("explorer-testing"), "Failed to navigate to Explorer Testing Learn More page.");
    }

    public void clickDistributedTeamLearnMore() {
        clickElement(distributedTeamLearnMore);
        Assert.assertTrue(driver.getCurrentUrl().contains("distributed-team"), "Failed to navigate to Distributed Team Learn More page.");
    }

    public void clickIntegrationAPIsLearnMore() {
        clickElement(integrationAPIsLearnMore);
        Assert.assertTrue(driver.getCurrentUrl().contains("integration-apis"), "Failed to navigate to Integration APIs Learn More page.");
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Failed to close the browser.");
    }
}