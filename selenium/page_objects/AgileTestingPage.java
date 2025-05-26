import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QASymphonyPlatformPage {

    WebDriver driver;

    By agileTestingSubMenu = By.linkText("Agile Testing");
    By getFreeTrialButton = By.linkText("Get Free Trial");
    By scaleAgileLearnMoreButton = By.xpath("//section[@id='scale-agile']//a[text()='Learn More']");
    By explorerTestingLearnMoreButton = By.xpath("//section[@id='explorer-testing']//a[text()='Learn More']");
    By distributedTeamLearnMoreButton = By.xpath("//section[@id='distributed-team']//a[text()='Learn More']");

    public QASymphonyPlatformPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPlatformPage(String url) {
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

    public void clickExplorerTestingLearnMore() {
        driver.findElement(explorerTestingLearnMoreButton).click();
    }

    public void clickDistributedTeamLearnMore() {
        driver.findElement(distributedTeamLearnMoreButton).click();
    }
}