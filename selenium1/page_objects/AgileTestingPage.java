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

    public void openBrowser() {
        launchUrl("http://www.qasymphony.com/platform.html");
        maximizeWindow();
        Assert.assertTrue(getCurrentURL().contains("platform"), "Failed to open the platform page.");
    }

    public void navigateToPlatformPage() {
        waitUntilElementVisible(agileTestingSubMenu, 5);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Agile Testing SubMenu is not visible.");
    }

    public void clickAgileTestingSubMenu() {
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(getFreeTrialButton), "Failed to navigate to Agile Testing section.");
    }

    public void clickGetFreeTrial() {
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementVisible(scaleAgileLearnMore), "Failed to click Get Free Trial button.");
    }

    public void clickScaleAgileLearnMore() {
        clickElement(scaleAgileLearnMore);
        Assert.assertTrue(isElementVisible(explorerTestingLearnMore), "Failed to click Scale Agile Learn More.");
    }

    public void clickExplorerTestingLearnMore() {
        clickElement(explorerTestingLearnMore);
        Assert.assertTrue(isElementVisible(distributedTeamLearnMore), "Failed to click Explorer Testing Learn More.");
    }

    public void clickDistributedTeamLearnMore() {
        clickElement(distributedTeamLearnMore);
        Assert.assertTrue(isElementVisible(integrationAPIsLearnMore), "Failed to click Distributed Team Learn More.");
    }

    public void clickIntegrationAPIsLearnMore() {
        clickElement(integrationAPIsLearnMore);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Failed to click Integration APIs Learn More.");
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Browser did not close properly.");
    }
}