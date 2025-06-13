package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class OrderSteps extends OrderPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the product page")
    public void theUserIsOnTheProductPage() {
        String productName = testHarness.getData("ProductData", "ProductName");
        navigateToProductPage(productName);
    }

    @When("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {
        addProductToCart();
    }

    @Then("the product should be visible in the cart")
    public void theProductShouldBeVisibleInTheCart() {
        String expectedProductName = testHarness.getData("ProductData", "ProductName");
        openCart();
        verifyProductInCart(expectedProductName);
    }

    @Given("the user has proceeded to checkout")
    public void theUserHasProceededToCheckout() {
        proceedToCheckout();
    }

    @When("the user enters shipping information")
    public void theUserEntersShippingInformation() {
        String fullName = testHarness.getData("CheckoutData", "FullName");
        String address = testHarness.getData("CheckoutData", "Address");
        String city = testHarness.getData("CheckoutData", "City");
        String postalCode = testHarness.getData("CheckoutData", "PostalCode");
        String phone = testHarness.getData("CheckoutData", "Phone");
        enterShippingDetails(fullName, address, city, postalCode, phone);
    }

    @When("the user enters payment information")
    public void theUserEntersPaymentInformation() {
        String paymentMethod = testHarness.getData("CheckoutData", "PaymentMethod");
        selectPaymentMethod(paymentMethod);
    }

    @When("the user submits the order")
    public void theUserSubmitsTheOrder() {
        placeOrder();
    }

    @Then("the user should see the \"ThankYouOrder\" page")
    public void theUserShouldSeeTheThankYouOrderPage() {
        verifyThankYouPage();
    }

    @Given("the user has submitted the order")
    public void theUserHasSubmittedTheOrder() {
        placeOrder();
    }

    @Then("the user should see the \"ThankYouOrder\" page with order confirmation details")
    public void theUserShouldSeeTheThankYouOrderPageWithOrderConfirmationDetails() {
        verifyOrderConfirmationDetails();
    }
}

