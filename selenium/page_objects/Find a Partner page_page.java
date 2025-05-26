import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnersPage {
    private WebDriver driver;
    
    // Define locators
    private By findPartnerButton = By.id("findPartnerButton"); // Assuming the button has an id 'findPartnerButton'

    // Constructor
    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page actions
    public void openPage() {
        driver.get("http://www.qasymphony.com/partners.html");
    }

    public void clickFindPartner() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}