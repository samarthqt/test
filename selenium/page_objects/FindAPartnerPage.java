import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnersPage {

    WebDriver driver;

    // Constructor
    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By findPartnerButton = By.xpath("//button[text()='Find a Partner']");

    // Methods
    public void openPage() {
        driver.get("http://www.qasymphony.com/partners.html");
    }

    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}