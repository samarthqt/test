import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SeleniumTestAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://example.com");

            WebElement element = driver.findElement(By.id("elementID"));
            element.click();

            WebElement inputField = driver.findElement(By.name("inputName"));
            inputField.sendKeys("Test Input");

            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
            submitButton.click();

            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);
        } finally {
            driver.quit();
        }
    }
}