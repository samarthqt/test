package selenium1.page_objects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AgileTestingPage extends WebReusableComponents {

    protected WebDriver driver;

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrial");
    protected By scaleAgileSection = By.id("scaleAgileSection");
    protected By scaleAgileLearnMoreButton = By.id("scaleAgileLearnMore");
    protected By explorerTestingSection = By.id("explorerTestingSection");
    protected By explorerTestingLearnMoreButton = By.id("explorerTestingLearnMore");
    protected By distributedTeamSection = By.id("distributedTeamSection");
    protected By distributedTeamLearnMoreButton = By.id("distributedTeamLearnMore");
    protected By integrationAPIsSection = By.id("integrationAPIsSection");
    protected By integrationAPIsLearnMoreButton = By.id("integrationAPIsLearnMore");

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
        element.click();
    }

    public void clickGetFreeTrial() {
        WebElement element = driver.findElement(getFreeTrialButton);
        element.click();
    }

    public boolean isScaleAgileSectionVisible() {
        WebElement element = driver.findElement(scaleAgileSection);
        boolean isVisible = element.isDisplayed();
        Assert.assertTrue(isVisible, "Scale Agile section is not visible.");
        return isVisible;
    }

    public void clickScaleAgileLearnMore() {
        WebElement element = driver.findElement(scaleAgileLearnMoreButton);
        element.click();
    }

    public boolean isExplorerTestingSectionVisible() {
        WebElement element = driver.findElement(explorerTestingSection);
        boolean isVisible = element.isDisplayed();
        Assert.assertTrue(isVisible, "Explorer Testing section is not visible.");
        return isVisible;
    }

    public void clickExplorerTestingLearnMore() {
        WebElement element = driver.findElement(explorerTestingLearnMoreButton);
        element.click();
    }

    public boolean isDistributedTeamSectionVisible() {
        WebElement element = driver.findElement(distributedTeamSection);
        boolean isVisible = element.isDisplayed();
        Assert.assertTrue(isVisible, "Distributed Team section is not visible.");
        return isVisible;
    }

    public void clickDistributedTeamLearnMore() {
        WebElement element = driver.findElement(distributedTeamLearnMoreButton);
        element.click();
    }

    public boolean isIntegrationAPIsSectionVisible() {
        WebElement element = driver.findElement(integrationAPIsSection);
        boolean isVisible = element.isDisplayed();
        Assert.assertTrue(isVisible, "Integration APIs section is not visible.");
        return isVisible;
    }

    public void clickIntegrationAPIsLearnMore() {
        WebElement element = driver.findElement(integrationAPIsLearnMoreButton);
        element.click();
    }

    public void closeBrowser() {
        driver.quit();
    }
}