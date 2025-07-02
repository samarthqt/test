package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrialButton");
    protected By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    protected By integrationApisLearnMore = By.id("integrationApisLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void openBrowser() {
        launchUrl(getAppUrl());
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Failed to open browser and navigate to the page.");
    }

    public void enterUrl(String url) {
        launchUrl(url);
        Assert.assertEquals(getCurrentURL(), url, "URL did not match the expected URL.");
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 5);
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(getFreeTrialButton), "Failed to click on Agile Testing Sub Menu.");
    }

    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 5);
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementVisible(scaleAgileLearnMore), "Failed to initiate Get Free Trial.");
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMore, 5);
        clickElement(scaleAgileLearnMore);
        Assert.assertTrue(isElementVisible(explorerTestingLearnMore), "Failed to click on Scale Agile Learn More.");
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMore, 5);
        clickElement(explorerTestingLearnMore);
        Assert.assertTrue(isElementVisible(distributedTeamLearnMore), "Failed to click on Explorer Testing Learn More.");
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMore, 5);
        clickElement(distributedTeamLearnMore);
        Assert.assertTrue(isElementVisible(integrationApisLearnMore), "Failed to click on Distributed Team Learn More.");
    }

    public void clickIntegrationApisLearnMore() {
        waitUntilElementVisible(integrationApisLearnMore, 5);
        clickElement(integrationApisLearnMore);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Failed to click on Integration APIs Learn More.");
    }
}