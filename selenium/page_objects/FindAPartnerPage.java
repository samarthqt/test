import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnersPage {
    private WebDriver driver;
    private By findPartnerButton = By.id("findPartnerButtonId"); // Example locator, replace with actual

    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://www.qasymphony.com/partners.html");
    }

    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }
}