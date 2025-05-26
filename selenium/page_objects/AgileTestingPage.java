import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class QASymphonyPage {

    WebDriver driver;

    // Constructor
    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By agileTestingSubMenu = By.linkText("Agile Testing");
    By getFreeTrialButton = By.linkText("Get Free Trial");
    By scaleAgileLearnMoreButton = By.linkText("Learn More");
    By explorerTestingLearnMoreButton = By.linkText("Learn More");
    By distributedTeamLearnMoreButton = By.linkText("Learn More");

    // Methods
    public void openPage(String url) {
        driver.get(url);
    }

    public void clickAgileTestingSubMenu() {
        driver.findElement(agileTestingSubMenu).click();
    }

    public void clickGetFreeTrial() {
        driver.findElement(getFreeTrialButton).click();
    }

    public void clickScaleAgileLearnMore() {
        driver.findElements(scaleAgileLearnMoreButton).get(0).click();
    }

    public void clickExplorerTestingLearnMore() {
        driver.findElements(explorerTestingLearnMoreButton).get(1).click();
    }

    public void clickDistributedTeamLearnMore() {
        driver.findElements(distributedTeamLearnMoreButton).get(2).click();
    }
}