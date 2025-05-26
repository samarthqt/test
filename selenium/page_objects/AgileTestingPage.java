import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QASymphonyPage {

    WebDriver driver;

    @FindBy(linkText = "Agile Testing")
    WebElement agileTestingSubMenu;

    @FindBy(linkText = "Get Free Trial")
    WebElement getFreeTrialButton;

    @FindBy(css = "section.scale-agile .learn-more")
    WebElement scaleAgileLearnMoreButton;

    @FindBy(css = "section.explorer-testing .learn-more")
    WebElement explorerTestingLearnMoreButton;

    @FindBy(css = "section.distributed-team .learn-more")
    WebElement distributedTeamLearnMoreButton;

    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openUrl(String url) {
        driver.get(url);
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