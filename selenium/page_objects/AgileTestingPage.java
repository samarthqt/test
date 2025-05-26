import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QaSymphonyPage {
    private WebDriver driver;

    public QaSymphonyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void clickAgileTestingSubMenu() {
        WebElement agileTestingSubMenu = driver.findElement(By.linkText("Agile Testing"));
        agileTestingSubMenu.click();
    }

    public void callGetFreeTrial() {
        WebElement getFreeTrialButton = driver.findElement(By.linkText("Get Free Trial"));
        getFreeTrialButton.click();
    }

    public void clickScaleAgileLearnMore() {
        WebElement scaleAgileLearnMore = driver.findElement(By.linkText("Learn More"));
        scaleAgileLearnMore.click();
    }

    public void clickExplorerTestingLearnMore() {
        WebElement explorerTestingLearnMore = driver.findElement(By.linkText("Learn More"));
        explorerTestingLearnMore.click();
    }

    public void clickDistributedTeamLearnMore() {
        WebElement distributedTeamLearnMore = driver.findElement(By.linkText("Learn More"));
        distributedTeamLearnMore.click();
    }
}