package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

public class UserRegistrationSteps extends RegistrationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        navigateToRegistrationPage();
    }

    @When("the user enters {string} in the {string} field")
    public void theUserEntersValueInField(String value, String fieldName) {
        switch (fieldName) {
            case "First name":
                enterFirstName(value);
                break;
            case "Last name":
                enterLastName(value);
                break;
            case "Email":
                enterEmail(value);
                break;
            case "Password":
                enterPassword(value);
                break;
            case "Confirm password":
                enterConfirmPassword(value);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String buttonName) {
        if (buttonName.equals("Register")) {
            clickRegisterButton();
        }
    }

    @Then("the user should be successfully registered and see a confirmation message")
    public void theUserShouldBeSuccessfullyRegisteredAndSeeAConfirmationMessage() {
        String expectedMessage = testHarness.getData("RegistrationData", "ExpectedConfirmationMessage");
        verifyRegistrationSuccess(expectedMessage);
    }
}

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has added items to the cart")
    public void theUserHasAddedItemsToTheCart() {
        // Implementation for adding items to the cart
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        proceedToCheckout();
    }

    @When("the user enters valid shipping details")
    public void theUserEntersValidShippingDetails() {
        String fullName = testHarness.getData("ShippingData", "FullName");
        String address = testHarness.getData("ShippingData", "Address");
        String city = testHarness.getData("ShippingData", "City");
        String postalCode = testHarness.getData("ShippingData", "PostalCode");
        String phone = testHarness.getData("ShippingData", "Phone");
        enterShippingDetails(fullName, address, city, postalCode, phone);
    }

    @When("the user selects a payment method")
    public void theUserSelectsAPaymentMethod() {
        String paymentMethod = testHarness.getData("PaymentData", "Method");
        selectPaymentMethod(paymentMethod);
    }

    @When("the user places the order")
    public void theUserPlacesTheOrder() {
        placeOrder();
    }

    @Then("the user should see an order confirmation message")
    public void theUserShouldSeeAnOrderConfirmationMessage() {
        String expectedMessage = testHarness.getData("OrderData", "ExpectedConfirmationMessage");
        verifyOrderConfirmation(expectedMessage);
    }
}