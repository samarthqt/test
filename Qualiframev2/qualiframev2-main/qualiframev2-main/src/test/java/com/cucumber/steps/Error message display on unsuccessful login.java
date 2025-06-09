package com.cucumber.steps;

import com.pageobjects.LoginPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ErrorMessageSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Given("the login page displays username and password fields")
    public void theLoginPageDisplaysUsernameAndPasswordFields() {
        waitUntilElementVisible(txtUserName, 3);
        waitUntilElementVisible(txtPassword, 3);
    }

    @When("the user enters {string} in the username field")
    public void theUserEntersInTheUsernameField(String username) {
        enterUserName(username);
    }

    @When("the user enters {string} in the password field")
    public void theUserEntersInThePasswordField(String password) {
        enterPassword(password);
    }

    @When("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("the system processes the login attempt")
    public void theSystemProcessesTheLoginAttempt() {
        // Logic to verify processing can be added here
    }

    @Then("the login is unsuccessful, and the user remains on the login page")
    public void theLoginIsUnsuccessfulAndTheUserRemainsOnTheLoginPage() {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, getAppUrl(), "User is not on the login page.");
    }

    @Then("an appropriate error message indicating incorrect password is displayed")
    public void anAppropriateErrorMessageIndicatingIncorrectPasswordIsDisplayed() {
        String errorMessage = getTextFromElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.contains("incorrect password"), "Error message is not displayed correctly.");
    }

    @Then("the error message is clear and provides guidance on next steps")
    public void theErrorMessageIsClearAndProvidesGuidanceOnNextSteps() {
        String errorMessage = getTextFromElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.contains("Please try again or reset your password."), "Error message does not provide guidance.");
    }
}