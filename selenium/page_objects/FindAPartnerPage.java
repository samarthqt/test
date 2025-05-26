import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnersPage {

    private WebDriver driver;

    // Constructor
    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page URL
    private static final String PAGE_URL = "http://www.qasymphony.com/partners.html";

    // Locators
    private By findPartnerButton = By.id("findPartnerButtonId"); // Replace with actual ID or locator

    // Navigate to the page
    public void navigateToPage() {
        driver.get(PAGE_URL);
    }

    // Actions
    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}