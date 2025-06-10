package com.pageobjects;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.components.ScriptHelper;
import com.framework.components.Settings;
import com.framework.cucumber.TestHarness;
import com.framework.reusable.MobileResuableComponents;

public class MobilePage extends MobileResuableComponents {

    private TestHarness testHarness = new TestHarness();

    // Android locators
    private String commonTxt = "//android.widget.EditText[contains(@resource-id,'var1')]";
    private By selectDOB = By.xpath("//android.view.View[@content-desc='01 January 2004']");
    private By btnOK = By.xpath("//*[@text='OK']");
    private By btnAgree = By.xpath("//android.widget.CheckBox[contains(@resource-id,'chk_agree')]");
    private By btnRegister = By.xpath("//android.widget.Button[contains(@resource-id,'btn_register')]");

    // iOS locators
    private By homeScreenlbl = By.xpath("//XCUIElementTypeStaticText[@name='Restaurant']");
    private By seearchRestaurent = By.xpath("//XCUIElementTypeStaticText[@name='Bulrush']");
    private By selectRestaurentbtn = By.xpath("(//XCUIElementTypeStaticText[@name='More Info'])[1]");
    private By addFoodFromMenu = By.xpath("//XCUIElementTypeButton[@name='Buy Now']");
    private By addNewCardbtn = By.xpath("//XCUIElementTypeButton[@name='Add New Card']");
    private By creditCardNumber = By.xpath("(//XCUIElementTypeTextField)[1]");
    private By creditCardName = By.xpath("(//XCUIElementTypeTextField)[2]");
    private By creditCardIssueDate = By.xpath("(//XCUIElementTypeTextField)[3]");
    private By creditCardExpireOn = By.xpath("(//XCUIElementTypeTextField)[4]");
    private By verifyPurchaseSuccessfulMessage = By.xpath("//XCUIElementTypeStaticText[@name='Purchase was successful']");
    private By cardOwnerlabel = By.xpath("//XCUIElementTypeStaticText[@name='Card Owner']");
    private By acceptAllCookiesBtn = By.xpath("//*[@class='cc-btn cc-accept-all cc-btn-no-href']");
    private By searchProductTxtBox = By.className("header-search-input");
    private By serachButton = By.className("header-search-button");
    private By wishListButton = By.xpath("//*[text()='Add to wishlist']");

    public MobilePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String emailaddress) {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(10000);
        By emailAddress = generateLocator("XPATH", replaceLocator(commonTxt, "register_email_address"));
        enterText(emailAddress, rand_int1 + emailaddress);
    }

    public void enterPassword(String pwd) {
        By password = generateLocator("XPATH", replaceLocator(commonTxt, "register_password"));
        enterText(password, pwd);
    }

    public void enterCnfrmPaswd(String pwd) {
        By cnfrmPaswd = generateLocator("XPATH", replaceLocator(commonTxt, "register_confirm_password"));
        enterText(cnfrmPaswd, pwd);
    }

    public void enterfirstname(String fname) {
        By firstName = generateLocator("XPATH", replaceLocator(commonTxt, "register_forename"));
        enterText(firstName, fname);
    }

    public void entersurname(String sname) {
        By surName = generateLocator("XPATH", replaceLocator(commonTxt, "register_surname"));
        if (!elementVisible(surName)) {
            swipeScreen(Direction.UP);
        }
        enterText(surName, sname);
    }

    public void enterpostcode(String postcode) {
        By postCode = generateLocator("XPATH", replaceLocator(commonTxt, "register_postcode"));
        swipeScreen(Direction.UP);
        enterText(postCode, postcode);
    }

    public void clickDOB() {
        By dob = generateLocator("XPATH", replaceLocator(commonTxt, "register_dob"));
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
        if (mobileProperties.get("ios_appreset").toString().equalsIgnoreCase("true")) {
            driver.resetApp();
        }
        driver.launchApp();
        Assert.assertTrue(driver != null, "App is not launched successfully in Real device");
    }

    public void verifyHomeScreenRestaurentApp(String title) {
        String homescreen = driver.findElement(homeScreenlbl).getAttribute("label");
        Assert.assertEquals(homescreen, title, "Home screen title does not match");
    }

    public void selectRestaurent(String hotelName) {
        String serachHotel = driver.findElement(seearchRestaurent).getAttribute("label");
        if (serachHotel.equalsIgnoreCase(hotelName)) {
            ClickElement(selectRestaurentbtn);
        }
    }

    public void selectFoodInMenuList(String foodMenu) {
        ClickElement(addFoodFromMenu);
    }

    public void selectFoodInMenuList() {
        ClickElement(selectRestaurentbtn);
        ClickElement(addFoodFromMenu);
    }

    public void verifyFoodInCart() {
        Assert.assertTrue(driver.findElement(addNewCardbtn).isDisplayed(), "Food is not added to the cart");
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
        ClickElement(cardOwnerlabel);
        ClickElement(cardOwnerlabel);
        ClickElement(addNewCardbtn);
        Assert.assertTrue(driver.findElement(verifyPurchaseSuccessfulMessage).isDisplayed(), "Order is not successful");
    }

    public void launcMobileBrowserURL(String tcid, String url) {
        testHarness.initializeTestData(tcid);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ClickElement(acceptAllCookiesBtn);
    }

    public void serachProduct(String product) {
        ClickElement(searchProductTxtBox);
        enterText(searchProductTxtBox, product);
    }

    public void verifyProductSearch() {
        WebElement searchButton = driver.findElement(serachButton);
        Assert.assertTrue(searchButton.isDisplayed(), "Search button is not displayed");
    }

    public void addProductInWishList() {
        ClickElement(wishListButton);
        Assert.assertTrue(driver.findElement(wishListButton).isDisplayed(), "Product is not added to wishlist");
    }
}