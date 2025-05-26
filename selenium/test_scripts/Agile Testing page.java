// Main Test Script
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QASymphonyTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("http://www.qasymphony.com/platform.html");
            QASymphonyPage qaSymphonyPage = new QASymphonyPage(driver);
            
            qaSymphonyPage.clickAgileTestingSubMenu();
            qaSymphonyPage.clickGetFreeTrial();
            qaSymphonyPage.clickLearnMoreScaleAgile();
            qaSymphonyPage.clickLearnMoreExplorerTesting();
            qaSymphonyPage.clickLearnMoreDistributedTeam();
        } finally {
            driver.quit();
        }
    }
}

// Page Object Model (POM) File
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QASymphonyPage {
    private WebDriver driver;

    private By agileTestingSubMenu = By.linkText("Agile Testing");
    private By getFreeTrialButton = By.linkText("Get Free Trial");
    private By learnMoreScaleAgileButton = By.xpath("//section[contains(@id,'scale-agile')]//a[contains(text(),'Learn More')]");
    private By learnMoreExplorerTestingButton = By.xpath("//section[contains(@id,'explorer-testing')]//a[contains(text(),'Learn More')]");
    private By learnMoreDistributedTeamButton = By.xpath("//section[contains(@id,'distributed-team')]//a[contains(text(),'Learn More')]");

    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
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