import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PartnerPage {
    WebDriver driver;

    @FindBy(linkText = "Find a Partner")
    private WebElement findPartnerButton;

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://www.qasymphony.com/partners.html");
    }

    public void clickFindPartner() {
        findPartnerButton.click();
    }
}