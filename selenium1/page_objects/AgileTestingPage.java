package selenium1.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    private WebDriver driver;

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
        driver = new WebDriver();
        driver.manage().window().maximize();
    }

    public void navigateToPlatformPage() {
        driver.get("http://www.qasymphony.com/platform.html");
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = driver.findElement(agileTestingSubMenu);
        waitUntilElementVisible(element, 3);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing SubMenu is not displayed after click.");
    }

    public void clickGetFreeTrial() {
        WebElement element = driver.findElement(getFreeTrialButton);
        waitUntilElementVisible(element, 3);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button is not displayed after click.");
    }

    public boolean clickScaleAgileLearnMore() {
        WebElement element = driver.findElement(scaleAgileLearnMore);
        waitUntilElementVisible(element, 3);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Scale Agile Learn More is not displayed after click.");
        return isDisplayed;
    }

    public boolean clickExplorerTestingLearnMore() {
        WebElement element = driver.findElement(explorerTestingLearnMore);
        waitUntilElementVisible(element, 3);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Explorer Testing Learn More is not displayed after click.");
        return isDisplayed;
    }

    public boolean clickDistributedTeamLearnMore() {
        WebElement element = driver.findElement(distributedTeamLearnMore);
        waitUntilElementVisible(element, 3);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Distributed Team Learn More is not displayed after click.");
        return isDisplayed;
    }

    public boolean clickIntegrationAPIsLearnMore() {
        WebElement element = driver.findElement(integrationAPIsLearnMore);
        waitUntilElementVisible(element, 3);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Integration APIs Learn More is not displayed after click.");
        return isDisplayed;
    }

    public void closeBrowser() {
        driver.quit();
    }
}