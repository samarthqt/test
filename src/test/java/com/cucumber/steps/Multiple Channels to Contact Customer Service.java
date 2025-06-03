package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerServiceSteps extends CustomerServicePage {

    private TestHarness testHarness = new TestHarness();

    @Given("I have accessed the system's customer service page or contact information")
    public void iHaveAccessedTheCustomerServicePage() {
        navigateToCustomerServicePage();
    }

    @Then("the customer service page or contact information should be displayed")
    public void customerServicePageShouldBeDisplayed() {
        verifyCustomerServicePageDisplayed();
    }

    @Then("phone contact information should be displayed, including phone number and working hours")
    public void phoneContactInformationShouldBeDisplayed() {
        verifyPhoneContactInformation();
    }

    @Then("email contact information should be displayed, including email address and response time")
    public void emailContactInformationShouldBeDisplayed() {
        verifyEmailContactInformation();
    }

    @Then("a live chat option should be available for customers to contact customer service")
    public void liveChatOptionShouldBeAvailable() {
        verifyLiveChatOptionAvailable();
    }

    @When("I click on the phone contact information")
    public void iClickOnPhoneContactInformation() {
        clickPhoneContactInformation();
    }

    @Then("the phone dialer should open with the provided phone number pre-filled")
    public void phoneDialerShouldOpen() {
        verifyPhoneDialerOpened();
    }

    @When("I click on the email contact information")
    public void iClickOnEmailContactInformation() {
        clickEmailContactInformation();
    }

    @Then("the default email client should open with the recipient email address pre-filled")
    public void emailClientShouldOpen() {
        verifyEmailClientOpened();
    }

    @When("I click on the live chat option")
    public void iClickOnLiveChatOption() {
        clickLiveChatOption();
    }

    @Then("a live chat window should open for customers to start a conversation with customer service")
    public void liveChatWindowShouldOpen() {
        verifyLiveChatWindowOpened();
    }

    @Given("I have opened the live chat window")
    public void iHaveOpenedLiveChatWindow() {
        openLiveChatWindow();
    }

    @When("I enter a message in the live chat window")
    public void iEnterMessageInLiveChatWindow() {
        enterMessageInLiveChatWindow();
    }

    @Then("the message should be sent to customer service and a response should be received")
    public void messageShouldBeSentAndResponseReceived() {
        verifyMessageSentAndResponseReceived();
    }

    @Then("alternative contact methods should be displayed, if available, with relevant information")
    public void alternativeContactMethodsShouldBeDisplayed() {
        verifyAlternativeContactMethods();
    }

    @Then("the expected response time for each contact method should be mentioned")
    public void responseTimeShouldBeMentioned() {
        verifyResponseTimeMentioned();
    }

    @Then("the working hours for each contact method should be mentioned")
    public void workingHoursShouldBeMentioned() {
        verifyWorkingHoursMentioned();
    }

    @When("I try contacting customer service using each available channel")
    public void tryContactingCustomerService() {
        contactCustomerServiceThroughAllChannels();
    }

    @Then("customer service should be reachable through each available channel")
    public void customerServiceShouldBeReachable() {
        verifyCustomerServiceReachable();
    }

    @Then("the customer service contact information should be easily accessible from any page of the system")
    public void contactInformationShouldBeAccessible() {
        verifyContactInformationAccessible();
    }

    @Then("the customer service contact information should be displayed correctly on different devices without any formatting issues")
    public void contactInformationShouldBeDisplayedCorrectly() {
        verifyContactInformationDisplayedCorrectly();
    }

    @Then("the customer service contact information should be up to date and accurate")
    public void contactInformationShouldBeUpToDate() {
        verifyContactInformationUpToDate();
    }

    @Then("customer service contact forms or live chat should include measures to prevent spam or automated abuse, such as CAPTCHA")
    public void contactOptionsShouldBeProtectedFromSpam() {
        verifySpamProtectionMeasures();
    }

    @When("I attempt to print the customer service contact information page")
    public void attemptToPrintContactInformation() {
        initiatePrintContactInformation();
    }

    @Then("the contact information should be formatted correctly for printing")
    public void contactInformationShouldBePrintable() {
        verifyPrintFormatOfContactInformation();
    }
}