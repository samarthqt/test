package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrial");
    protected By learnMoreScaleAgile = By.id("learnMoreScaleAgile");
    protected By learnMoreExplorerTesting = By.id("learnMoreExplorerTesting");
    protected By learnMoreDistributedTeam = By.id("learnMoreDistributedTeam");
    protected By learnMoreIntegrationAPIs = By.id("learnMoreIntegrationAPIs");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void navigateToPlatformPage() {
        driver.get("http://www.qasymphony.com/platform.html");
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = driver.findElement(agileTestingSubMenu);
        waitUntilElementVisible(element, 3);
        element.click();
    }

    public void clickGetFreeTrial() {
        WebElement element = driver.findElement(getFreeTrialButton);
        waitUntilElementVisible(element, 3);
        element.click();
    }

    public void clickLearnMoreScaleAgile() {
        WebElement element = driver.findElement(learnMoreScaleAgile);
        waitUntilElementVisible(element, 3);
        element.click();
    }

    public void clickLearnMoreExplorerTesting() {
        WebElement element = driver.findElement(learnMoreExplorerTesting);
        waitUntilElementVisible(element, 3);
        element.click();
    }

    public void clickLearnMoreDistributedTeam() {
        WebElement element = driver.findElement(learnMoreDistributedTeam);
        waitUntilElementVisible(element, 3);
        element.click();
    }

    public void clickLearnMoreIntegrationAPIs() {
        WebElement element = driver.findElement(learnMoreIntegrationAPIs);
        waitUntilElementVisible(element, 3);
        element.click();
    }

    public boolean isAgileTestingPageLoaded() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Agile Testing"), "Page title does not contain 'Agile Testing'");
        return true;
    }

    public void closeBrowser() {
        driver.quit();
    }

    private void waitUntilElementVisible(WebElement element, int timeoutInSeconds) {
        // Implement explicit wait logic here
    }
}