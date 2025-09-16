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

    public void navigateToPlatformPage() {
        launchUrl("http://www.qasymphony.com/platform.html");
        waitUntilElementVisible(agileTestingSubMenu, 5);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Failed to navigate to Platform Page");
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(getFreeTrialButton), "Agile Testing SubMenu click failed");
    }

    public void clickGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 3);
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementVisible(learnMoreScaleAgile), "Get Free Trial button click failed");
    }

    public void clickLearnMoreScaleAgile() {
        waitUntilElementVisible(learnMoreScaleAgile, 3);
        clickElement(learnMoreScaleAgile);
        Assert.assertTrue(isElementVisible(learnMoreExplorerTesting), "Learn More Scale Agile click failed");
    }

    public void clickLearnMoreExplorerTesting() {
        waitUntilElementVisible(learnMoreExplorerTesting, 3);
        clickElement(learnMoreExplorerTesting);
        Assert.assertTrue(isElementVisible(learnMoreDistributedTeam), "Learn More Explorer Testing click failed");
    }

    public void clickLearnMoreDistributedTeam() {
        waitUntilElementVisible(learnMoreDistributedTeam, 3);
        clickElement(learnMoreDistributedTeam);
        Assert.assertTrue(isElementVisible(learnMoreIntegrationAPIs), "Learn More Distributed Team click failed");
    }

    public void clickLearnMoreIntegrationAPIs() {
        waitUntilElementVisible(learnMoreIntegrationAPIs, 3);
        clickElement(learnMoreIntegrationAPIs);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Learn More Integration APIs click failed");
    }

    private boolean isElementVisible(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}