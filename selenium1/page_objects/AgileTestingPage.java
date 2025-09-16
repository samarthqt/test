package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .util.concurrent.TimeUnit;

public class AgileTestingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    private final By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    private final By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    private final By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void enterUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL did not match the expected URL.");
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(agileTestingSubMenu));
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing SubMenu is not displayed.");
    }

    public void callGetFreeTrial() {
        // Implement the logic to call Get Free Trial
        // Assuming there's a method to click a button or link for free trial
        // Example: clickElement(getFreeTrialButton);
    }

    public boolean clickScaleAgileLearnMore() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(scaleAgileLearnMore));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Scale Agile Learn More is not displayed.");
        return isDisplayed;
    }

    public boolean clickExplorerTestingLearnMore() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(explorerTestingLearnMore));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Explorer Testing Learn More is not displayed.");
        return isDisplayed;
    }

    public boolean clickDistributedTeamLearnMore() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(distributedTeamLearnMore));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Distributed Team Learn More is not displayed.");
        return isDisplayed;
    }

    public boolean clickIntegrationAPIsLearnMore() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(integrationAPIsLearnMore));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Integration APIs Learn More is not displayed.");
        return isDisplayed;
    }

    public void closeBrowser() {
        driver.quit();
    }
}