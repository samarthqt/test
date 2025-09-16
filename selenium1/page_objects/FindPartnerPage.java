package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPartnerPage {

    protected By btnFindPartner = By.id("findPartnerButton");
    private static final String EXPECTED_URL = "http://www.qasymphony.com/partners.html";

    public FindPartnerPage() {
        PageFactory.initElements(WebReusableComponents.getDriver(), this);
    }

    public void openBrowser() {
        WebReusableComponents.getDriver().manage().window().maximize();
    }

    public void enterUrl(String url) {
        WebReusableComponents.getDriver().get(url);
    }

    public void clickFindPartnerButton() {
        waitUntilElementClickable(btnFindPartner, 5);
        WebReusableComponents.getDriver().findElement(btnFindPartner).click();
    }

    public void verifyPartnerPageOpened() {
        String actualUrl = WebReusableComponents.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, EXPECTED_URL, "Partner page URL does not match.");
    }

    public void closeBrowser() {
        WebReusableComponents.getDriver().quit();
    }

    private void waitUntilElementClickable(By by, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(WebReusableComponents.getDriver(), timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}