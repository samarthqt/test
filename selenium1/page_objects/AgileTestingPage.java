package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrial");
    protected By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    protected By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(new ChromeDriver(), this);
    }

    public void openBrowser() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Assert.assertNotNull(driver, "Browser did not open successfully");
    }

    public void navigateToPlatformPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.qasymphony.com/platform.html");
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.qasymphony.com/platform.html", "Navigation to platform page failed");
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = driver.findElement(agileTestingSubMenu);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing SubMenu is not displayed after click");
    }

    public void callGetFreeTrial() {
        WebElement element = driver.findElement(getFreeTrialButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button is not displayed after click");
    }

    public boolean clickScaleAgileLearnMore() {
        WebElement element = driver.findElement(scaleAgileLearnMore);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Scale Agile Learn More is not displayed after click");
        return isDisplayed;
    }

    public boolean clickExplorerTestingLearnMore() {
        WebElement element = driver.findElement(explorerTestingLearnMore);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Explorer Testing Learn More is not displayed after click");
        return isDisplayed;
    }

    public boolean clickDistributedTeamLearnMore() {
        WebElement element = driver.findElement(distributedTeamLearnMore);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Distributed Team Learn More is not displayed after click");
        return isDisplayed;
    }

    public boolean clickIntegrationAPIsLearnMore() {
        WebElement element = driver.findElement(integrationAPIsLearnMore);
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Integration APIs Learn More is not displayed after click");
        return isDisplayed;
    }

    public void closeBrowser() {
        WebDriver driver = new ChromeDriver();
        driver.quit();
        Assert.assertNull(driver, "Browser did not close successfully");
    }
}