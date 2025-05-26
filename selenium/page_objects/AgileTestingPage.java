import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QASymphonyPlatformPage {

    WebDriver driver;

    @FindBy(xpath = "//a[text()='Agile Testing']")
    private WebElement agileTestingSubMenu;

    @FindBy(xpath = "//a[text()='Get Free Trial']")
    private WebElement getFreeTrialButton;

    @FindBy(xpath = "//section[@id='scale-agile']//a[text()='Learn More']")
    private WebElement scaleAgileLearnMoreButton;

    @FindBy(xpath = "//section[@id='explorer-testing']//a[text()='Learn More']")
    private WebElement explorerTestingLearnMoreButton;

    @FindBy(xpath = "//section[@id='distributed-team']//a[text()='Learn More']")
    private WebElement distributedTeamLearnMoreButton;

    public QASymphonyPlatformPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPlatformPage() {
        driver.get("http://www.qasymphony.com/platform.html");
    }

    public void clickAgileTestingSubMenu() {
        agileTestingSubMenu.click();
    }

    public void clickGetFreeTrial() {
        getFreeTrialButton.click();
    }

    public void clickScaleAgileLearnMore() {
        scaleAgileLearnMoreButton.click();
    }

    public void clickExplorerTestingLearnMore() {
        explorerTestingLearnMoreButton.click();
    }

    public void clickDistributedTeamLearnMore() {
        distributedTeamLearnMoreButton.click();
    }
}