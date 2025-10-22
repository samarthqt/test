package com.cucumber.steps;

import com.pageobjects.SMSNotificationPage;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class SMSNotificationSteps extends SMSNotificationPage {

    @Given("the user has a registered phone number")
    public void theUserHasARegisteredPhoneNumber() {
        verifyRegisteredPhoneNumber();
    }

    @When("the user performs a key event {string}")
    public void theUserPerformsAKeyEvent(String event) {
        performKeyEvent(event);
    }

    @Then("the user should receive an SMS notification for {string}")
    public void theUserShouldReceiveAnSMSNotificationFor(String event) {
        verifySMSNotificationForEvent(event);
    }

    @Given("the user has opted in to marketing communications")
    public void theUserHasOptedInToMarketingCommunications() {
        verifyOptedInToMarketing();
    }

    @Given("the user complies with local regulations")
    public void theUserCompliesWithLocalRegulations() {
        verifyComplianceWithRegulations();
    }

    @When("the user is eligible for promotional messages")
    public void theUserIsEligibleForPromotionalMessages() {
        checkEligibilityForPromotions();
    }

    @Then("the user should receive a promotional SMS")
    public void theUserShouldReceiveAPromotionalSMS() {
        verifyPromotionalSMSReceived();
    }
}