package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NameWhitelistSteps extends NameWhitelistPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User is on the registration or profile update page")
    public void userIsOnTheRegistrationOrProfileUpdatePage() {
        navigateToRegistrationOrProfilePage();
    }

    @When("User navigates to the registration page")
    public void userNavigatesToTheRegistrationPage() {
        navigateToRegistrationPage();
    }

    @Then("Registration page is displayed")
    public void registrationPageIsDisplayed() {
        verifyRegistrationPageDisplayed();
    }

    @When("User enters 'Hooker' in the first name field")
    public void userEntersHookerInTheFirstNameField() {
        enterFirstName("Hooker");
    }

    @Then("'Hooker' is entered in the first name field")
    public void hookerIsEnteredInTheFirstNameField() {
        verifyFirstNameEntered("Hooker");
    }

    @When("User enters 'Hooker' in the last name field")
    public void userEntersHookerInTheLastNameField() {
        enterLastName("Hooker");
    }

    @Then("'Hooker' is entered in the last name field")
    public void hookerIsEnteredInTheLastNameField() {
        verifyLastNameEntered("Hooker");
    }

    @When("User submits the registration form")
    public void userSubmitsTheRegistrationForm() {
        submitRegistrationForm();
    }

    @Then("Form is submitted successfully without errors")
    public void formIsSubmittedSuccessfullyWithoutErrors() {
        verifyFormSubmissionSuccess();
    }

    @Then("Name 'Hooker' is displayed correctly on the profile page")
    public void nameHookerIsDisplayedCorrectlyOnTheProfilePage() {
        verifyNameDisplayedOnProfilePage("Hooker");
    }

    @When("User navigates to the profile update page")
    public void userNavigatesToTheProfileUpdatePage() {
        navigateToProfileUpdatePage();
    }

    @Then("Profile update page is displayed")
    public void profileUpdatePageIsDisplayed() {
        verifyProfileUpdatePageDisplayed();
    }

    @When("User enters 'Hooker' in the first name field")
    public void userEntersHookerInTheFirstNameFieldProfile() {
        enterFirstNameProfile("Hooker");
    }

    @Then("'Hooker' is entered in the first name field")
    public void hookerIsEnteredInTheFirstNameFieldProfile() {
        verifyFirstNameEnteredProfile("Hooker");
    }

    @When("User enters 'Hooker' in the last name field")
    public void userEntersHookerInTheLastNameFieldProfile() {
        enterLastNameProfile("Hooker");
    }

    @Then("'Hooker' is entered in the last name field")
    public void hookerIsEnteredInTheLastNameFieldProfile() {
        verifyLastNameEnteredProfile("Hooker");
    }

    @When("User submits the profile update")
    public void userSubmitsTheProfileUpdate() {
        submitProfileUpdate();
    }

    @Then("Profile is updated successfully without errors")
    public void profileIsUpdatedSuccessfullyWithoutErrors() {
        verifyProfileUpdateSuccess();
    }

    @Then("Name 'Hooker' is displayed correctly on all relevant pages")
    public void nameHookerIsDisplayedCorrectlyOnAllRelevantPages() {
        verifyNameDisplayedOnAllPages("Hooker");
    }

    @When("User checks for any error messages during submission")
    public void userChecksForAnyErrorMessagesDuringSubmission() {
        checkForErrorMessages();
    }

    @Then("No error messages are displayed")
    public void noErrorMessagesAreDisplayed() {
        verifyNoErrorMessages();
    }

    @Then("Name 'Hooker' is stored correctly in the database")
    public void nameHookerIsStoredCorrectlyInTheDatabase() {
        verifyNameStoredInDatabase("Hooker");
    }

    @When("User tests with different capitalization of 'Hooker'")
    public void userTestsWithDifferentCapitalizationOfHooker() {
        testDifferentCapitalizations("Hooker");
    }

    @Then("Different capitalizations are accepted without errors")
    public void differentCapitalizationsAreAcceptedWithoutErrors() {
        verifyCapitalizationsAccepted();
    }

    @When("User checks for any UI issues when displaying the name")
    public void userChecksForAnyUIIssuesWhenDisplayingTheName() {
        checkForUIIssues();
    }

    @Then("No UI issues are present")
    public void noUIIssuesArePresent() {
        verifyNoUIIssues();
    }

    @When("User verifies that the name is searchable in the system")
    public void userVerifiesThatTheNameIsSearchableInTheSystem() {
        verifyNameSearchable("Hooker");
    }

    @Then("Name 'Hooker' is searchable without issues")
    public void nameHookerIsSearchableWithoutIssues() {
        verifyNameSearchableWithoutIssues();
    }
}