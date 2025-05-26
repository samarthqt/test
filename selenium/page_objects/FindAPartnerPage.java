import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PartnerPage {
    WebDriver driver;

    @FindBy(id = "find-partner-button") // Assuming the button has this id, replace with actual locator
    private WebElement findPartnerButton;

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get("http://www.qasymphony.com/partners.html");
    }

    public void clickFindPartnerButton() {
        findPartnerButton.click();
    }
}