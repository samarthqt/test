package com.cucumber.steps;

import com.pageobjects.LoginPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid username and password")
    public void theUserHasAValidUsernameAndPassword() {
        // Assume credentials are valid
    }

    @When("the user launches the CoCo URL in a web browser")
    public void theUserLaunchesTheCoCoURLInAWebBrowser() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the CoCo login page is displayed")
    public void theCoCoLoginPageIsDisplayed() {
        verifyLoginPageDisplayed();
    }

    @Then("the CoCo URL is accessible")
    public void theCoCoURLIsAccessible() {
        verifyUrlAccessibility();
    }

    @When("the user enters \"validUser\" in the username field")
    public void theUserEntersValidUserInTheUsernameField() {
        enterUserName("validUser");
    }

    @Then("the username is entered correctly")
    public void theUsernameIsEnteredCorrectly() {
        verifyUsernameEntered("validUser");
    }

    @When("the user enters \"validPass123\" in the password field")
    public void theUserEntersValidPass123InThePasswordField() {
        enterPassword("validPass123");
    }

    @Then("the password is entered correctly")
    public void thePasswordIsEnteredCorrectly() {
        verifyPasswordEntered("validPass123");
    }

    @When("the user clicks on the Login button")
    public void theUserClicksOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("the user is redirected to the homepage")
    public void theUserIsRedirectedToTheHomepage() {
        verifyHomePageRedirection(testHarness.getData("LoginData", "ExpectedHomePageURL"));
    }

    @Then("the homepage is displayed with user-specific content")
    public void theHomepageIsDisplayedWithUserSpecificContent() {
        verifyUserSpecificContent();
    }
}