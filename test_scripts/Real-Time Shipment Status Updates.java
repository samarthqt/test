import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UniqueTestAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://example.com");

            WebElement element = driver.findElement(By.id("element-id"));
            element.click();
            
            String expectedResult = "Expected Result";
            String actualResult = driver.findElement(By.id("result-id")).getText();
            
            if (actualResult.equals(expectedResult)) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
        } finally {
            driver.quit();
        }
    }
}