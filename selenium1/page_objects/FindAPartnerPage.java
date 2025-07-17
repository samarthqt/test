
package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindAPartnerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By btnFindPartner = By.id("findPartnerButton");
    private By partnerPageHeader = By.id("partnerPageHeader");

    public FindAPartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        WebElement findPartnerButton = wait.until(ExpectedConditions.elementToBeClickable(btnFindPartner));
        findPartnerButton.click();
    }

    /**
     * Verifies if the partner page is displayed.
     * 
     * @return true if the partner page header is displayed, false otherwise.
     */
    public boolean isPartnerPageDisplayed() {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(partnerPageHeader));
        boolean isDisplayed = header.isDisplayed();
        Assert.assertTrue(isDisplayed, "Partner page is not displayed.");
        return isDisplayed;
    }
}
