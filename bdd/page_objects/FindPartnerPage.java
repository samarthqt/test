package bdd.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class FindPartnerPage extends WebReusableComponents {

    protected By findPartnerButton = By.id("findPartnerButton");
    protected By partnerInformation = By.id("partnerInformation");

    public FindPartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        driver.manage().window().maximize();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
        Assert.assertTrue(driver.getCurrentUrl().equals(url), "Failed to navigate to the specified URL.");
    }

    public void verifyFindPartnerPageDisplayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("partners.html"), "Find a Partner page is not displayed.");
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(findPartnerButton, 3);
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
        Assert.assertTrue(isElementDisplayed(partnerInformation), "Failed to click Find Partner button.");
    }

    public void verifyPartnerInformationDisplayed() {
        waitUntilElementVisible(partnerInformation, 3);
        Assert.assertTrue(isElementDisplayed(partnerInformation), "Partner information is not displayed.");
    }

    private boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}