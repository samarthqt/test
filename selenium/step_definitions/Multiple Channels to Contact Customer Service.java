package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerServiceSteps extends CustomerServicePage {

    private TestHarness testHarness = new TestHarness();

    @Then("customer service contact forms or live chat should include measures to prevent spam or automated abuse, such as CAPTCHA")
    public void verifySpamProtection() {
        verifySpamProtectionMeasures();
    }

    @When("I attempt to print the customer service contact information page")
    public void attemptToPrintContactInformation() {
        printContactInformationPage();
    }

    @Then("the contact information should be formatted correctly for printing")
    public void verifyContactInformationPrintFormat() {
        verifyPrintFormat();
    }
}