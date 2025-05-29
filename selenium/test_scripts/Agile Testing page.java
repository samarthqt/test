import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserAutomation {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://www.qasymphony.com/platform.html");

        WebElement agileTestingMenu = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Agile Testing")));
        agileTestingMenu.click();

        WebElement getFreeTrialButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Get Free Trial")));
        getFreeTrialButton.click();

        WebElement scaleAgileLearnMore = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Learn More")));
        scaleAgileLearnMore.click();

        WebElement explorerTestingLearnMore = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Learn More")));
        explorerTestingLearnMore.click();

        WebElement distributedTeamLearnMore = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Learn More")));
        distributedTeamLearnMore.click();

        WebElement integrationAPIsLearnMore = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Learn More")));
        integrationAPIsLearnMore.click();

        driver.quit();
    }
}