package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class UserLoginSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the login page is displayed on app launch")
    public void theLoginPageIsDisplayedOnAppLaunch() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        String userName = testHarness.getData("LoginData", "ValidUserName");
        String password = testHarness.getData("LoginData", "ValidPassword");
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }

    @Then("the login succeeds")
    public void theLoginSucceeds() {
        String expectedURL = testHarness.getData("LoginData", "ExpectedHomePageURL");
        verifyHomePageRedirection(expectedURL);
    }

    @Then("the home page is displayed")
    public void theHomePageIsDisplayed() {
        String expectedURL = testHarness.getData("LoginData", "ExpectedHomePageURL");
        verifyHomePageRedirection(expectedURL);
    }

    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        String userName = testHarness.getData("LoginData", "InvalidUserName");
        String password = testHarness.getData("LoginData", "InvalidPassword");
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }

    @Then("the login fails")
    public void theLoginFails() {
        verifyErrorMessage("Invalid credentials.");
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessage("Invalid credentials.");
    }

    @When("the user enters empty credentials")
    public void theUserEntersEmptyCredentials() {
        enterUserName("");
        enterPassword("");
        clickLoginButton();
    }

    @Then("an error message is displayed indicating missing credentials")
    public void anErrorMessageIsDisplayedIndicatingMissingCredentials() {
        verifyErrorMessage("Missing credentials.");
    }

    @Given("the app is launched")
    public void theAppIsLaunched() {
        launchUrl(getAppUrl());
    }

    @Then("the login page is displayed")
    public void theLoginPageIsDisplayed() {
        verifyLoginPageDisplayed();
    }

    @Then("the login form is accessible")
    public void theLoginFormIsAccessible() {
        verifyLoginFormAccessibility();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        theLoginPageIsDisplayedOnAppLaunch();
        theUserEntersValidCredentials();
        theLoginSucceeds();
    }

    @When("the user chooses to log out")
    public void theUserChoosesToLogOut() {
        clickLogoutButton();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLoginPageDisplayed();
    }

    @Then("the login page is displayed")
    public void theLoginPageIsDisplayedAgain() {
        verifyLoginPageDisplayed();
    }
}

