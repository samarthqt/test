package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PartnerPage extends WebReusableComponents {

    protected By btnFindPartner = By.id("findPartnerButton");
    protected By partnerPageHeader = By.id("partnerPageHeader");

    public PartnerPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the Partner Page and maximizes the browser window.
     */
    public void navigateToPartnerPage() {
        launchUrl("http://www.qasymphony.com/partners.html");
        maximizeWindow();
    }

    /**
     * Clicks the 'Find Partner' button on the Partner Page.
     */
    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 5);
        clickElement(btnFindPartner);
    }

    /**
     * Verifies that the Partner Page is opened by checking the header text.
     */
    public void verifyPartnerPageOpened() {
        waitUntilElementVisible(partnerPageHeader, 5);
        String headerText = getTextFromElement(partnerPageHeader);
        Assert.assertEquals(headerText, "Find a Partner", "Partner page header does not match.");
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        driver.quit();
    }
}