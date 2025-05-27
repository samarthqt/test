import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QASymphonyPlatformPage {

    WebDriver driver;

    By agileTestingSubMenu = By.linkText("Agile Testing");
    By getFreeTrialButton = By.linkText("Get Free Trial");
    By scaleAgileLearnMoreButton = By.xpath("//section[contains(@class, 'scale-agile')]//a[contains(text(),'Learn More')]");
    By explorerTestingLearnMoreButton = By.xpath("//section[contains(@class, 'explorer-testing')]//a[contains(text(),'Learn More')]");
    By distributedTeamLearnMoreButton = By.xpath("//section[contains(@class, 'distributed-team')]//a[contains(text(),'Learn More')]");

    public QASymphonyPlatformPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("http://www.qasymphony.com/platform.html");
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