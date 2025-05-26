import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QASymphonyPage {

    private WebDriver driver;

    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to the URL
    public void navigateToPlatformPage() {
        driver.get("http://www.qasymphony.com/platform.html");
    }

    // Click on the Agile Testing sub-menu
    public void clickAgileTestingSubMenu() {
        WebElement agileTestingMenu = driver.findElement(By.linkText("Agile Testing"));
        agileTestingMenu.click();
    }

    // Call Get Free Trial
    public void callGetFreeTrial() {
        WebElement getFreeTrialButton = driver.findElement(By.linkText("Get Free Trial"));
        getFreeTrialButton.click();
    }

    // Click on Learn More button of Scale Agile section
    public void clickScaleAgileLearnMore() {
        WebElement scaleAgileLearnMoreButton = driver.findElement(By.linkText("Learn More"));
        scaleAgileLearnMoreButton.click();
    }

    // Click on Learn More button of eXplorer Testing section
    public void clickExplorerTestingLearnMore() {
        WebElement explorerTestingLearnMoreButton = driver.findElement(By.linkText("Learn More"));
        explorerTestingLearnMoreButton.click();
    }

    // Click on Learn More button of Distributed Team section
    public void clickDistributedTeamLearnMore() {
        WebElement distributedTeamLearnMoreButton = driver.findElement(By.linkText("Learn More"));
        distributedTeamLearnMoreButton.click();
    }
}