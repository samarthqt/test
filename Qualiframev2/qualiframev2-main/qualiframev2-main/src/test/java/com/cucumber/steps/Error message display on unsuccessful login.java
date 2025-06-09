package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pageobjects.LoginPage;

public class LoginErrorSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Given("the login page displays username and password fields")
    public void theLoginPageDisplaysUsernameAndPasswordFields() {
        verifyElementVisible(txtUserName);
        verifyElementVisible(txtPassword);
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
        // Logic to verify processing can be added here if needed
    }

    @Then("the login is unsuccessful, and the user remains on the login page")
    public void theLoginIsUnsuccessfulAndTheUserRemainsOnTheLoginPage() {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, getAppUrl(), "User is not on the login page.");
    }

    @Then("an appropriate error message indicating incorrect password is displayed")
    public void anAppropriateErrorMessageIndicatingIncorrectPasswordIsDisplayed() {
        String errorMessage = getErrorMessage();
        Assert.assertTrue(errorMessage.contains("incorrect password"), "Error message is not displayed correctly.");
    }

    @Then("the error message is clear and provides guidance on next steps")
    public void theErrorMessageIsClearAndProvidesGuidanceOnNextSteps() {
        String errorMessage = getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Please try again"), "Error message does not provide guidance.");
    }

    private String getErrorMessage() {
        return getTextFromElement(By.id("errorMessage"));
    }
}