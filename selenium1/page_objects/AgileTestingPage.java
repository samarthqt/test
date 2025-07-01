package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    private WebDriver driver;

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By getFreeTrialButton = By.id("getFreeTrial");
    private final By scaleAgileSection = By.id("scaleAgileSection");
    private final By learnMoreScaleAgile = By.id("learnMoreScaleAgile");
    private final By explorerTestingSection = By.id("explorerTestingSection");
    private final By learnMoreExplorerTesting = By.id("learnMoreExplorerTesting");
    private final By distributedTeamSection = By.id("distributedTeamSection");
    private final By learnMoreDistributedTeam = By.id("learnMoreDistributedTeam");
    private final By integrationAPIsSection = By.id("integrationAPIsSection");
    private final By learnMoreIntegrationAPIs = By.id("learnMoreIntegrationAPIs");

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
        Assert.assertTrue(isVisible, "Scale Agile section is not visible");
        return isVisible;
    }

    public void clickLearnMoreScaleAgile() {
        WebElement element = driver.findElement(learnMoreScaleAgile);
        element.click();
    }

    public boolean isExplorerTestingSectionVisible() {
        WebElement element = driver.findElement(explorerTestingSection);
        boolean isVisible = element.isDisplayed();
        Assert.assertTrue(isVisible, "Explorer Testing section is not visible");
        return isVisible;
    }

    public void clickLearnMoreExplorerTesting() {
        WebElement element = driver.findElement(learnMoreExplorerTesting);
        element.click();
    }

    public boolean isDistributedTeamSectionVisible() {
        WebElement element = driver.findElement(distributedTeamSection);
        boolean isVisible = element.isDisplayed();
        Assert.assertTrue(isVisible, "Distributed Team section is not visible");
        return isVisible;
    }

    public void clickLearnMoreDistributedTeam() {
        WebElement element = driver.findElement(learnMoreDistributedTeam);
        element.click();
    }

    public boolean isIntegrationAPIsSectionVisible() {
        WebElement element = driver.findElement(integrationAPIsSection);
        boolean isVisible = element.isDisplayed();
        Assert.assertTrue(isVisible, "Integration APIs section is not visible");
        return isVisible;
    }

    public void clickLearnMoreIntegrationAPIs() {
        WebElement element = driver.findElement(learnMoreIntegrationAPIs);
        element.click();
    }

    public void closeBrowser() {
        driver.quit();
    }
}