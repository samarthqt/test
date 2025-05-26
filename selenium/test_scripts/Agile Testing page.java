import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class QASymphonyTest {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the browser and navigate to the URL
            driver.get("http://www.qasymphony.com/platform.html");

            // Locate the Agile Testing sub-menu and click on it
            WebElement agileTestingMenu = driver.findElement(By.linkText("Agile Testing"));
            agileTestingMenu.click();

            // Locate and click on Get Free Trial
            WebElement getFreeTrialButton = driver.findElement(By.linkText("Get Free Trial"));
            getFreeTrialButton.click();

            // Locate and click on Learn More button of Scale Agile section
            WebElement scaleAgileLearnMore = driver.findElement(By.xpath("//section[contains(@class, 'scale-agile')]//a[contains(text(), 'Learn More')]"));
            scaleAgileLearnMore.click();

            // Locate and click on Learn More button of eXplorer Testing section
            WebElement explorerTestingLearnMore = driver.findElement(By.xpath("//section[contains(@class, 'explorer-testing')]//a[contains(text(), 'Learn More')]"));
            explorerTestingLearnMore.click();

            // Locate and click on Learn More button of Distributed Team section
            WebElement distributedTeamLearnMore = driver.findElement(By.xpath("//section[contains(@class, 'distributed-team')]//a[contains(text(), 'Learn More')]"));
            distributedTeamLearnMore.click();

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}