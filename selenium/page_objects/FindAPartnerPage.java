import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnersPage {

    private WebDriver driver;
    
    private By findPartnerButton = By.id("findPartnerButton"); // Assuming the button has an ID 'findPartnerButton'

    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void openPage() {
        driver.get("http://www.qasymphony.com/partners.html");
    }
    
    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}