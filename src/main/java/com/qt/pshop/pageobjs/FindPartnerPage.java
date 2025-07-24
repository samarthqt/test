package com.qt.pshop.pageobjs;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class FindPartnerPage extends WebReusableComponents {

    private By btnFindPartner = By.id("findPartnerButton");
    private By partnerPageHeader = By.id("partnerPageHeader");

    public FindPartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 3);
        clickElement(btnFindPartner);
    }

    public void verifyPartnerPageLoaded() {
        waitUntilElementVisible(partnerPageHeader, 3);
        String headerText = getTextFromElement(partnerPageHeader);
        Assert.assertEquals(headerText, "Find a Partner", "Partner page header does not match.");
    }
}