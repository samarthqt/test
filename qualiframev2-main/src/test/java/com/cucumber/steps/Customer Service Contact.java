package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.*;

public class UserLoginSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        String userName = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        enterUserName(userName);
        enterPassword(password);
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String buttonName) {
        clickLoginButton();
    }

    @Then("the user should be redirected to the homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        String expectedURL = testHarness.getData("LoginData", "ExpectedHomePageURL");
        verifyHomePageRedirection(expectedURL);
    }
}

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has added items to the cart")
    public void theUserHasAddedItemsToTheCart() {
        String productName = testHarness.getData("CartData", "ProductName");
        String quantity = testHarness.getData("CartData", "Quantity");
        addProductToCart(productName, quantity);
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        proceedToCheckout();
    }

    @When("the user enters valid shipping details")
    public void theUserEntersValidShippingDetails() {
        String fullName = testHarness.getData("CheckoutData", "FullName");
        String address = testHarness.getData("CheckoutData", "Address");
        String city = testHarness.getData("CheckoutData", "City");
        String postalCode = testHarness.getData("CheckoutData", "PostalCode");
        String phone = testHarness.getData("CheckoutData", "Phone");
        enterShippingDetails(fullName, address, city, postalCode, phone);
    }

    @When("the user selects a payment method")
    public void theUserSelectsAPaymentMethod() {
        String paymentMethod = testHarness.getData("CheckoutData", "PaymentMethod");
        selectPaymentMethod(paymentMethod);
    }

    @When("the user places the order")
    public void theUserPlacesTheOrder() {
        placeOrder();
    }

    @Then("the user should see an order confirmation message")
    public void theUserShouldSeeAnOrderConfirmationMessage() {
        String expectedMessage = testHarness.getData("CheckoutData", "ExpectedConfirmationMessage");
        verifyOrderConfirmation(expectedMessage);
    }
}