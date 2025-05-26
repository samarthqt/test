import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class PartnersPage {

    private WebDriver driver;

    // Define the locator for "Find a Partner" button
    private By findPartnerButton = By.id("findPartnerButton");

    // Constructor
    public PartnersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to navigate to the specified URL
    public void navigateToPage() {
        driver.get("http://www.qasymphony.com/partners.html");
    }

    // Method to click on the "Find a Partner" button
    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}