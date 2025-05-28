import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnersPage {
    private WebDriver driver;
    
    // Constructor
    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // WebElements
    private By findPartnerButton = By.id("find-partner-button"); // Assuming the button has an id attribute

    // Methods
    public void openPage() {
        driver.get("http://www.qasymphony.com/partners.html");
    }
    
    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}