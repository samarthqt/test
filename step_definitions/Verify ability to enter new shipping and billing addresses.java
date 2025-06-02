package com.cucumber.steps;

import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressSetupSteps extends CheckoutPage {

    @Given("a user account is logged in")
    public void userAccountIsLoggedIn() {
        loginUser();
    }

    @When("the user navigates to the checkout page")
    public void userNavigatesToCheckoutPage() {
        navigateToCheckoutPage();
    }

    @Then("the checkout page is displayed with options to enter shipping and billing addresses")
    public void checkoutPageDisplayedWithAddressOptions() {
        verifyCheckoutPageDisplayed();
    }

    @Given("the user is on the checkout page")
    public void userOnCheckoutPage() {
        verifyCheckoutPageDisplayed();
    }

    @When("the user clicks on 'Add New Address' for shipping")
    public void userClicksAddNewAddressForShipping() {
        clickAddNewShippingAddress();
    }

    @Then("a form to enter new shipping address is displayed")
    public void formToEnterNewShippingAddressDisplayed() {
        verifyShippingAddressFormDisplayed();
    }

    @Given("the shipping address form is displayed")
    public void shippingAddressFormDisplayed() {
        verifyShippingAddressFormDisplayed();
    }

    @When("the user enters shipping address details {string}")
    public void userEntersShippingAddressDetails(String addressDetails) {
        enterShippingAddressDetails(addressDetails);
    }

    @When("enters phone number {string}")
    public void userEntersPhoneNumber(String phoneNumber) {
        enterPhoneNumber(phoneNumber);
    }

    @Then("the shipping address details are entered correctly")
    public void shippingAddressDetailsEnteredCorrectly() {
        verifyShippingAddressDetailsEntered();
    }

    @Given("the user has entered shipping address details")
    public void userHasEnteredShippingAddressDetails() {
        verifyShippingAddressDetailsEntered();
    }

    @When("the user clicks on 'Add New Address' for billing")
    public void userClicksAddNewAddressForBilling() {
        clickAddNewBillingAddress();
    }

    @Then("a form to enter new billing address is displayed")
    public void formToEnterNewBillingAddressDisplayed() {
        verifyBillingAddressFormDisplayed();
    }

    @Given("the billing address form is displayed")
    public void billingAddressFormDisplayed() {
        verifyBillingAddressFormDisplayed();
    }

    @When("the user enters billing address details {string}")
    public void userEntersBillingAddressDetails(String billingDetails) {
        enterBillingAddressDetails(billingDetails);
    }

    @When("enters email {string}")
    public void userEntersEmail(String email) {
        enterEmail(email);
    }

    @Then("billing address details are entered correctly")
    public void billingAddressDetailsEnteredCorrectly() {
        verifyBillingAddressDetailsEntered();
    }

    @Given("the user has entered shipping and billing address details")
    public void userHasEnteredShippingAndBillingAddressDetails() {
        verifyShippingAndBillingDetailsEntered();
    }

    @When("the user clicks 'Save' to store the new addresses")
    public void userClicksSaveToStoreNewAddresses() {
        clickSaveAddresses();
    }

    @Then("addresses are saved successfully without errors")
    public void addressesSavedSuccessfullyWithoutErrors() {
        verifyAddressesSavedSuccessfully();
    }

    @Given("the addresses are saved successfully")
    public void addressesSavedSuccessfully() {
        verifyAddressesSavedSuccessfully();
    }

    @When("the user views the list of saved addresses")
    public void userViewsListOfSavedAddresses() {
        viewSavedAddresses();
    }

    @Then("newly entered addresses appear in the list of saved addresses")
    public void newlyEnteredAddressesAppearInList() {
        verifyNewAddressesInList();
    }

    @Given("the newly entered addresses are saved")
    public void newlyEnteredAddressesSaved() {
        verifyAddressesSavedSuccessfully();
    }

    @When("the user proceeds to checkout using the new addresses")
    public void userProceedsToCheckoutUsingNewAddresses() {
        proceedToCheckoutWithNewAddresses();
    }

    @Then("checkout process continues using the newly entered addresses")
    public void checkoutProcessContinuesUsingNewAddresses() {
        verifyCheckoutProcessWithNewAddresses();
    }

    @Given("the checkout process continues using the new addresses")
    public void checkoutProcessContinuesUsingNewAddresses() {
        verifyCheckoutProcessWithNewAddresses();
    }

    @When("the checkout is confirmed")
    public void checkoutIsConfirmed() {
        confirmCheckout();
    }

    @Then("a confirmation message is displayed indicating the use of new addresses")
    public void confirmationMessageDisplayedForNewAddresses() {
        verifyConfirmationMessageForNewAddresses();
    }

    @Given("the user is entering addresses")
    public void userIsEnteringAddresses() {
        startEnteringAddresses();
    }

    @When("the addresses are entered")
    public void addressesAreEntered() {
        enterAddresses();
    }

    @Then("no error messages are displayed; addresses are accepted")
    public void noErrorMessagesDisplayedAddressesAccepted() {
        verifyNoErrorMessages();
    }

    @Then("address format is validated and correct")
    public void addressFormatValidatedAndCorrect() {
        verifyAddressFormat();
    }

    @Then("all required fields are populated correctly")
    public void allRequiredFieldsPopulatedCorrectly() {
        verifyRequiredFieldsPopulated();
    }

    @When("addresses in different valid formats are entered")
    public void addressesInDifferentValidFormatsEntered() {
        enterAddressesInDifferentFormats();
    }

    @Then("addresses in different valid formats are accepted")
    public void addressesInDifferentFormatsAccepted() {
        verifyAddressesInDifferentFormatsAccepted();
    }

    @When("international addresses are entered")
    public void internationalAddressesEntered() {
        enterInternationalAddresses();
    }

    @Then("international addresses are entered and accepted correctly")
    public void internationalAddressesAcceptedCorrectly() {
        verifyInternationalAddressesAccepted();
    }
}