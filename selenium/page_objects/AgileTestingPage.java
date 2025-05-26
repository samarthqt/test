import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QASymphonyPlatformPage {
    private WebDriver driver;

    // Constructor
    public QASymphonyPlatformPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By scaleAgileLearnMoreButton = By.linkText("Learn More");
    private By eXplorerTestingLearnMoreButton = By.linkText("Learn More");
    private By distributedTeamLearnMoreButton = By.linkText("Learn More");

    // Methods
    public void open(String url) {
        driver.get(url);
    }

    public void clickAgileTestingSubMenu() {
        driver.findElement(agileTestingSubMenu).click();
    }

    public void callGetFreeTrial() {
        driver.findElement(getFreeTrialButton).click();
    }

    public void clickScaleAgileLearnMore() {
        driver.findElement(scaleAgileLearnMoreButton).click();
    }

    public void clickEXplorerTestingLearnMore() {
        driver.findElement(eXplorerTestingLearnMoreButton).click();
    }

    public void clickDistributedTeamLearnMore() {
        driver.findElement(distributedTeamLearnMoreButton).click();
    }
}