```java
// Page Object Model file: PlatformPage.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlatformPage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Agile Testing']")
    private WebElement agileTestingSubMenu;

    @FindBy(xpath = "//a[text()='Get Free Trial']")
    private WebElement getFreeTrialButton;

    @FindBy(xpath = "//div[@id='scale-agile']//a[contains(text(),'Learn More')]")
    private WebElement scaleAgileLearnMoreButton;

    @FindBy(xpath = "//div[@id='explorer-testing']//a[contains(text(),'Learn More')]")
    private WebElement explorerTestingLearnMoreButton;

    @FindBy(xpath = "//div[@id='distributed-team']//a[contains(text(),'Learn More')]")
    private WebElement distributedTeamLearnMoreButton;

    public PlatformPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

// Selenium test script: TestPlatformPage.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestPlatformPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://www.qasymphony.com/platform.html");

        PlatformPage platformPage = new PlatformPage(driver);
        platformPage.clickAgileTestingSubMenu();
        platformPage.clickGetFreeTrial();
        platformPage.clickScaleAgileLearnMore();
        platformPage.clickExplorerTestingLearnMore();
        platformPage.clickDistributedTeamLearnMore();

        driver.quit();
    }
}
```