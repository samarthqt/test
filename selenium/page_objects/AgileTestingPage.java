import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QASymphonyPlatformPage {

    private WebDriver driver;

    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By scaleAgileLearnMoreButton = By.linkText("Learn More");
    private By explorerTestingLearnMoreButton = By.linkText("Learn More");
    private By distributedTeamLearnMoreButton = By.linkText("Learn More");

    public QASymphonyPlatformPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://www.qasymphony.com/platform.html");
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