package com.cucumber.steps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import com.framework.cucumber.TestHarness;

import com.pageobjects.PromotionalSMSPage;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.When;

public class PromotionalSMSSteps extends PromotionalSMSPage {

    @Given("the user has not opted in for promotional SMS")
    public void theUserHasNotOptedInForPromotionalSMS() {
        verifyUserNotOptedIn();
    }

    @When("a promotional SMS event is triggered")
    public void aPromotionalSMSEventIsTriggered() {
        triggerPromotionalSMSEvent();
    }

    @Then("no promotional SMS is received on the user's phone")
    public void noPromotionalSMSIsReceivedOnTheUsersPhone() {
        verifyNoPromotionalSMSReceived();
    }
}