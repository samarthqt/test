package com.pageobjects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.*;

public class DemoTestPage extends WebReusableComponents {

    protected By btnContinue = By.xpath("//button[@type='submit']");
    protected By btnLogin = By.xpath("//button[@type='submit']");
    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By homeOption = By.xpath("//a[@href='/openmrs/spa/home'][text()='Home']");
    protected By userOption = By.xpath("//button[@name='User']");
    protected By appMenuOption = By.xpath("//button[@aria-label='App Menu']");
    protected By btnLegacyAdmin = By.xpath("//a//div[text()='Legacy Admin']");
    protected By optionSystemAdministration = By.xpath("//div[@data-extension-id='system-administration-app-menu-link']//a[@href='/openmrs/spa/system-administration']");
    protected By optionManageUsers = By.xpath("//li[@id='legacyui-manageUsers']//a");
    protected By optionLocationWindow = By.xpath("//input[@id='Emergency Triage']//parent::div//label");
    protected By btnConfirmLocation = By.xpath("//button[@type='submit']");
    protected By optionAddUser = By.xpath("//a[text()='Add User']");
    protected By btnNext = By.id("createNewPersonButton");
    protected By textfieldGivenName = By.xpath("//input[@name='person.names[0].givenName']");
    protected By radiobtnGenderMale = By.xpath("//input[@name='person.gender']/following-sibling::label[@for='M']");
    protected By textfieldUserPassword = By.xpath("//input[@name='userFormPassword']");
    protected By textfieldConfirmUserPassword = By.xpath("//input[@name='confirm']");
    protected By txtUserSaved = By.xpath("//div[text()='User Saved']");
    protected By btnSaveUser = By.id("saveButton");
    protected By btnNameUser = By.xpath("//button[@name='User']");
    protected By welcomeContainer = By.cssSelector("p.-esm-login__location-picker__welcomeTitle___iI+4Z");
    protected By emergencyTriageOption = By.xpath("//input[@id='Emergency Triage']");
    protected By confirmAction = By.xpath("//button[@type='submit']");

    public DemoTestPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchApp(String url) {
        launchUrl(url);
        maximizeWindow();
    }

    public void clickContinueBtn() {
        waitUntilElementVisible(btnContinue, 20);
        clickElement(btnContinue);
    }

    public void enterUserNameTxt(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterPasswordTxt(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLogInBtn() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public boolean HandleLocationWindow() {
        try {
            return driver.findElement(optionLocationWindow).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void checkAndPerformActions() {
        try {
            WebElement welcomeContainerElement = driver.findElement(welcomeContainer);
            if (welcomeContainerElement.isDisplayed()) {
                performActionsIfWelcomeContainerDisplayed();
            }
        } catch (NoSuchElementException e) {
            isHomeOptionDisplayedInHomePage();
            isUserOptionDisplayedInHomePage();
        }
    }

    public void performActionsIfWelcomeContainerDisplayed() {
        selectEmergencyTriageOption();
        confirmAction();
        isHomeOptionDisplayedInHomePage();
        isUserOptionDisplayedInHomePage();
    }

    public void selectEmergencyTriageOption() {
        waitUntilElementVisible(emergencyTriageOption, 3);
        clickElement(emergencyTriageOption);
    }

    public void confirmAction() {
        waitUntilElementVisible(confirmAction, 3);
        clickElement(confirmAction);
    }

    public void clickOnLocation() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(optionLocationWindow, 20);
                clickElement(optionLocationWindow);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException | InterruptedException ex) {
                attempts++;
            }
        }
    }

    public void clickOnUserMenu() {
        waitUntilElementVisible(btnNameUser, 3);
        clickElement(btnNameUser);
    }

    public void clickOnConfirmLocation() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(btnConfirmLocation, 20);
                clickElement(btnConfirmLocation);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException | InterruptedException ex) {
                attempts++;
            }
        }
    }

    public void isHomeOptionDisplayedInHomePage() {
        try {
            waitUntilElementVisible(homeOption, 30);
            WebElement homeOptionElement = driver.findElement(homeOption);
            Assert.assertTrue(homeOptionElement.isDisplayed(), "Home Option is not displayed.");
        } catch (NoSuchElementException | TimeoutException e) {
            Assert.fail("Home Option not found or not displayed.");
        }
    }

    public void isUserOptionDisplayedInHomePage() {
        try {
            WebElement userOptionElement = driver.findElement(userOption);
            Assert.assertTrue(userOptionElement.isDisplayed(), "User Option is not displayed.");
        } catch (NoSuchElementException | TimeoutException e) {
            Assert.fail("User Option not found or not displayed.");
        }
    }

    public void clickOnAppMenu() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(appMenuOption, 20);
                clickElement(appMenuOption);
                waitUntilElementVisible(optionSystemAdministration, 120);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException | InterruptedException ex) {
                attempts++;
            }
        }
    }

    public void clickOnSystemAdministration() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(optionSystemAdministration, 20);
                clickElement(optionSystemAdministration);
                waitUntilElementVisible(btnLegacyAdmin, 120);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException | InterruptedException ex) {
                attempts++;
            }
        }
    }

    public void clickOnManageUsers() {
        waitUntilElementVisible(optionManageUsers, 3);
        clickElement(optionManageUsers);
    }

    public void clickOnAddUser() {
        waitUntilElementVisible(optionAddUser, 3);
        clickElement(optionAddUser);
    }

    public void clickOnNextBtn() {
        waitUntilElementVisible(btnNext, 3);
        clickElement(btnNext);
    }

    public void enterGivenNameTxt(String givenName) {
        waitUntilElementVisible(textfieldGivenName, 3);
        enterText(textfieldGivenName, givenName);
    }

    public void enterGivenNameWithRandomNumber(String givenName) {
        String randomName = givenName + generateRandomFourDigitNumber();
        enterGivenNameTxt(randomName);
    }

    public void clickOnGender() {
        waitUntilElementVisible(radiobtnGenderMale, 3);
        clickElement(radiobtnGenderMale);
    }

    public void enterUserPasswordTxt(String password) {
        waitUntilElementVisible(textfieldUserPassword, 3);
        enterText(textfieldUserPassword, password);
    }

    public void enterConfirmUserPasswordTxt(String confirmPassword) {
        waitUntilElementVisible(textfieldConfirmUserPassword, 3);
        enterText(textfieldConfirmUserPassword, confirmPassword);
    }

    public void clickOnSaveUser() {
        waitUntilElementVisible(btnSaveUser, 3);
        clickElement(btnSaveUser);
    }

    public boolean isUserSavedTxtDisplayed() {
        try {
            waitUntilElementVisible(txtUserSaved, 3);
            WebElement userSavedElement = driver.findElement(txtUserSaved);
            return userSavedElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnLegacyAdmin() {
        waitUntilElementVisible(btnLegacyAdmin, 3);
        clickElement(btnLegacyAdmin);
    }

    public boolean isFormDisplayedInUserPage() {
        try {
            waitUntilElementVisible(optionAddUser, 3);
            WebElement addUserElement = driver.findElement(optionAddUser);
            return addUserElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void storeRandomNumber(int number) {
        try (FileWriter writer = new FileWriter("randomNumber.txt")) {
            writer.write(String.valueOf(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int generateRandomFourDigitNumber() {
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);
        storeRandomNumber(randomNumber);
        return randomNumber;
    }

    public void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}