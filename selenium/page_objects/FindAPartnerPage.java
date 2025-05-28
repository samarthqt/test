import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PartnersPage {
    WebDriver driver;

    By findPartnerButton = By.xpath("//button[contains(text(), 'Find a Partner')]");

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