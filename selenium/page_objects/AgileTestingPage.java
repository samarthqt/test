import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class QASymphonyPage {
    private WebDriver driver;

    // Constructor
    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page URL
    private String pageUrl = "http://www.qasymphony.com/platform.html";

    // Locators
    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By learnMoreScaleAgileButton = By.xpath("//div[@id='scale-agile']//a[contains(text(),'Learn More')]");
    private By learnMoreExplorerTestingButton = By.xpath("//div[@id='explorer-testing']//a[contains(text(),'Learn More')]");
    private By learnMoreDistributedTeamButton = By.xpath("//div[@id='distributed-team']//a[contains(text(),'Learn More')]");

    // Methods
    public void openPage() {
        driver.get(pageUrl);
    }

    public void clickAgileTestingSubMenu() {
        driver.findElement(agileTestingSubMenu).click();
    }

    public void clickGetFreeTrial() {
        driver.findElement(getFreeTrialButton).click();
    }

    public void clickLearnMoreScaleAgile() {
        driver.findElement(learnMoreScaleAgileButton).click();
    }

    public void clickLearnMoreExplorerTesting() {
        driver.findElement(learnMoreExplorerTestingButton).click();
    }

    public void clickLearnMoreDistributedTeam() {
        driver.findElement(learnMoreDistributedTeamButton).click();
    }
}