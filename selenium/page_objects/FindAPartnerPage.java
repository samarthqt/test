import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnersPage {
    WebDriver driver;

    // Constructor
    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for "Find a Partner" button
    By findPartnerButton = By.xpath("//button[text()='Find a Partner']");

    // Method to open the URL
    public void openPage() {
        driver.get("http://www.qasymphony.com/partners.html");
    }

    // Method to click on "Find a Partner" button
    public void clickFindPartner() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}