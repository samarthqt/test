package selenium1.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AgileTestingPage extends WebReusableComponents {

    @FindBy(id = "agileTestingSubMenu")
    private WebElement agileTestingSubMenu;

    @FindBy(id = "getFreeTrial")
    private WebElement getFreeTrialButton;

    @FindBy(id = "scaleAgileLearnMore")
    private WebElement scaleAgileLearnMore;

    @FindBy(id = "explorerTestingLearnMore")
    private WebElement explorerTestingLearnMore;

    @FindBy(id = "distributedTeamLearnMore")
    private WebElement distributedTeamLearnMore;

    @FindBy(id = "integrationAPIsLearnMore")
    private WebElement integrationAPIsLearnMore;

    private WebDriver driver;
    private WebDriverWait wait;

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void enterUrl(String url) {
        driver.get(url);
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu);
        agileTestingSubMenu.click();
        Assert.assertTrue(agileTestingSubMenu.isDisplayed(), "Agile Testing SubMenu is not displayed after click.");
    }

    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton);
        getFreeTrialButton.click();
        Assert.assertTrue(getFreeTrialButton.isDisplayed(), "Get Free Trial button is not displayed after click.");
    }

    public boolean clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMore);
        scaleAgileLearnMore.click();
        boolean isDisplayed = scaleAgileLearnMore.isDisplayed();
        Assert.assertTrue(isDisplayed, "Scale Agile Learn More is not displayed after click.");
        return isDisplayed;
    }

    public boolean clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMore);
        explorerTestingLearnMore.click();
        boolean isDisplayed = explorerTestingLearnMore.isDisplayed();
        Assert.assertTrue(isDisplayed, "Explorer Testing Learn More is not displayed after click.");
        return isDisplayed;
    }

    public boolean clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMore);
        distributedTeamLearnMore.click();
        boolean isDisplayed = distributedTeamLearnMore.isDisplayed();
        Assert.assertTrue(isDisplayed, "Distributed Team Learn More is not displayed after click.");
        return isDisplayed;
    }

    public boolean clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMore);
        integrationAPIsLearnMore.click();
        boolean isDisplayed = integrationAPIsLearnMore.isDisplayed();
        Assert.assertTrue(isDisplayed, "Integration APIs Learn More is not displayed after click.");
        return isDisplayed;
    }

    public void closeBrowser() {
        driver.quit();
    }

    private void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}