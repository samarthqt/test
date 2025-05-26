import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class QASymphonyPage {
    private WebDriver driver;

    // URL
    private String pageUrl = "http://www.qasymphony.com/platform.html";

    // Locators
    private By agileTestingMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By scaleAgileLearnMoreButton = By.xpath("//section[@id='scale-agile']//a[contains(text(),'Learn More')]");
    private By explorerTestingLearnMoreButton = By.xpath("//section[@id='explorer-testing']//a[contains(text(),'Learn More')]");
    private By distributedTeamLearnMoreButton = By.xpath("//section[@id='distributed-team']//a[contains(text(),'Learn More')]");

    // Constructor
    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void openPage() {
        driver.get(pageUrl);
    }

    public void clickAgileTestingMenu() {
        driver.findElement(agileTestingMenu).click();
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