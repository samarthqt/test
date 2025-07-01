package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.pageobjects.RegistrationPage;
import com.pageobjects.LoginPage;
import static org.testng.Assert.assertTrue;

public class UserRegistrationTest {

    private RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
        registrationPage = new RegistrationPage();
        registrationPage.navigateToRegistrationPage();
    }

    @Test
    public void testSuccessfulRegistration() {
        registrationPage.enterFirstName("John");
        registrationPage.enterLastName("Doe");
        registrationPage.enterEmail("john.doe@test.com");
        registrationPage.enterPassword("Pass@123");
        registrationPage.enterConfirmPassword("Pass@123");
        registrationPage.clickRegisterButton();
        registrationPage.verifyRegistrationSuccess("Registration successful");
    }

    @AfterMethod
    public void tearDown() {
        // Cleanup code if necessary
    }
}

public class UserLoginTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.enterUserName("validUser");
        loginPage.enterPassword("validPassword");
        loginPage.clickLoginButton();
        loginPage.verifyHomePageRedirection("expectedHomePageURL");
    }

    @AfterMethod
    public void tearDown() {
        // Cleanup code if necessary
    }
}