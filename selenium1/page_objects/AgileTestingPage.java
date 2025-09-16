package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AgileTestingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By getFreeTrialButton = By.id("getFreeTrial");
    private final By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    private final By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    private final By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    private final By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        // Logic to open browser
        Assert.assertNotNull(driver, "Driver should be initialized");
    }

    public void enterUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL did not match");
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(agileTestingSubMenu));
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing SubMenu is not displayed");
    }

    public void callGetFreeTrial() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getFreeTrialButton));
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button is not displayed");
    }

    public void clickScaleAgileLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(scaleAgileLearnMore));
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Scale Agile Learn More is not displayed");
    }

    public void clickExplorerTestingLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(explorerTestingLearnMore));
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Explorer Testing Learn More is not displayed");
    }

    public void clickDistributedTeamLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(distributedTeamLearnMore));
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Distributed Team Learn More is not displayed");
    }

    public void clickIntegrationAPIsLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(integrationAPIsLearnMore));
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Integration APIs Learn More is not displayed");
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Driver should be null after quitting");
    }
}