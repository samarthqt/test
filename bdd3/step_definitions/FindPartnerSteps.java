package com.cucumber.steps;
import io.cucumber.java.en.Given;
import com.framework.cucumber.TestHarness;

import com.pageobjects.FindPartnerPage;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Then;

public class FindPartnerSteps extends FindPartnerPage {

    @Given("I open a new browser window")
    public void iOpenANewBrowserWindow() {
        openNewBrowserWindow();
    }

    @When("I enter \"{string}\" URL")
    public void iEnterURL(String url) {
        enterURL(url);
    }

    @Then("I click on the \"Find a Partner\" button")
    public void iClickOnTheFindAPartnerButton() {
        clickFindPartnerButton();
    }
}

