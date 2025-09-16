
package selenium1.page_objects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FindPartnerPage extends WebReusableComponents {

    private final By btnFindPartner = By.id("findPartnerButton");
    private final By txtUserName = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("loginButton");

    public FindPartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToFindPartnerPage() {
        launchUrl("http://www.qasymphony.com/partners.html");
        waitUntilElementVisible(btnFindPartner, 5);
        Assert.assertTrue(isElementVisible(btnFindPartner), "Find Partner button is not visible");
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 3);
        clickElement(btnFindPartner);
        Assert.assertTrue(isElementVisible(btnFindPartner), "Failed to click Find Partner button");
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
        Assert.assertEquals(getElementText(txtUserName), username, "Username not entered correctly");
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
        Assert.assertEquals(getElementText(txtPassword), password, "Password not entered correctly");
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(btnLogin), "Failed to click Login button");
    }

    private boolean isElementVisible(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    private String getElementText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }
}
