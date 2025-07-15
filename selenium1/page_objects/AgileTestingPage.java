package selenium1.page_objects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AgileTestingPage extends WebReusableComponents {

    protected WebDriver driver;

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrialButton");
    protected By scaleAgileLearnMoreButton = By.id("scaleAgileLearnMoreButton");
    protected By explorerTestingLearnMoreButton = By.id("explorerTestingLearnMoreButton");
    protected By distributedTeamLearnMoreButton = By.id("distributedTeamLearnMoreButton");
    protected By integrationApisLearnMoreButton = By.id("integrationApisLearnMoreButton");

    public AgileTestingPage() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the browser and maximizes the window.
     */
    public void openBrowser() {
        driver.manage().window().maximize();
    }

    /**
     * Navigates to the specified URL.
     * @param url The URL to navigate to.
     */
    public void enterUrl(String url) {
        driver.get(url);
    }

    /**
     * Clicks the Agile Testing submenu.
     */
    public void clickAgileTestingSubMenu() {
        WebElement element = driver.findElement(agileTestingSubMenu);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing submenu is not displayed.");
    }

    /**
     * Clicks the Get Free Trial button.
     */
    public void callGetFreeTrial() {
        WebElement element = driver.findElement(getFreeTrialButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button is not displayed.");
    }

    /**
     * Clicks the Scale Agile Learn More button.
     * @return True if the button is displayed after clicking.
     */
    public boolean clickScaleAgileLearnMore() {
        WebElement element = driver.findElement(scaleAgileLearnMoreButton);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Scale Agile Learn More button is not displayed.");
        return isDisplayed;
    }

    /**
     * Clicks the Explorer Testing Learn More button.
     * @return True if the button is displayed after clicking.
     */
    public boolean clickExplorerTestingLearnMore() {
        WebElement element = driver.findElement(explorerTestingLearnMoreButton);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Explorer Testing Learn More button is not displayed.");
        return isDisplayed;
    }

    /**
     * Clicks the Distributed Team Learn More button.
     * @return True if the button is displayed after clicking.
     */
    public boolean clickDistributedTeamLearnMore() {
        WebElement element = driver.findElement(distributedTeamLearnMoreButton);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Distributed Team Learn More button is not displayed.");
        return isDisplayed;
    }

    /**
     * Clicks the Integration APIs Learn More button.
     * @return True if the button is displayed after clicking.
     */
    public boolean clickIntegrationApisLearnMore() {
        WebElement element = driver.findElement(integrationApisLearnMoreButton);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Integration APIs Learn More button is not displayed.");
        return isDisplayed;
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        driver.quit();
    }
}