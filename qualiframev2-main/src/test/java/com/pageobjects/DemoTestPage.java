package com.pageobjects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class DemoTestPage extends WebReusableComponents {
    private static final String RANDOM_NUMBER_FILE_PATH = "randomNumber.txt";


    protected By btn_Continue = By.xpath("//button[@type='submit']");
    protected By btn_Login = By.xpath("//button[@type='submit']");
    protected By txt_UserName = By.id("username");
    protected By txt_Password = By.id("password");
    protected By home_Option = By.xpath("//a[@href='/openmrs/spa/home'][text()='Home']");
    protected By user_Option = By.xpath("//button[@name='User']");
    protected By appMenuOption = By.xpath("//button[@aria-label='App Menu']");
    protected By btn_legacyAdmin = By.xpath("//a//div[text()='Legacy Admin']");
    protected By option_System_Administration = By.xpath("//div[@data-extension-id='system-administration-app-menu-link']//a[@href='/openmrs/spa/system-administration']");
    protected By option_Manage_Users = By.xpath("//li[@id='legacyui-manageUsers']//a");

    protected By option_Location_Window = By.xpath("//input[@id='Emergency Triage']//parent::div//label");

    protected By btn_Confirm_Location = By.xpath("//button[@type='submit']");

    protected By option_Add_User = By.xpath("//a[text()='Add User']");

    protected By btn_Next = By.id("createNewPersonButton");
    protected By textfield_GivenName = By.xpath("//input[@name='person.names[0].givenName']");

    protected By radiobtn_Gender_Male = By.xpath("//input[@name='person.gender']/following-sibling::label[@for='M']");

    protected By textfield_User_Password = By.xpath("//input[@name='userFormPassword']");

    protected By textfield_Confirm_User_Password = By.xpath("//input[@name='confirm']");

    protected By txt_User_Saved = By.xpath("//div[text()='User Saved']");

    protected By btn_Save_User = By.id("saveButton");
    protected By btn_Name_User = By.xpath("//button[@name='User']");

    private int linksUsingPatternCount;


    public void launchApp(String url) {
        launchUrl(url);
        maximizeWindow();
    }

    /**
     * Login Process
     **/
    public void clickContinueBtn() {
        waitUntilElementVisible(btn_Continue, 20);
        clickElement(btn_Continue);
    }

    public void enterUserNameTxt(String username) {
        enterText(txt_UserName, username);
    }

    public void enterPasswordTxt(String password) {
        enterText(txt_Password, password);
    }

    public void clickLogInBtn() {
        clickElement(btn_Login);
    }

    public boolean HandleLocationWindow() throws NoSuchElementException {
        if (driver.findElement(option_Location_Window).isDisplayed()) {
            System.out.println("Checking element");
            return true;
        } else {
            return false;
        }

    }
    protected By welcomeContainer= By.cssSelector("p.-esm-login__location-picker__welcomeTitle___iI+4Z");
    protected By emergencyTriageOption = By.xpath("//input[@id='Emergency Triage']");
    protected By confirmAction = By.xpath("//button[@type='submit']");
    public void checkAndPerformActions() {
        WebElement welcomeContainerElement;
        try {
            welcomeContainerElement = driver.findElement(welcomeContainer);
        } catch (NoSuchElementException e) {

            isHomeOptionDisplayedInHomePage();
            isUserOptionDisplayedInHomePage();
            return;
        }

        if (welcomeContainerElement.isDisplayed()) {
            performActionsIfWelcomeContainerDisplayed();
            isHomeOptionDisplayedInHomePage();
            isUserOptionDisplayedInHomePage();
        }
    }

    public void performActionsIfWelcomeContainerDisplayed() {
        WebElement welcomeContainerElement = driver.findElement(welcomeContainer);
        if (welcomeContainerElement.isDisplayed()) {
            selectEmergencyTriageOption();
            confirmAction();
        }
    }

    private void selectEmergencyTriageOption() {
        clickElement(emergencyTriageOption);
    }

    private void confirmAction() {
        clickElement(confirmAction);
    }

    public void clickOnLocation() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(option_Location_Window, 20);
                clickElement(option_Location_Window);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException ex) {
                attempts++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickOnUserMenu() {
        clickElement(btn_Name_User);
    }

    public void clickOnConfirmLocation() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(btn_Confirm_Location, 20);
                WebElement Location_Element = driver.findElement(btn_Confirm_Location);
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", Location_Element);
//                clickElement(btn_Confirm_Location);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException ex) {
                attempts++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void isHomeOptionDisplayedInHomePage() {
        try {
            waitUntilElementVisible(home_Option, 30);
            WebElement HomeOption = driver.findElement(home_Option);
            Assert.assertTrue(HomeOption.isDisplayed(), "Home Option is not displayed.");
            System.out.println("Home Option is displayed.");
        } catch (NoSuchElementException | TimeoutException e) {
            Assert.fail("Home Option not found or not displayed.");
        }
    }

    public void isUserOptionDisplayedInHomePage() {
        try {
            WebElement UserOption = driver.findElement(user_Option);
            Assert.assertTrue(UserOption.isDisplayed(), "User Option is not displayed.");
            System.out.println("User Option is displayed.");
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
                waitUntilElementVisible(option_System_Administration, 120);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException ex) {
                attempts++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickOnSystemAdministration() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(option_System_Administration, 20);
                clickElement(option_System_Administration);
                waitUntilElementVisible(btn_legacyAdmin, 120);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException ex) {
                attempts++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickOnLegacyAdmin() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(btn_legacyAdmin, 20);
                clickElement(btn_legacyAdmin);
                switchToLastestWindow();
                waitUntilElementVisible(option_Manage_Users, 120);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException ex) {
                attempts++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickOnManageUsers() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(option_Manage_Users, 20);
                clickElement(option_Manage_Users);
                waitUntilElementVisible(option_Add_User, 120);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException ex) {
                attempts++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickOnAddUser() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(option_Add_User, 20);
                clickElement(option_Add_User);
                waitUntilElementVisible(btn_Next, 120);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException ex) {
                attempts++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickOnNextBtn() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(btn_Next, 20);
                clickElement(btn_Next);
                waitUntilElementVisible(textfield_GivenName, 120);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException ex) {
                attempts++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void isFormDisplayedInUserPage() {
        try {
            WebElement User_form = driver.findElement(textfield_GivenName);
            Assert.assertTrue(User_form.isDisplayed(), "Form with fields is not displayed.");
            System.out.println("Form with fields is displayed.");
        } catch (NoSuchElementException | TimeoutException e) {
            Assert.fail("Form with fields not found or not displayed.");
        }
    }

    public void enterGivenNameTxt(String given_name) {
        enterText(textfield_GivenName, given_name);
    }

    public void enterGivenNameWithRandomNumber() {
        String randomFourDigitNumber = generateRandomFourDigitNumber();
        System.out.println("Generated Four-Digit Number: " + randomFourDigitNumber);
        storeRandomNumber(randomFourDigitNumber);
        String givenName = "QTdev" + randomFourDigitNumber;
        enterGivenNameTxt(givenName);
    }

    private void storeRandomNumber(String randomNumber) {
        try (FileWriter writer = new FileWriter(RANDOM_NUMBER_FILE_PATH)) {
            writer.write(randomNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String generateRandomFourDigitNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        return String.valueOf(randomNumber);
    }

    public void enterUserPasswordTxt(String user_password) {
        enterText(textfield_User_Password, user_password);
    }

    public void enterConfirmUserPasswordTxt(String confirm_user_password) {
        enterText(textfield_Confirm_User_Password, confirm_user_password);
    }

    public void clickOnGender() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(radiobtn_Gender_Male, 20);
                clickElement(radiobtn_Gender_Male);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException ex) {
                attempts++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickOnSaveUser() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(btn_Save_User, 20);
                clickElement(btn_Save_User);
                waitUntilElementVisible(option_Add_User, 120);
                Thread.sleep(2000);
                break;
            } catch (StaleElementReferenceException ex) {
                attempts++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void isUserSavedTxtDisplayed() {
        try {
            waitUntilElementVisible(txt_User_Saved, 30);
            WebElement User_Saved_txt = driver.findElement(txt_User_Saved);
            Assert.assertTrue(User_Saved_txt.isDisplayed(), "'User Saved' text is not displayed.");
            System.out.println("'User Saved' text is displayed.");
        } catch (NoSuchElementException | TimeoutException e) {
            Assert.fail("'User Saved' text not found or not displayed.");
        }
    }


    public void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}


























































