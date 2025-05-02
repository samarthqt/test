package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationSteps extends RegistrationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        navigateToRegistrationPage();
    }

    @When("the user enters a valid name")
    public void theUserEntersAValidName() {
        String firstName = testHarness.getData("RegistrationData", "FirstName");
        String lastName = testHarness.getData("RegistrationData", "LastName");
        enterFirstName(firstName);
        enterLastName(lastName);
    }

    @When("the user enters a valid email")
    public void theUserEntersAValidEmail() {
        String email = testHarness.getData("RegistrationData", "Email");
        enterEmail(email);
    }

    @When("the user enters a valid password")
    public void theUserEntersAValidPassword() {
        String password = testHarness.getData("RegistrationData", "Password");
        enterPassword(password);
        enterConfirmPassword(password);
    }

    @When("the user submits the registration form")
    public void theUserSubmitsTheRegistrationForm() {
        clickRegisterButton();
    }

    @Then("the user account should be created successfully")
    public void theUserAccountShouldBeCreatedSuccessfully() {
        String expectedMessage = testHarness.getData("RegistrationData", "ExpectedConfirmationMessage");
        verifyRegistrationSuccess(expectedMessage);
    }

    @Then("the user should be redirected to the homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        String expectedURL = testHarness.getData("RegistrationData", "ExpectedHomePageURL");
        verifyHomePageRedirection(expectedURL);
    }

    @When("the user enters an email that is already registered")
    public void theUserEntersAnEmailThatIsAlreadyRegistered() {
        String email = testHarness.getData("RegistrationData", "AlreadyRegisteredEmail");
        enterEmail(email);
    }

    @Then("the user should see an error message indicating the email is already registered")
    public void theUserShouldSeeAnErrorMessageIndicatingTheEmailIsAlreadyRegistered() {
        String expectedErrorMessage = testHarness.getData("RegistrationData", "EmailAlreadyRegisteredErrorMessage");
        verifyErrorMessage(expectedErrorMessage);
    }

    @When("the user enters an invalid email format")
    public void theUserEntersAnInvalidEmailFormat() {
        String email = testHarness.getData("RegistrationData", "InvalidEmailFormat");
        enterEmail(email);
    }

    @Then("the user should see an error message indicating the email format is invalid")
    public void theUserShouldSeeAnErrorMessageIndicatingTheEmailFormatIsInvalid() {
        String expectedErrorMessage = testHarness.getData("RegistrationData", "InvalidEmailFormatErrorMessage");
        verifyErrorMessage(expectedErrorMessage);
    }

    @When("the user enters a weak password")
    public void theUserEntersAWeakPassword() {
        String password = testHarness.getData("RegistrationData", "WeakPassword");
        enterPassword(password);
        enterConfirmPassword(password);
    }

    @Then("the user should see an error message indicating the password is too weak")
    public void theUserShouldSeeAnErrorMessageIndicatingThePasswordIsTooWeak() {
        String expectedErrorMessage = testHarness.getData("RegistrationData", "WeakPasswordErrorMessage");
        verifyErrorMessage(expectedErrorMessage);
    }

    @When("the user leaves the name field empty")
    public void theUserLeavesTheNameFieldEmpty() {
        enterFirstName("");
        enterLastName("");
    }

    @Then("the user should see an error message indicating the name is required")
    public void theUserShouldSeeAnErrorMessageIndicatingTheNameIsRequired() {
        String expectedErrorMessage = testHarness.getData("RegistrationData", "NameRequiredErrorMessage");
        verifyErrorMessage(expectedErrorMessage);
    }

    @When("the user leaves the email field empty")
    public void theUserLeavesTheEmailFieldEmpty() {
        enterEmail("");
    }

    @Then("the user should see an error message indicating the email is required")
    public void theUserShouldSeeAnErrorMessageIndicatingTheEmailIsRequired() {
        String expectedErrorMessage = testHarness.getData("RegistrationData", "EmailRequiredErrorMessage");
        verifyErrorMessage(expectedErrorMessage);
    }

    @When("the user leaves the password field empty")
    public void theUserLeavesThePasswordFieldEmpty() {
        enterPassword("");
        enterConfirmPassword("");
    }

    @Then("the user should see an error message indicating the password is required")
    public void theUserShouldSeeAnErrorMessageIndicatingThePasswordIsRequired() {
        String expectedErrorMessage = testHarness.getData("RegistrationData", "PasswordRequiredErrorMessage");
        verifyErrorMessage(expectedErrorMessage);
    }
}