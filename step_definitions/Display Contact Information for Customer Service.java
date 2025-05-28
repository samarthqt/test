package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerServiceSteps extends CustomerServicePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the customer service section of the system")
    public void theUserIsOnTheCustomerServiceSection() {
        navigateToCustomerServiceSection();
    }

    @When("the user checks the contact information for customer service")
    public void theUserChecksTheContactInformation() {
        checkContactInformation();
    }

    @Then("the system should display the contact information, including phone numbers, email addresses, and chat links")
    public void theSystemShouldDisplayContactInformation() {
        verifyContactInformationDisplay();
    }

    @When("the user verifies the phone numbers displayed")
    public void theUserVerifiesPhoneNumbers() {
        verifyPhoneNumbers();
    }

    @Then("the phone numbers displayed should be correct and valid for contacting customer service")
    public void thePhoneNumbersShouldBeCorrect() {
        assertPhoneNumbersValidity();
    }

    @When("the user verifies the email addresses displayed")
    public void theUserVerifiesEmailAddresses() {
        verifyEmailAddresses();
    }

    @Then("the email addresses displayed should be correct and valid for contacting customer service")
    public void theEmailAddressesShouldBeCorrect() {
        assertEmailAddressesValidity();
    }

    @When("the user verifies the chat links displayed")
    public void theUserVerifiesChatLinks() {
        verifyChatLinks();
    }

    @Then("the chat links displayed should be functional and allow users to initiate a chat with customer service")
    public void theChatLinksShouldBeFunctional() {
        assertChatLinksFunctionality();
    }

    @When("the user clicks on a phone number")
    public void theUserClicksOnPhoneNumber() {
        clickPhoneNumber();
    }

    @Then("the system should initiate a call to the selected phone number")
    public void theSystemShouldInitiateCall() {
        assertCallInitiation();
    }

    @When("the user clicks on an email address")
    public void theUserClicksOnEmailAddress() {
        clickEmailAddress();
    }

    @Then("the system should open the default email client with the selected email address pre-filled")
    public void theSystemShouldOpenEmailClient() {
        assertEmailClientOpening();
    }

    @When("the user clicks on a chat link")
    public void theUserClicksOnChatLink() {
        clickChatLink();
    }

    @Then("the system should open a chat window or redirect the user to a chat platform for contacting customer service")
    public void theSystemShouldOpenChatWindow() {
        assertChatWindowOpening();
    }

    @When("the user views the contact information")
    public void theUserViewsContactInformation() {
        viewContactInformation();
    }

    @Then("the contact information should be presented in a user-friendly format, making it easy for users to read and understand")
    public void theContactInformationShouldBeUserFriendly() {
        assertContactInformationFormat();
    }

    @When("the user verifies the contact information")
    public void theUserVerifiesContactInformation() {
        verifyContactInformation();
    }

    @Then("the contact information should be current and accurate, reflecting the latest phone numbers, email addresses, and chat links for customer service")
    public void theContactInformationShouldBeAccurate() {
        assertContactInformationAccuracy();
    }

    @Given("the user is on any page or section of the system")
    public void theUserIsOnAnyPage() {
        navigateToAnyPage();
    }

    @When("the user looks for the contact information")
    public void theUserLooksForContactInformation() {
        lookForContactInformation();
    }

    @Then("the contact information should be prominently displayed and easily accessible, ensuring users can quickly find and contact customer service")
    public void theContactInformationShouldBeAccessible() {
        assertContactInformationAccessibility();
    }

    @Given("the user accesses the system from different platforms or devices")
    public void theUserAccessesFromDifferentPlatforms() {
        accessFromDifferentPlatforms();
    }

    @When("the user views the contact information")
    public void theUserViewsContactInformationOnDifferentPlatforms() {
        viewContactInformationOnDifferentPlatforms();
    }

    @Then("the contact information should be consistent and displayed correctly regardless of the platform or device used to access the system")
    public void theContactInformationShouldBeConsistent() {
        assertContactInformationConsistency();
    }

    @Then("the contact information should be securely displayed, ensuring that only authorized users can view and access the information")
    public void theContactInformationShouldBeSecure() {
        assertContactInformationSecurity();
    }

    @Then("the contact information should be localized and displayed correctly for different regions or languages, ensuring that users can easily understand and use the information")
    public void theContactInformationShouldBeLocalized() {
        assertContactInformationLocalization();
    }

    @Given("the user is a system administrator or authorized personnel")
    public void theUserIsAdmin() {
        verifyUserIsAdmin();
    }

    @When("the user updates the contact information")
    public void theUserUpdatesContactInformation() {
        updateContactInformation();
    }

    @Then("the contact information should be easily updatable, allowing changes or updates as needed by system administrators or authorized personnel")
    public void theContactInformationShouldBeUpdatable() {
        assertContactInformationUpdatability();
    }
}