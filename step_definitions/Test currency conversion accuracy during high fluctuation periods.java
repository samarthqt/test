package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CurrencyConversionPage;

public class CurrencyConversionSteps extends CurrencyConversionPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I navigate to a product page priced in USD")
    public void iNavigateToAProductPagePricedInUSD() {
        navigateToProductPageInUSD();
    }

    @Then("the product page is displayed with USD pricing")
    public void theProductPageIsDisplayedWithUSD() {
        verifyProductPageDisplayedWithUSD();
    }

    @When("I select EUR as the currency")
    public void iSelectEURAsTheCurrency() {
        selectCurrency("EUR");
    }

    @Then("the product price is converted to EUR")
    public void theProductPriceIsConvertedToEUR() {
        verifyProductPriceConvertedTo("EUR");
    }

    @Given("the conversion rate fluctuation data for USD to EUR")
    public void theConversionRateFluctuationDataForUSDtoEUR() {
        fetchConversionRateData("USD", "EUR");
    }

    @Then("the converted price matches the expected value based on the current rate")
    public void theConvertedPriceMatchesTheExpectedValue() {
        verifyConvertedPriceMatchesExpected();
    }

    @When("I simulate a high fluctuation in conversion rate")
    public void iSimulateAHighFluctuationInConversionRate() {
        simulateHighFluctuation();
    }

    @Then("the system updates the conversion rate accordingly")
    public void theSystemUpdatesTheConversionRate() {
        verifySystemUpdatesConversionRate();
    }

    @When("I re-select EUR as the currency")
    public void iReSelectEURAsTheCurrency() {
        reSelectCurrency("EUR");
    }

    @Then("the product price reflects the updated EUR conversion rate")
    public void theProductPriceReflectsUpdatedEURRate() {
        verifyProductPriceReflectsUpdatedRate("EUR");
    }

    @When("I select GBP as the currency")
    public void iSelectGBPAsTheCurrency() {
        selectCurrency("GBP");
    }

    @Then("the product price is converted to GBP")
    public void theProductPriceIsConvertedToGBP() {
        verifyProductPriceConvertedTo("GBP");
    }

    @Given("the conversion rate fluctuation data for USD to GBP")
    public void theConversionRateFluctuationDataForUSDtoGBP() {
        fetchConversionRateData("USD", "GBP");
    }

    @When("I simulate another fluctuation in conversion rate")
    public void iSimulateAnotherFluctuationInConversionRate() {
        simulateAnotherFluctuation();
    }

    @When("I re-select GBP as the currency")
    public void iReSelectGBPAsTheCurrency() {
        reSelectCurrency("GBP");
    }

    @Then("the product price reflects the updated GBP conversion rate")
    public void theProductPriceReflectsUpdatedGBPRate() {
        verifyProductPriceReflectsUpdatedRate("GBP");
    }

    @When("I check for any discrepancies in conversion calculations")
    public void iCheckForDiscrepanciesInConversionCalculations() {
        checkForDiscrepancies();
    }

    @Then("no discrepancies are found and the conversion is accurate")
    public void noDiscrepanciesAreFound() {
        verifyNoDiscrepancies();
    }

    @When("I navigate to checkout with the selected currency")
    public void iNavigateToCheckoutWithSelectedCurrency() {
        navigateToCheckoutWithSelectedCurrency();
    }

    @Then("the checkout page displays prices in the selected currency")
    public void theCheckoutPageDisplaysPricesInSelectedCurrency() {
        verifyCheckoutPageDisplaysPricesInSelectedCurrency();
    }

    @Then("the final price at checkout matches the expected conversion rate")
    public void theFinalPriceAtCheckoutMatchesExpectedConversion() {
        verifyFinalPriceAtCheckoutMatchesExpected();
    }

    @When("I simulate rapid conversion rate changes during checkout")
    public void iSimulateRapidConversionRateChangesDuringCheckout() {
        simulateRapidConversionRateChanges();
    }

    @Then("the system handles rate changes without errors")
    public void theSystemHandlesRateChangesWithoutErrors() {
        verifySystemHandlesRateChanges();
    }

    @When("I complete the purchase")
    public void iCompleteThePurchase() {
        completePurchase();
    }

    @Then("the purchase completes successfully with accurate pricing")
    public void thePurchaseCompletesSuccessfully() {
        verifyPurchaseCompletesSuccessfully();
    }

    @When("I review transaction logs for conversion accuracy")
    public void iReviewTransactionLogsForConversionAccuracy() {
        reviewTransactionLogs();
    }

    @Then("the transaction logs confirm accurate conversion rates")
    public void theTransactionLogsConfirmAccurateConversionRates() {
        verifyTransactionLogsConfirmAccuracy();
    }
}