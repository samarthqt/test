package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;
import pages.FileUploadPage;
import pages.LoginPage;
import pages.RegistrationPage;
import org.testng.Assert;

public class FormSubmissionTest {
    WebDriver driver;
    FormPage formPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        formPage = new FormPage(driver);
    }

    @Test
    public void testFormSubmission() {
        formPage.navigateToFormPage();
        formPage.fillForm("John Doe", "john.doe@example.com", "This is a test message.");
        formPage.submitForm();
        Assert.assertTrue(formPage.isConfirmationMessageDisplayed(), "Form submission failed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

public class FileUploadTest {
    WebDriver driver;
    FileUploadPage fileUploadPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        fileUploadPage = new FileUploadPage(driver);
    }

    @Test
    public void testFileUpload() {
        fileUploadPage.navigateToUploadPage();
        fileUploadPage.uploadFile("/path/to/your/file.txt");
        Assert.assertTrue(fileUploadPage.isUploadConfirmationDisplayed(), "File upload failed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.navigateToLoginPage();
        loginPage.login("testuser", "SecurePassword123");
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Login failed - Dashboard not found");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

public class RegistrationTest {
    WebDriver driver;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void testRegistration() {
        registrationPage.navigateToRegistrationPage();
        registrationPage.register("John", "Doe", "john.doe@example.com", "SecurePassword123", "SecurePassword123");
        Assert.assertTrue(registrationPage.isSuccessMessageDisplayed(), "Registration failed - Success message not found");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}