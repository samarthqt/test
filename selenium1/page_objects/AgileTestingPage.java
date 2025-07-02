package selenium1.page_objects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
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
        Assert.assertTrue(driver.getCurrentUrl().contains("platform"), "Failed to open platform page.");
    }

    public void navigateToPlatformPage() {
        waitUntilElementVisible(agileTestingSubMenu, 5);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Agile Testing Sub Menu is not visible.");
    }

    public void clickAgileTestingSubMenu() {
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(getFreeTrialButton), "Failed to navigate to Agile Testing section.");
    }

    public void clickGetFreeTrial() {
        clickElement(getFreeTrialButton);
        Assert.assertTrue(driver.getCurrentUrl().contains("trial"), "Failed to navigate to Free Trial page.");
    }

    public boolean clickScaleAgileLearnMore() {
        boolean result = clickElement(scaleAgileLearnMore);
        Assert.assertTrue(result, "Failed to click Scale Agile Learn More.");
        return result;
    }

    public boolean clickExplorerTestingLearnMore() {
        boolean result = clickElement(explorerTestingLearnMore);
        Assert.assertTrue(result, "Failed to click Explorer Testing Learn More.");
        return result;
    }

    public boolean clickDistributedTeamLearnMore() {
        boolean result = clickElement(distributedTeamLearnMore);
        Assert.assertTrue(result, "Failed to click Distributed Team Learn More.");
        return result;
    }

    public boolean clickIntegrationAPIsLearnMore() {
        boolean result = clickElement(integrationAPIsLearnMore);
        Assert.assertTrue(result, "Failed to click Integration APIs Learn More.");
        return result;
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertTrue(driver.toString().contains("(null)"), "Browser did not close properly.");
    }
}