package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pageobjects.RegistrationPage;
import com.framework.cucumber.TestHarness;

public class UserRegistrationSteps {

    private RegistrationPage registrationPage = new RegistrationPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        registrationPage.navigateToRegistrationPage();
    }

    @When("the user enters {string} in the {string} field")
    public void theUserEntersValueInField(String value, String fieldName) {
        switch (fieldName) {
            case "First name":
                registrationPage.enterFirstName(value);
                break;
            case "Last name":
                registrationPage.enterLastName(value);
                break;
            case "Email":
                registrationPage.enterEmail(value);
                break;
            case "Password":
                registrationPage.enterPassword(value);
                break;
            case "Confirm password":
                registrationPage.enterConfirmPassword(value);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String buttonName) {
        if (buttonName.equals("Register")) {
            registrationPage.clickRegisterButton();
        }
    }

    @Then("the user should be successfully registered and see a confirmation message")
    public void theUserShouldBeSuccessfullyRegisteredAndSeeAConfirmationMessage() {
        String expectedMessage = testHarness.getData("RegistrationData", "ExpectedConfirmationMessage");
        registrationPage.verifyRegistrationSuccess(expectedMessage);
    }
}
