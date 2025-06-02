package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PurchasePage;

public class PurchaseSteps extends PurchasePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the application is opened on a desktop browser")
    public void theApplicationIsOpenedOnADesktopBrowser() {
        openApplication("desktop");
    }

    @Given("the application is opened on a mobile browser")
    public void theApplicationIsOpenedOnAMobileBrowser() {
        openApplication("mobile");
    }

    @When("the user logs into the application using valid credentials")
    public void theUserLogsIntoTheApplicationUsingValidCredentials() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @When("navigates to the product page and selects a product to purchase")
    public void navigatesToTheProductPageAndSelectsAProductToPurchase() {
        String productName = testHarness.getData("ProductData", "ProductName");
        selectProduct(productName);
    }

    @When("adds the product to the shopping cart")
    public void addsTheProductToTheShoppingCart() {
        addToCart();
    }

    @When("proceeds to checkout and selects payment method")
    public void proceedsToCheckoutAndSelectsPaymentMethod() {
        String paymentMethod = testHarness.getData("CheckoutData", "PaymentMethod");
        proceedToCheckout(paymentMethod);
    }

    @Then("the purchase process is completed successfully on the desktop without errors")
    public void thePurchaseProcessIsCompletedSuccessfullyOnTheDesktopWithoutErrors() {
        verifyPurchaseCompletion("desktop");
    }

    @Then("the purchase process is completed successfully on the mobile without errors")
    public void thePurchaseProcessIsCompletedSuccessfullyOnTheMobileWithoutErrors() {
        verifyPurchaseCompletion("mobile");
    }

    @Given("the purchase process is completed on both desktop and mobile")
    public void thePurchaseProcessIsCompletedOnBothDesktopAndMobile() {
        verifyPurchaseCompletion("desktop");
        verifyPurchaseCompletion("mobile");
    }

    @Then("purchase confirmation is received consistently across both platforms")
    public void purchaseConfirmationIsReceivedConsistentlyAcrossBothPlatforms() {
        verifyPurchaseConfirmationConsistency();
    }

    @Then("no discrepancies are found; purchase details match across platforms")
    public void noDiscrepanciesAreFoundPurchaseDetailsMatchAcrossPlatforms() {
        verifyPurchaseDetailsConsistency();
    }

    @Then("no issues are documented; purchase process is consistent across platforms")
    public void noIssuesAreDocumentedPurchaseProcessIsConsistentAcrossPlatforms() {
        verifyNoIssuesDocumented();
    }
}