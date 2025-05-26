import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QASymphonyPage {

    private WebDriver driver;

    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
    }

    // URL
    private String url = "http://www.qasymphony.com/platform.html";

    // Locators
    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By scaleAgileLearnMoreButton = By.xpath("//section[@id='scale-agile']//a[contains(text(),'Learn More')]");
    private By explorerTestingLearnMoreButton = By.xpath("//section[@id='explorer-testing']//a[contains(text(),'Learn More')]");
    private By distributedTeamLearnMoreButton = By.xpath("//section[@id='distributed-team']//a[contains(text(),'Learn More')]");

    // Actions
    public void openPage() {
        driver.get(url);
    }

    public void clickAgileTestingSubMenu() {
        WebElement agileTestingElement = driver.findElement(agileTestingSubMenu);
        agileTestingElement.click();
    }

    public void clickGetFreeTrial() {
        WebElement getFreeTrialElement = driver.findElement(getFreeTrialButton);
        getFreeTrialElement.click();
    }

    public void clickScaleAgileLearnMore() {
        WebElement scaleAgileElement = driver.findElement(scaleAgileLearnMoreButton);
        scaleAgileElement.click();
    }

    public void clickExplorerTestingLearnMore() {
        WebElement explorerTestingElement = driver.findElement(explorerTestingLearnMoreButton);
        explorerTestingElement.click();
    }

    public void clickDistributedTeamLearnMore() {
        WebElement distributedTeamElement = driver.findElement(distributedTeamLearnMoreButton);
        distributedTeamElement.click();
    }
}