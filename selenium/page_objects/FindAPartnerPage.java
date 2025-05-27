import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PartnerPage {

    private WebDriver driver;

    // Locator for the "Find a Partner" button
    @FindBy(xpath = "//button[contains(text(),'Find a Partner')]")
    private WebElement findPartnerButton;

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to open the specified URL
    public void openPage() {
        driver.get("http://www.qasymphony.com/partners.html");
    }

    // Method to click on the "Find a Partner" button
    public void clickFindPartnerButton() {
        findPartnerButton.click();
    }
}