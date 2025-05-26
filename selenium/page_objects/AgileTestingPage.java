import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class QASymphonyPage {
    private WebDriver driver;

    // Constructor
    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page URL
    private static final String PAGE_URL = "http://www.qasymphony.com/platform.html";

    // Locators
    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By scaleAgileLearnMoreButton = By.linkText("Learn More");
    private By explorerTestingLearnMoreButton = By.linkText("Learn More");
    private By distributedTeamLearnMoreButton = By.linkText("Learn More");

    // Methods
    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void clickAgileTestingSubMenu() {
        driver.findElement(agileTestingSubMenu).click();
    }

    public void clickGetFreeTrial() {
        driver.findElement(getFreeTrialButton).click();
    }

    public void clickScaleAgileLearnMore() {
        driver.findElement(scaleAgileLearnMoreButton).click();
    }

    public void clickExplorerTestingLearnMore() {
        driver.findElement(explorerTestingLearnMoreButton).click();
    }

    public void clickDistributedTeamLearnMore() {
        driver.findElement(distributedTeamLearnMoreButton).click();
    }
}