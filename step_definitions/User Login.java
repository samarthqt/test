package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the user enters a valid email and password")
    public void theUserEntersAValidEmailAndPassword() {
        String email = testHarness.getData("LoginData", "Email");
        String password = testHarness.getData("LoginData", "Password");
        enterEmail(email);
        enterPassword(password);
    }

    @When("the user enters an invalid email and a valid password")
    public void theUserEntersAnInvalidEmailAndAValidPassword() {
        String email = testHarness.getData("LoginData", "InvalidEmail");
        String password = testHarness.getData("LoginData", "Password");
        enterEmail(email);
        enterPassword(password);
    }

    @When("the user enters a valid email and an invalid password")
    public void theUserEntersAValidEmailAndAnInvalidPassword() {
        String email = testHarness.getData("LoginData", "Email");
        String password = testHarness.getData("LoginData", "InvalidPassword");
        enterEmail(email);
        enterPassword(password);
    }

    @When("the user enters an invalid email and an invalid password")
    public void theUserEntersAnInvalidEmailAndAnInvalidPassword() {
        String email = testHarness.getData("LoginData", "InvalidEmail");
        String password = testHarness.getData("LoginData", "InvalidPassword");
        enterEmail(email);
        enterPassword(password);
    }

    @When("the user leaves the email and password fields empty")
    public void theUserLeavesTheEmailAndPasswordFieldsEmpty() {
        enterEmail("");
        enterPassword("");
    }

    @When("clicks on the login button")
    public void clicksOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("the user should be redirected to their account homepage")
    public void theUserShouldBeRedirectedToTheirAccountHomepage() {
        String expectedURL = testHarness.getData("LoginData", "ExpectedHomePageURL");
        verifyHomePageRedirection(expectedURL);
    }

    @Then("an error message should be displayed indicating invalid email")
    public void anErrorMessageShouldBeDisplayedIndicatingInvalidEmail() {
        verifyErrorMessage("Invalid email.");
    }

    @Then("an error message should be displayed indicating invalid password")
    public void anErrorMessageShouldBeDisplayedIndicatingInvalidPassword() {
        verifyErrorMessage("Invalid password.");
    }

    @Then("an error message should be displayed indicating invalid credentials")
    public void anErrorMessageShouldBeDisplayedIndicatingInvalidCredentials() {
        verifyErrorMessage("Invalid credentials.");
    }

    @Then("an error message should be displayed indicating that fields cannot be empty")
    public void anErrorMessageShouldBeDisplayedIndicatingThatFieldsCannotBeEmpty() {
        verifyErrorMessage("Fields cannot be empty.");
    }

    @When("the user clicks on the \"Forgot Password?\" link")
    public void theUserClicksOnTheForgotPasswordLink() {
        clickForgotPasswordLink();
    }

    @Then("the user should be redirected to the password reset page")
    public void theUserShouldBeRedirectedToThePasswordResetPage() {
        verifyPasswordResetPageRedirection();
    }

    @When("the user sees the \"Remember Me\" checkbox")
    public void theUserSeesTheRememberMeCheckbox() {
        verifyRememberMeCheckboxVisibility();
    }

    @Then("the user should be able to select or deselect the checkbox")
    public void theUserShouldBeAbleToSelectOrDeselectTheCheckbox() {
        toggleRememberMeCheckbox();
    }

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        // Assume user is already logged in
    }

    @When("the user clicks on the logout button")
    public void theUserClicksOnTheLogoutButton() {
        clickLogoutButton();
    }

    @Then("the user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        verifyLoginPageRedirection();
    }
}