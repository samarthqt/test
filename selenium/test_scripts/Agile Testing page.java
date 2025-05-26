import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class QASymphonyTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("http://www.qasymphony.com/platform.html");

            Actions actions = new Actions(driver);
            WebElement agileTestingMenu = driver.findElement(By.linkText("Agile Testing"));
            actions.moveToElement(agileTestingMenu).perform();
            agileTestingMenu.click();

            WebElement getFreeTrialButton = driver.findElement(By.linkText("Get Free Trial"));
            getFreeTrialButton.click();

            WebElement scaleAgileLearnMore = driver.findElement(By.xpath("//section[contains(@class, 'scale-agile')]//a[contains(text(), 'Learn More')]"));
            scaleAgileLearnMore.click();

            WebElement explorerTestingLearnMore = driver.findElement(By.xpath("//section[contains(@class, 'explorer-testing')]//a[contains(text(), 'Learn More')]"));
            explorerTestingLearnMore.click();

            WebElement distributedTeamLearnMore = driver.findElement(By.xpath("//section[contains(@class, 'distributed-team')]//a[contains(text(), 'Learn More')]"));
            distributedTeamLearnMore.click();
            
        } finally {
            driver.quit();
        }
    }
}