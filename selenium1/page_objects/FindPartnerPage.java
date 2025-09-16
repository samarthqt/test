package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class FindPartnerPage extends WebReusableComponents {

    protected By btnFindPartner = By.id("findPartnerButton");
    protected By partnerPageHeader = By.id("partnerPageHeader");

    public FindPartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        launchUrl("http://www.qasymphony.com/partners.html");
        Assert.assertTrue(driver.getCurrentUrl().contains("partners.html"), "Failed to open the partner page.");
    }

    public void navigateToPartnerPage() {
        waitUntilElementVisible(btnFindPartner, 5);
        Assert.assertTrue(objectExists(btnFindPartner), "Find Partner button is not visible.");
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 3);
        clickElement(btnFindPartner);
        Assert.assertTrue(driver.getCurrentUrl().contains("partner"), "Failed to navigate to partner page after clicking.");
    }

    public void verifyPartnerPageLoaded() {
        waitUntilElementVisible(partnerPageHeader, 3);
        String headerText = getTextFromElement(partnerPageHeader);
        Assert.assertEquals(headerText, "Find a Partner", "Partner page header does not match.");
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Browser did not close properly.");
    }
}