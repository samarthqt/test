package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GuestCheckoutSteps extends GuestCheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a guest user is browsing the online store")
    public void aGuestUserIsBrowsingTheOnlineStore() {
        navigateToHomePage();
    }

    @When("the guest user selects an item to purchase")
    public void theGuestUserSelectsAnItemToPurchase() {
        String productName = testHarness.getData("ProductData", "ProductName");
        selectProduct(productName);
    }

    @Then("the item should be added to the cart")
    public void theItemShouldBeAddedToTheCart() {
        verifyProductInCart();
    }

    @Given("a guest user has items in the cart")
    public void aGuestUserHasItemsInTheCart() {
        openCart();
    }

    @When("the guest user clicks on the checkout button")
    public void theGuestUserClicksOnTheCheckoutButton() {
        proceedToCheckout();
    }

    @Then("the guest user should be directed to the checkout page")
    public void theGuestUserShouldBeDirectedToTheCheckoutPage() {
        verifyCheckoutPage();
    }

    @Given("a guest user is on the checkout page")
    public void aGuestUserIsOnTheCheckoutPage() {
        verifyCheckoutPage();
    }

    @When("the guest user enters valid shipping information")
    public void theGuestUserEntersValidShippingInformation() {
        String fullName = testHarness.getData("CheckoutData", "FullName");
        String address = testHarness.getData("CheckoutData", "Address");
        String city = testHarness.getData("CheckoutData", "City");
        String postalCode = testHarness.getData("CheckoutData", "PostalCode");
        String phone = testHarness.getData("CheckoutData", "Phone");
        enterShippingDetails(fullName, address, city, postalCode, phone);
    }

    @Then("the shipping information should be accepted")
    public void theShippingInformationShouldBeAccepted() {
        verifyShippingDetailsAccepted();
    }

    @Given("a guest user has entered shipping information")
    public void aGuestUserHasEnteredShippingInformation() {
        verifyShippingDetailsAccepted();
    }

    @When("the guest user enters valid payment information")
    public void theGuestUserEntersValidPaymentInformation() {
        String paymentMethod = testHarness.getData("CheckoutData", "PaymentMethod");
        enterPaymentDetails(paymentMethod);
    }

    @Then("the payment information should be accepted")
    public void thePaymentInformationShouldBeAccepted() {
        verifyPaymentDetailsAccepted();
    }

    @Given("a guest user has entered payment information")
    public void aGuestUserHasEnteredPaymentInformation() {
        verifyPaymentDetailsAccepted();
    }

    @When("the guest user reviews the order summary")
    public void theGuestUserReviewsTheOrderSummary() {
        reviewOrderSummary();
    }

    @Then("the order summary should display the correct items and total cost")
    public void theOrderSummaryShouldDisplayTheCorrectItemsAndTotalCost() {
        verifyOrderSummary();
    }

    @Given("a guest user has reviewed the order summary")
    public void aGuestUserHasReviewedTheOrderSummary() {
        verifyOrderSummary();
    }

    @When("the guest user confirms the purchase")
    public void theGuestUserConfirmsThePurchase() {
        confirmPurchase();
    }

    @Then("the purchase should be completed successfully")
    public void thePurchaseShouldBeCompletedSuccessfully() {
        verifyPurchaseCompletion();
    }

    @Given("the purchase is completed")
    public void thePurchaseIsCompleted() {
        verifyPurchaseCompletion();
    }

    @Then("the guest user should receive an order confirmation via email")
    public void theGuestUserShouldReceiveAnOrderConfirmationViaEmail() {
        verifyOrderConfirmationEmail();
    }

    @Given("a guest user has completed the purchase")
    public void aGuestUserHasCompletedThePurchase() {
        verifyPurchaseCompletion();
    }

    @When("the guest user views the order confirmation page")
    public void theGuestUserViewsTheOrderConfirmationPage() {
        viewOrderConfirmationPage();
    }

    @Then("the guest user should be offered the option to create an account for future purchases")
    public void theGuestUserShouldBeOfferedTheOptionToCreateAnAccountForFuturePurchases() {
        verifyAccountCreationOffer();
    }
}