import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://www.qasymphony.com/platform.html");

            WebElement agileTestingMenu = driver.findElement(By.linkText("Agile Testing"));
            agileTestingMenu.click();

            WebElement getFreeTrial = driver.findElement(By.linkText("Get Free Trial"));
            getFreeTrial.click();

            WebElement learnMoreScaleAgile = driver.findElement(By.linkText("Learn More"));
            learnMoreScaleAgile.click();

            WebElement learnMoreExplorerTesting = driver.findElement(By.linkText("Learn More"));
            learnMoreExplorerTesting.click();

            WebElement learnMoreDistributedTeam = driver.findElement(By.linkText("Learn More"));
            learnMoreDistributedTeam.click();
        } finally {
            driver.quit();
        }
    }
}