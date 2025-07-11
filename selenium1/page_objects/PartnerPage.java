package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import .util.List;

public class PartnerPage extends WebReusableComponents {

    private final By txtUserName = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("loginButton");
    private final By addressBookLink = By.id("addressBook");
    private final By addAddressButton = By.id("addAddress");
    private final By txtAddressLine1 = By.id("addressLine1");
    private final By txtCity = By.id("city");
    private final By txtState = By.id("state");
    private final By txtPostalCode = By.id("postalCode");
    private final By txtCountry = By.id("country");
    private final By saveAddressButton = By.id("saveAddress");
    private final By addressEntries = By.cssSelector(".address-entry");
    private final By btnFindPartner = By.id("findPartnerButton");
    private final By findPartnerPageHeader = By.tagName("h1");

    public PartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    public void navigateToAddressBook() {
        waitUntilElementVisible(addressBookLink, 3);
        clickElement(addressBookLink);
    }

    public void addNewAddress(String addressLine1, String city, String state, String postalCode, String country) {
        waitUntilElementVisible(addAddressButton, 3);
        clickElement(addAddressButton);
        enterText(txtAddressLine1, addressLine1);
        enterText(txtCity, city);
        enterText(txtState, state);
        enterText(txtPostalCode, postalCode);
        enterText(txtCountry, country);
        clickElement(saveAddressButton);
    }

    public void verifyAddressSaved() {
        waitUntilElementVisible(addressEntries, 3);
        List<WebElement> addresses = getWebElementList(addressEntries);
        Assert.assertFalse(addresses.isEmpty(), "No addresses found in the address book.");
    }

    public void removeAddress(String addressLine1) {
        By removeButton = By.xpath("//div[contains(text(), '" + addressLine1 + "')]/following-sibling::button[@class='remove']");
        waitUntilElementVisible(removeButton, 3);
        clickElement(removeButton);
    }

    public void verifyAddressRemoved(String addressLine1) {
        By addressLocator = By.xpath("//div[contains(text(), '" + addressLine1 + "')]/following-sibling::button[@class='remove']");
        boolean isAddressPresent = elementVisible(addressLocator);
        Assert.assertFalse(isAddressPresent, "Address was not removed from the address book.");
    }

    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(btnFindPartner);
        button.click();
    }

    public boolean isFindPartnerPageDisplayed() {
        WebElement header = driver.findElement(findPartnerPageHeader);
        return header.isDisplayed() && header.getText().contains("Find a Partner");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}