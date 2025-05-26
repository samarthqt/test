import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnersPage {
    private WebDriver driver;
    private By findPartnerButton = By.id("findPartnerButton"); // assuming the button has an id 'findPartnerButton'

    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://www.qasymphony.com/partners.html");
    }

    public void clickFindPartner() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}