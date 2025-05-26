import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class PartnerPage {

    private WebDriver driver;
    
    // Locator for "Find a Partner" button
    private By findPartnerButton = By.id("find-partner-button-id"); // Replace with actual ID or locator

    // Constructor
    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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