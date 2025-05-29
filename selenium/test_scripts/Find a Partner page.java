import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class PartnerPageAutomation {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            driver.get("http://www.qasymphony.com/partners.html");

            WebElement findPartnerButton = driver.findElement(By.id("findPartnerButtonId"));
            findPartnerButton.click();

        } finally {
            driver.quit();
        }
    }
}