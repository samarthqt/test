package bdd.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class HomePage extends WebReusableComponents {

    protected By btnGetFreeTrial = By.id("getFreeTrialButton");
    protected By btnScaleAgileLearnMore = By.id("scaleAgileLearnMore");
    protected By btnExplorerTestingLearnMore = By.id("explorerTestingLearnMore");
    protected By btnDistributedTeamLearnMore = By.id("distributedTeamLearnMore");
    protected By btnIntegrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get(getAppUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("home"), "Navigation to home page failed.");
    }

    public void clickGetFreeTrialButton() {
        waitUntilElementVisible(btnGetFreeTrial, 3);
        clickElement(btnGetFreeTrial);
        Assert.assertTrue(isElementVisible(btnGetFreeTrial), "Get Free Trial button click failed.");
    }

    public void verifyFreeTrialPageRedirection() {
        String expectedURL = "expectedFreeTrialPageURL";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the free trial registration page.");
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(btnScaleAgileLearnMore, 3);
        clickElement(btnScaleAgileLearnMore);
        Assert.assertTrue(isElementVisible(btnScaleAgileLearnMore), "Scale Agile Learn More button click failed.");
    }

    public void verifyScaleAgilePageRedirection() {
        String expectedURL = "expectedScaleAgilePageURL";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the Scale Agile information page.");
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(btnExplorerTestingLearnMore, 3);
        clickElement(btnExplorerTestingLearnMore);
        Assert.assertTrue(isElementVisible(btnExplorerTestingLearnMore), "Explorer Testing Learn More button click failed.");
    }

    public void verifyExplorerTestingPageRedirection() {
        String expectedURL = "expectedExplorerTestingPageURL";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the Explorer Testing information page.");
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(btnDistributedTeamLearnMore, 3);
        clickElement(btnDistributedTeamLearnMore);
        Assert.assertTrue(isElementVisible(btnDistributedTeamLearnMore), "Distributed Team Learn More button click failed.");
    }

    public void verifyDistributedTeamPageRedirection() {
        String expectedURL = "expectedDistributedTeamPageURL";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the Distributed Team information page.");
    }

    public void clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(btnIntegrationAPIsLearnMore, 3);
        clickElement(btnIntegrationAPIsLearnMore);
        Assert.assertTrue(isElementVisible(btnIntegrationAPIsLearnMore), "Integration APIs Learn More button click failed.");
    }

    public void verifyIntegrationAPIsPageRedirection() {
        String expectedURL = "expectedIntegrationAPIsPageURL";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the Integration & APIs information page.");
    }
}