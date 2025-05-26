import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class QASymphonyAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Open new browser window and enter URL
            driver.get("http://www.qasymphony.com/platform.html");

            // Click on the "Agile Testing" sub-menu
            WebElement agileTestingMenu = driver.findElement(By.linkText("Agile Testing"));
            agileTestingMenu.click();

            // Call Get Free Trial
            WebElement getFreeTrialButton = driver.findElement(By.linkText("Get Free Trial"));
            getFreeTrialButton.click();

            // Click on the Learn More button of Scale Agile section
            WebElement scaleAgileLearnMore = driver.findElement(By.xpath("//a[contains(text(), 'Learn More') and contains(@href, 'scale-agile')]"));
            scaleAgileLearnMore.click();

            // Click on the Learn More button of eXplorer Testing section
            WebElement explorerTestingLearnMore = driver.findElement(By.xpath("//a[contains(text(), 'Learn More') and contains(@href, 'explorer-testing')]"));
            explorerTestingLearnMore.click();

            // Click on the Learn More button of Distributed Team section
            WebElement distributedTeamLearnMore = driver.findElement(By.xpath("//a[contains(text(), 'Learn More') and contains(@href, 'distributed-team')]"));
            distributedTeamLearnMore.click();

        } finally {
            driver.quit();
        }
    }
}