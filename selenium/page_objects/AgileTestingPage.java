import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlatformPage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Agile Testing']")
    WebElement agileTestingMenu;

    @FindBy(xpath = "//a[contains(text(),'Get Free Trial')]")
    WebElement getFreeTrialButton;

    @FindBy(xpath = "//section[@id='scale-agile']//a[contains(text(),'Learn More')]")
    WebElement scaleAgileLearnMoreButton;

    @FindBy(xpath = "//section[@id='explorer-testing']//a[contains(text(),'Learn More')]")
    WebElement explorerTestingLearnMoreButton;

    @FindBy(xpath = "//section[@id='distributed-team']//a[contains(text(),'Learn More')]")
    WebElement distributedTeamLearnMoreButton;

    public PlatformPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void clickAgileTestingMenu() {
        agileTestingMenu.click();
    }

    public void callGetFreeTrial() {
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