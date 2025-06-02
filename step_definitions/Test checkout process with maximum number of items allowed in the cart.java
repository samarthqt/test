package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;
import com.page_objects.LoginPage;
import com.page_objects.ProductCatalogPage;
import com.page_objects.CartPage;

public class CheckoutProcessSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with User ID {string} and password {string}")
    public void aUserAccountWithUserIDAndPassword(String userId, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(userId);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @When("the user logs in to the e-commerce website")
    public void theUserLogsInToTheECommerceWebsite() {
        // Already handled in the previous step
    }

    @Then("the user should be successfully logged in and redirected to the homepage")
    public void theUserShouldBeSuccessfullyLoggedInAndRedirectedToTheHomepage() {
        LoginPage loginPage = new LoginPage();
        String expectedURL = testHarness.getData("LoginData", "ExpectedHomePageURL");
        loginPage.verifyHomePageRedirection(expectedURL);
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        // Assumes user is already logged in from previous steps
    }

    @When("the user navigates to the product catalog")
    public void theUserNavigatesToTheProductCatalog() {
        ProductCatalogPage productCatalogPage = new ProductCatalogPage();
        productCatalogPage.navigateToProductCatalog();
    }

    @Then("the product catalog should be displayed with various items available for purchase")
    public void theProductCatalogShouldBeDisplayedWithVariousItemsAvailableForPurchase() {
        ProductCatalogPage productCatalogPage = new ProductCatalogPage();
        productCatalogPage.verifyProductCatalogDisplayed();
    }

    @Given("the user is viewing the product catalog")
    public void theUserIsViewingTheProductCatalog() {
        // Assumes user is already viewing the product catalog
    }

    @When("the user adds 50 items to the cart")
    public void theUserAdds50ItemsToTheCart() {
        ProductCatalogPage productCatalogPage = new ProductCatalogPage();
        productCatalogPage.addItemsToCart(50);
    }

    @Then("all selected items should be added to the cart successfully")
    public void allSelectedItemsShouldBeAddedToTheCartSuccessfully() {
        CartPage cartPage = new CartPage();
        cartPage.verifyItemsInCart(50);
    }

    @Given("the user has added 50 items to the cart")
    public void theUserHasAdded50ItemsToTheCart() {
        // Assumes items are already added to the cart
    }

    @When("the user views the cart")
    public void theUserViewsTheCart() {
        CartPage cartPage = new CartPage();
        cartPage.viewCart();
    }

    @Then("the cart should display 50 items with correct details like name, price, and quantity")
    public void theCartShouldDisplay50ItemsWithCorrectDetailsLikeNamePriceAndQuantity() {
        CartPage cartPage = new CartPage();
        cartPage.verifyCartDetails(50);
    }

    @Given("the cart contains 50 items")
    public void theCartContains50Items() {
        // Assumes cart contains 50 items
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        proceedToCheckout();
    }

    @Then("the user should be directed to the checkout page with all items listed")
    public void theUserShouldBeDirectedToTheCheckoutPageWithAllItemsListed() {
        verifyCheckoutPageItems(50);
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        // Assumes user is on the checkout page
    }

    @When("the user enters valid shipping and billing information")
    public void theUserEntersValidShippingAndBillingInformation() {
        String fullName = testHarness.getData("CheckoutData", "FullName");
        String address = testHarness.getData("CheckoutData", "Address");
        String city = testHarness.getData("CheckoutData", "City");
        String postalCode = testHarness.getData("CheckoutData", "PostalCode");
        String phone = testHarness.getData("CheckoutData", "Phone");
        enterShippingDetails(fullName, address, city, postalCode, phone);
    }

    @Then("the shipping and billing information should be accepted without errors")
    public void theShippingAndBillingInformationShouldBeAcceptedWithoutErrors() {
        verifyShippingDetailsAccepted();
    }

    @Given("the user has entered shipping and billing information")
    public void theUserHasEnteredShippingAndBillingInformation() {
        // Assumes shipping and billing information is entered
    }

    @When("the user selects a payment method and enters valid payment details")
    public void theUserSelectsAPaymentMethodAndEntersValidPaymentDetails() {
        String paymentMethod = testHarness.getData("CheckoutData", "PaymentMethod");
        selectPaymentMethod(paymentMethod);
    }

    @Then("the payment details should be processed successfully")
    public void thePaymentDetailsShouldBeProcessedSuccessfully() {
        verifyPaymentProcessed();
    }

    @Given("the payment details are processed successfully")
    public void thePaymentDetailsAreProcessedSuccessfully() {
        // Assumes payment details are processed
    }

    @When("the user confirms the order")
    public void theUserConfirmsTheOrder() {
        placeOrder();
    }

    @Then("order confirmation should be displayed with a unique order ID")
    public void orderConfirmationShouldBeDisplayedWithAUniqueOrderID() {
        String expectedMessage = testHarness.getData("CheckoutData", "ExpectedConfirmationMessage");
        verifyOrderConfirmation(expectedMessage);
    }

    @Given("the order is confirmed")
    public void theOrderIsConfirmed() {
        // Assumes order is confirmed
    }

    @When("the user views the order summary in their account")
    public void theUserViewsTheOrderSummaryInTheirAccount() {
        viewOrderSummary();
    }

    @Then("the order summary should reflect the correct items, quantities, and total amount")
    public void theOrderSummaryShouldReflectTheCorrectItemsQuantitiesAndTotalAmount() {
        verifyOrderSummaryDetails();
    }

    @When("the user checks their email")
    public void theUserChecksTheirEmail() {
        checkEmailForOrderConfirmation();
    }

    @Then("the user should receive an email confirmation with order details")
    public void theUserShouldReceiveAnEmailConfirmationWithOrderDetails() {
        verifyEmailConfirmation();
    }

    @Given("the cart contains the maximum number of items")
    public void theCartContainsTheMaximumNumberOfItems() {
        // Assumes cart contains maximum items
    }

    @When("the user attempts to add one more item to the cart")
    public void theUserAttemptsToAddOneMoreItemToTheCart() {
        attemptToAddExtraItem();
    }

    @Then("the system should prevent adding more than the maximum limit and display a relevant error message")
    public void theSystemShouldPreventAddingMoreThanTheMaximumLimitAndDisplayARelevantErrorMessage() {
        verifyMaxLimitErrorMessage();
    }

    @When("the user logs out from the website")
    public void theUserLogsOutFromTheWebsite() {
        logout();
    }

    @Then("the user should be logged out successfully")
    public void theUserShouldBeLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @Given("the user has logged out")
    public void theUserHasLoggedOut() {
        // Assumes user is logged out
    }

    @When("the user logs back in")
    public void theUserLogsBackIn() {
        aUserAccountWithUserIDAndPassword(testHarness.getData("LoginData", "UserName"), testHarness.getData("LoginData", "Password"));
    }

    @Then("the cart should retain the items added before logout")
    public void theCartShouldRetainTheItemsAddedBeforeLogout() {
        CartPage cartPage = new CartPage();
        cartPage.verifyItemsInCart(50);
    }

    @When("the user checks the order history")
    public void theUserChecksTheOrderHistory() {
        checkOrderHistory();
    }

    @Then("the order history should display the recently placed order with correct status")
    public void theOrderHistoryShouldDisplayTheRecentlyPlacedOrderWithCorrectStatus() {
        verifyOrderHistory();
    }

    @Given("the user is interacting with the website")
    public void theUserIsInteractingWithTheWebsite() {
        // Assumes user is interacting with the website
    }

    @When("the user performs actions during the checkout process")
    public void theUserPerformsActionsDuringTheCheckoutProcess() {
        // Assumes actions are performed
    }

    @Then("the website should perform efficiently without delays or errors")
    public void theWebsiteShouldPerformEfficientlyWithoutDelaysOrErrors() {
        verifyWebsitePerformance();
    }
}