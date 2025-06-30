package selenium1.page_objects;

import org.openqa.selenium.support.PageFactory;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AgileTestingPage extends WebReusableComponents {

    private By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private By getFreeTrialButton = By.id("getFreeTrial");
    private By learnMoreScaleAgile = By.id("learnMoreScaleAgile");
    private By learnMoreExplorerTesting = By.id("learnMoreExplorerTesting");
    private By learnMoreDistributedTeam = By.id("learnMoreDistributedTeam");
    private By learnMoreIntegrationAPIs = By.id("learnMoreIntegrationAPIs");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        launchUrl("http://www.qasymphony.com/platform.html");
        maximizeWindow();
        Assert.assertTrue(isElementDisplayed(agileTestingSubMenu), "Agile Testing SubMenu is not displayed.");
    }

    public void navigateToPlatformPage() {
        waitUntilElementVisible(agileTestingSubMenu, 5);
        Assert.assertTrue(isElementDisplayed(agileTestingSubMenu), "Failed to navigate to Platform Page.");
    }

    public void clickAgileTestingSubMenu() {
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementDisplayed(getFreeTrialButton), "Failed to click Agile Testing SubMenu.");
    }

    public boolean isAgileTestingPageDisplayed() {
        boolean isDisplayed = isElementDisplayed(agileTestingSubMenu);
        Assert.assertTrue(isDisplayed, "Agile Testing Page is not displayed.");
        return isDisplayed;
    }

    public void clickGetFreeTrial() {
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementDisplayed(learnMoreScaleAgile), "Failed to click Get Free Trial.");
    }

    public void clickLearnMoreScaleAgile() {
        clickElement(learnMoreScaleAgile);
        Assert.assertTrue(isElementDisplayed(learnMoreExplorerTesting), "Failed to click Learn More Scale Agile.");
    }

    public void clickLearnMoreExplorerTesting() {
        clickElement(learnMoreExplorerTesting);
        Assert.assertTrue(isElementDisplayed(learnMoreDistributedTeam), "Failed to click Learn More Explorer Testing.");
    }

    public void clickLearnMoreDistributedTeam() {
        clickElement(learnMoreDistributedTeam);
        Assert.assertTrue(isElementDisplayed(learnMoreIntegrationAPIs), "Failed to click Learn More Distributed Team.");
    }

    public void clickLearnMoreIntegrationAPIs() {
        clickElement(learnMoreIntegrationAPIs);
        Assert.assertTrue(isElementDisplayed(agileTestingSubMenu), "Failed to click Learn More Integration APIs.");
    }

    public void closeBrowser() {
        closeDriver();
        Assert.assertFalse(isElementDisplayed(agileTestingSubMenu), "Browser did not close properly.");
    }
}