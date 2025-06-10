package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.*;

public class UserSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        String userName = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        enterUserName(userName);
        enterPassword(password);
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String buttonName) {
        if (buttonName.equals("Login")) {
            clickLoginButton();
        } else if (buttonName.equals("Register")) {
            clickRegisterButton();
        }
    }

    @Then("the user should be redirected to the homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        String expectedURL = testHarness.getData("LoginData", "ExpectedHomePageURL");
        verifyHomePageRedirection(expectedURL);
    }

    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        navigateToRegistrationPage();
    }

    @When("the user enters {string} in the {string} field")
    public void theUserEntersValueInField(String value, String fieldName) {
        switch (fieldName) {
            case "First name":
                enterFirstName(value);
                break;
            case "Last name":
                enterLastName(value);
                break;
            case "Email":
                enterEmail(value);
                break;
            case "Password":
                enterPassword(value);
                break;
            case "Confirm password":
                enterConfirmPassword(value);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
    }

    @Then("the user should be successfully registered and see a confirmation message")
    public void theUserShouldBeSuccessfullyRegisteredAndSeeAConfirmationMessage() {
        String expectedMessage = testHarness.getData("RegistrationData", "ExpectedConfirmationMessage");
        verifyRegistrationSuccess(expectedMessage);
    }
}