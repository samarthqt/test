import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class QASymphonyPage {
    private WebDriver driver;

    // Constructor
    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web elements
    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By scaleAgileLearnMoreButton = By.xpath("//section[@id='scale-agile']//a[contains(text(),'Learn More')]");
    private By explorerTestingLearnMoreButton = By.xpath("//section[@id='explorer-testing']//a[contains(text(),'Learn More')]");
    private By distributedTeamLearnMoreButton = By.xpath("//section[@id='distributed-team']//a[contains(text(),'Learn More')]");

    // Actions
    public void openURL(String url) {
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