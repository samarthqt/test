import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://www.qasymphony.com/partners.html");
        
        WebElement findPartnerButton = driver.findElement(By.xpath("//a[text()='Find a Partner']"));
        findPartnerButton.click();
        
        driver.quit();
    }
}