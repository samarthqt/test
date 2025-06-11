package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.MobileResuableComponents;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.util.*;

public class MobilePage extends MobileResuableComponents {

    private AndroidDriver androidDriver;
    private IOSDriver iosDriver;

    protected By selectDOB = By.xpath("//android.view.View[@content-desc='01 January 2004']");
    protected By btnOK = By.xpath("//*[@text='OK']");
    protected By btnAgree = By.xpath("//android.widget.CheckBox[contains(@resource-id,'chk_agree')]");
    protected By btnRegister = By.xpath("//android.widget.Button[contains(@resource-id,'btn_register')]");
    protected By homeScreenlbl = By.xpath("//XCUIElementTypeStaticText[@name='Restaurant']");
    protected By searchRestaurant = By.xpath("//XCUIElementTypeStaticText[@name='Bulrush']");
    protected By selectRestaurantbtn = By.xpath("(//XCUIElementTypeStaticText[@name='More Info'])[1]");
    protected By addFoodFromMenu = By.xpath("//XCUIElementTypeButton[@name='Buy Now']");
    protected By addNewCardbtn = By.xpath("//XCUIElementTypeButton[@name='Add New Card']");
    protected By creditCardNumber = By.xpath("(//XCUIElementTypeTextField)[1]");
    protected By creditCardName = By.xpath("(//XCUIElementTypeTextField)[2]");
    protected By creditCardIssueDate = By.xpath("(//XCUIElementTypeTextField)[3]");
    protected By creditCardExpireOn = By.xpath("(//XCUIElementTypeTextField)[4]");
    protected By verifyPurchaseSuccessfulMessage = By.xpath("//XCUIElementTypeStaticText[@name='Purchase was successful']");
    protected By cardOwnerlabel = By.xpath("//XCUIElementTypeStaticText[@name='Card Owner']");
    protected By acceptAllCookiesBtn = By.xpath("//*[@class='cc-btn cc-accept-all cc-btn-no-href']");
    protected By searchProductTxtBox = By.className("header-search-input");
    protected By searchButton = By.className("header-search-button");
    protected By wishListButton = By.xpath("//*[text()='Add to wishlist']");

    public MobilePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String emailaddress) {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(10000);
        By emailAddress = generateLocator("XPATH", replaceLocator("//android.widget.EditText[contains(@resource-id,'register_email_address')]", "register_email_address"));
        enterText(emailAddress, rand_int1 + emailaddress);
    }

    public void enterPassword(String pwd) {
        By password = generateLocator("XPATH", replaceLocator("//android.widget.EditText[contains(@resource-id,'register_password')]", "register_password"));
        enterText(password, pwd);
    }

    public void enterCnfrmPaswd(String pwd) {
        By cnfrmPaswd = generateLocator("XPATH", replaceLocator("//android.widget.EditText[contains(@resource-id,'register_confirm_password')]", "register_confirm_password"));
        enterText(cnfrmPaswd, pwd);
    }

    public void enterfirstname(String fname) {
        By firstName = generateLocator("XPATH", replaceLocator("//android.widget.EditText[contains(@resource-id,'register_forename')]", "register_forename"));
        enterText(firstName, fname);
    }

    public void entersurname(String sname) {
        By surName = generateLocator("XPATH", replaceLocator("//android.widget.EditText[contains(@resource-id,'register_surname')]", "register_surname"));
        if (!elementVisible(surName)) {
            swipeScreen(Direction.UP);
        }
        enterText(surName, sname);
    }

    public void enterpostcode(String postcode) {
        By postCode = generateLocator("XPATH", replaceLocator("//android.widget.EditText[contains(@resource-id,'register_postcode')]", "register_postcode"));
        swipeScreen(Direction.UP);
        enterText(postCode, postcode);
    }

    public void clickDOB() {
        By dob = generateLocator("XPATH", replaceLocator("//android.widget.EditText[contains(@resource-id,'register_dob')]", "register_dob"));
        ClickElement(dob);
    }

    public void seleectDOB() {
        ClickElement(selectDOB);
    }

    public void clickOK() {
        ClickElement(btnOK);
    }

    public void clickRegister() {
        ClickElement(btnRegister);
    }

    public void clickAgree() {
        ClickElement(btnAgree);
    }

    public void launchMobileAppRealDevice() {
        Properties mobileProperties = Settings.getMobilePropertiesInstance();
        iosDriver = (IOSDriver) driver;
        if (mobileProperties.get("ios_appreset").toString().equalsIgnoreCase("true")) {
            iosDriver.terminateApp(mobileProperties.getProperty("ios_bundleid"));
        }
        iosDriver.activateApp(mobileProperties.getProperty("ios_bundleid"));
        Assert.assertTrue(iosDriver.isAppInstalled(mobileProperties.getProperty("ios_bundleid")), "App is not installed");
    }

    public void verifyHomeScreenRestaurantApp(String title) {
        iosDriver = (IOSDriver) driver;
        String homescreen = iosDriver.findElement(homeScreenlbl).getAttribute("label");
        Assert.assertEquals(homescreen, title, "Home screen title does not match");
    }

    public void selectRestaurant(String hotelName) {
        iosDriver = (IOSDriver) driver;
        String searchHotel = iosDriver.findElement(searchRestaurant).getAttribute("label");
        Assert.assertEquals(searchHotel, hotelName, "Hotel name does not match");
        ClickElement(selectRestaurantbtn);
    }

    public void selectFoodInMenuList(String foodMenu) {
        ClickElement(addFoodFromMenu);
    }

    public void selectFoodInMenuList() {
        ClickElement(selectRestaurantbtn);
        ClickElement(addFoodFromMenu);
    }

    public void verifyFoodInCart() {
        iosDriver = (IOSDriver) driver;
        Assert.assertTrue(iosDriver.findElement(addNewCardbtn).isDisplayed(), "Food is not added to the cart");
    }

    public void enterCrediCardNumber(String CreditCardNumber) {
        enterText(creditCardNumber, CreditCardNumber);
    }

    public void enterCrediCardName(String CreditCardName) {
        enterText(creditCardName, CreditCardName);
    }

    public void enterCrediCardIssueOn(String CreditCardissueOn) {
        ClickElement(cardOwnerlabel);
        ClickElement(cardOwnerlabel);
        enterText(creditCardIssueDate, CreditCardissueOn);
    }

    public void enterCrediCardExpiresOn(String CreditCardExpiresOn) {
        ClickElement(cardOwnerlabel);
        ClickElement(cardOwnerlabel);
        enterText(creditCardExpireOn, CreditCardExpiresOn);
    }

    public void orderSuccessfulConfirmationMessage() {
        iosDriver = (IOSDriver) driver;
        ClickElement(cardOwnerlabel);
        String message = iosDriver.findElement(verifyPurchaseSuccessfulMessage).getAttribute("label");
        Assert.assertEquals(message, "Purchase was successful", "Purchase confirmation message does not match");
    }

    public void addProductInWishList() {
        ClickElement(wishListButton);
    }

    public void verifyProductSearch(String productName) {
        enterText(searchProductTxtBox, productName);
        ClickElement(searchButton);
        WebElement product = driver.findElement(By.xpath("//*[text()='" + productName + "']"));
        Assert.assertTrue(product.isDisplayed(), "Product not found in search results");
    }

    public void launcMobileBrowserURL(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL does not match");
    }

    public void searchProduct(String productName) {
        enterText(searchProductTxtBox, productName);
        ClickElement(searchButton);
        WebElement product = driver.findElement(By.xpath("//*[text()='" + productName + "']"));
        Assert.assertTrue(product.isDisplayed(), "Product not found in search results");
    }
}