import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindPartnerTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://www.qasymphony.com/partners.html");
            WebElement findPartnerButton = driver.findElement(By.linkText("Find a Partner"));
            findPartnerButton.click();
        } finally {
            driver.quit();
        }
    }
}