
package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By getFreeTrialButton = By.id("getFreeTrial");
    private final By scaleAgileLearnMoreButton = By.id("scaleAgileLearnMore");
    private final By explorerTestingLearnMoreButton = By.id("explorerTestingLearnMore");
    private final By distributedTeamLearnMoreButton = By.id("distributedTeamLearnMore");
    private final By integrationAPIsLearnMoreButton = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void enterUrl(String url) {
        driver.get(url);
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(agileTestingSubMenu));
        element.click();
    }

    public void callGetFreeTrial() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getFreeTrialButton));
        element.click();
    }

    public boolean clickScaleAgileLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(scaleAgileLearnMoreButton));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Scale Agile Learn More button is not displayed.");
        return isDisplayed;
    }

    public boolean clickExplorerTestingLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(explorerTestingLearnMoreButton));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Explorer Testing Learn More button is not displayed.");
        return isDisplayed;
    }

    public boolean clickDistributedTeamLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(distributedTeamLearnMoreButton));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Distributed Team Learn More button is not displayed.");
        return isDisplayed;
    }

    public boolean clickIntegrationAPIsLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(integrationAPIsLearnMoreButton));
        element.click();
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Integration APIs Learn More button is not displayed.");
        return isDisplayed;
    }

    public void closeBrowser() {
        driver.quit();
    }
}
