import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QASymphonyPage {

    WebDriver driver;

    @FindBy(linkText = "Agile Testing")
    private WebElement agileTestingSubMenu;

    @FindBy(linkText = "Get Free Trial")
    private WebElement getFreeTrialButton;

    @FindBy(xpath = "//section[contains(@class, 'scale-agile')]//a[contains(text(), 'Learn More')]")
    private WebElement scaleAgileLearnMoreButton;

    @FindBy(xpath = "//section[contains(@class, 'explorer-testing')]//a[contains(text(), 'Learn More')]")
    private WebElement explorerTestingLearnMoreButton;

    @FindBy(xpath = "//section[contains(@class, 'distributed-team')]//a[contains(text(), 'Learn More')]")
    private WebElement distributedTeamLearnMoreButton;

    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAgileTestingSubMenu() {
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