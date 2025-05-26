import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QASymphonyPlatformPage {
    
    WebDriver driver;
    
    @FindBy(linkText = "Agile Testing")
    private WebElement agileTestingSubMenu;
    
    @FindBy(linkText = "Get Free Trial")
    private WebElement getFreeTrialButton;
    
    @FindBy(xpath = "//section[@id='scale-agile']//a[contains(text(),'Learn More')]")
    private WebElement scaleAgileLearnMoreButton;
    
    @FindBy(xpath = "//section[@id='explorer-testing']//a[contains(text(),'Learn More')]")
    private WebElement explorerTestingLearnMoreButton;
    
    @FindBy(xpath = "//section[@id='distributed-team']//a[contains(text(),'Learn More')]")
    private WebElement distributedTeamLearnMoreButton;
    
    public QASymphonyPlatformPage(WebDriver driver) {
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