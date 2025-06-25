package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AgileTestingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private By getFreeTrialButton = By.id("getFreeTrial");
    private By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    private By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    private By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    private By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
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
     * Clicks on the Agile Testing submenu.
     */
    public void clickAgileTestingSubMenu() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(agileTestingSubMenu));
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing submenu is not displayed.");
    }

    /**
     * Clicks the 'Get Free Trial' button.
     */
    public void callGetFreeTrial() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getFreeTrialButton));
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button is not displayed.");
    }

    /**
     * Clicks the 'Scale Agile Learn More' button and verifies its visibility.
     * @return True if the element is displayed after clicking.
     */
    public boolean clickScaleAgileLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(scaleAgileLearnMore));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Scale Agile Learn More is not displayed.");
        return isDisplayed;
    }

    /**
     * Clicks the 'Explorer Testing Learn More' button and verifies its visibility.
     * @return True if the element is displayed after clicking.
     */
    public boolean clickExplorerTestingLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(explorerTestingLearnMore));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Explorer Testing Learn More is not displayed.");
        return isDisplayed;
    }

    /**
     * Clicks the 'Distributed Team Learn More' button and verifies its visibility.
     * @return True if the element is displayed after clicking.
     */
    public boolean clickDistributedTeamLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(distributedTeamLearnMore));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Distributed Team Learn More is not displayed.");
        return isDisplayed;
    }

    /**
     * Clicks the 'Integration APIs Learn More' button and verifies its visibility.
     * @return True if the element is displayed after clicking.
     */
    public boolean clickIntegrationAPIsLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(integrationAPIsLearnMore));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Integration APIs Learn More is not displayed.");
        return isDisplayed;
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        driver.quit();
    }
}