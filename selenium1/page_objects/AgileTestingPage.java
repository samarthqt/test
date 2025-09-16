package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By getFreeTrialButton = By.id("getFreeTrial");
    private final By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    private final By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    private final By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    private final By integrationApisLearnMore = By.id("integrationApisLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        launchBrowser();
        Assert.assertTrue(isBrowserLaunched(), "Browser did not launch successfully.");
    }

    public void enterUrl(String url) {
        navigateToUrl(url);
        Assert.assertEquals(getCurrentURL(), url, "URL did not match the expected URL.");
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementDisplayed(agileTestingSubMenu), "Agile Testing Sub Menu is not displayed.");
    }

    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 3);
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementDisplayed(getFreeTrialButton), "Get Free Trial button is not displayed.");
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMore, 3);
        clickElement(scaleAgileLearnMore);
        Assert.assertTrue(isElementDisplayed(scaleAgileLearnMore), "Scale Agile Learn More is not displayed.");
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMore, 3);
        clickElement(explorerTestingLearnMore);
        Assert.assertTrue(isElementDisplayed(explorerTestingLearnMore), "Explorer Testing Learn More is not displayed.");
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMore, 3);
        clickElement(distributedTeamLearnMore);
        Assert.assertTrue(isElementDisplayed(distributedTeamLearnMore), "Distributed Team Learn More is not displayed.");
    }

    public void clickIntegrationApisLearnMore() {
        waitUntilElementVisible(integrationApisLearnMore, 3);
        clickElement(integrationApisLearnMore);
        Assert.assertTrue(isElementDisplayed(integrationApisLearnMore), "Integration APIs Learn More is not displayed.");
    }

    public boolean isAgileTestingPageDisplayed() {
        boolean isDisplayed = isElementDisplayed(agileTestingSubMenu);
        Assert.assertTrue(isDisplayed, "Agile Testing Page is not displayed.");
        return isDisplayed;
    }

    public void closeBrowser() {
        quitBrowser();
        Assert.assertFalse(isBrowserLaunched(), "Browser did not close successfully.");
    }
}