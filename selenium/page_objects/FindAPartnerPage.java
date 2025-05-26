import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnerPage {
    private WebDriver driver;

    // Constructor
    public PartnerPage(WebDriver driver) {
        this.driver = driver;
    }

    // URL
    private String url = "http://www.qasymphony.com/partners.html";

    // Locators
    private By findPartnerButton = By.id("find-partner-button"); // Replace with actual locator

    // Actions
    public void open() {
        driver.get(url);
    }

    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}