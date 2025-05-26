import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class QASymphonyPage {
    private WebDriver driver;

    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    private By agileTestingMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By scaleAgileLearnMore = By.xpath("//section[@id='scale-agile']//a[contains(text(), 'Learn More')]");
    private By explorerTestingLearnMore = By.xpath("//section[@id='explorer-testing']//a[contains(text(), 'Learn More')]");
    private By distributedTeamLearnMore = By.xpath("//section[@id='distributed-team']//a[contains(text(), 'Learn More')]");

    // Actions
    public void openURL(String url) {
        driver.get(url);
    }

    public void clickAgileTestingMenu() {
        driver.findElement(agileTestingMenu).click();
    }

    public void clickGetFreeTrial() {
        driver.findElement(getFreeTrialButton).click();
    }

    public void clickScaleAgileLearnMore() {
        driver.findElement(scaleAgileLearnMore).click();
    }

    public void clickExplorerTestingLearnMore() {
        driver.findElement(explorerTestingLearnMore).click();
    }

    public void clickDistributedTeamLearnMore() {
        driver.findElement(distributedTeamLearnMore).click();
    }
}