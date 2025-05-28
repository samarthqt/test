import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class QASymphonyAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://www.qasymphony.com/platform.html");

            Actions actions = new Actions(driver);
            WebElement agileTestingMenu = driver.findElement(By.xpath("//a[text()='Agile Testing']"));
            actions.moveToElement(agileTestingMenu).click().perform();

            WebElement getFreeTrialButton = driver.findElement(By.xpath("//a[contains(text(),'Get Free Trial')]"));
            getFreeTrialButton.click();

            WebElement scaleAgileLearnMore = driver.findElement(By.xpath("//a[contains(@href, 'scale-agile') and contains(text(), 'Learn More')]"));
            scaleAgileLearnMore.click();

            driver.navigate().back();

            WebElement explorerTestingLearnMore = driver.findElement(By.xpath("//a[contains(@href, 'explorer-testing') and contains(text(), 'Learn More')]"));
            explorerTestingLearnMore.click();

            driver.navigate().back();

            WebElement distributedTeamLearnMore = driver.findElement(By.xpath("//a[contains(@href, 'distributed-team') and contains(text(), 'Learn More')]"));
            distributedTeamLearnMore.click();

        } finally {
            driver.quit();
        }
    }
}