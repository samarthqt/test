import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QASymphonyPage {
    private WebDriver driver;

    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("http://www.qasymphony.com/platform.html");
    }

    public void clickAgileTestingSubMenu() {
        WebElement agileTestingSubMenu = driver.findElement(By.xpath("//a[contains(text(), 'Agile Testing')]"));
        agileTestingSubMenu.click();
    }

    public void clickGetFreeTrial() {
        WebElement getFreeTrialButton = driver.findElement(By.xpath("//a[contains(text(), 'Get Free Trial')]"));
        getFreeTrialButton.click();
    }

    public void clickLearnMoreScaleAgile() {
        WebElement learnMoreScaleAgileButton = driver.findElement(By.xpath("//section[contains(@id, 'scale-agile')]//a[contains(text(), 'Learn More')]"));
        learnMoreScaleAgileButton.click();
    }

    public void clickLearnMoreExplorerTesting() {
        WebElement learnMoreExplorerTestingButton = driver.findElement(By.xpath("//section[contains(@id, 'explorer-testing')]//a[contains(text(), 'Learn More')]"));
        learnMoreExplorerTestingButton.click();
    }

    public void clickLearnMoreDistributedTeam() {
        WebElement learnMoreDistributedTeamButton = driver.findElement(By.xpath("//section[contains(@id, 'distributed-team')]//a[contains(text(), 'Learn More')]"));
        learnMoreDistributedTeamButton.click();
    }
}