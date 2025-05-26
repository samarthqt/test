import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnerPage {

    private WebDriver driver;
    
    // Constructor
    public PartnerPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Locators
    private By findPartnerButton = By.id("findPartnerButton"); // Assuming the button has this ID
    
    // Methods
    public void open() {
        driver.get("http://www.qasymphony.com/partners.html");
    }
    
    public void clickFindPartner() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}