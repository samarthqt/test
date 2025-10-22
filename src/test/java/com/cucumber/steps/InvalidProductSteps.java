package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.pageobjects.InvalidProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class InvalidProductSteps extends InvalidProductPage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user attempts to add a product with ID {string} to the cart")
    public void theUserAttemptsToAddAProductWithIDToTheCart(String productID) {
        attemptToAddInvalidProduct(productID);
    }

    @Then("an error message is displayed indicating the product cannot be added")
    public void anErrorMessageIsDisplayedIndicatingTheProductCannotBeAdded() {
        verifyErrorMessageDisplayed();
    }
}