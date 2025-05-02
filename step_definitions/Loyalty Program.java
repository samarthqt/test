package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoyaltyProgramSteps extends LoyaltyProgramPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a customer is not enrolled in the loyalty program")
    public void customerIsNotEnrolled() {
        navigateToEnrollmentPage();
    }

    @When("the customer enrolls in the loyalty program")
    public void customerEnrolls() {
        enrollInLoyaltyProgram();
    }

    @Then("the customer should receive a confirmation of enrollment")
    public void confirmEnrollment() {
        verifyEnrollmentConfirmation();
    }

    @Then("the customer should see the loyalty program details in their account")
    public void verifyProgramDetails() {
        checkLoyaltyProgramDetails();
    }

    @Given("a customer is enrolled in the loyalty program")
    public void customerIsEnrolled() {
        verifyCustomerEnrollment();
    }

    @Given("the customer is logged into their account")
    public void customerIsLoggedIn() {
        verifyCustomerLogin();
    }

    @When("the customer makes a purchase")
    public void customerMakesPurchase() {
        makePurchase();
    }

    @Then("the customer should earn loyalty points for the purchase")
    public void earnLoyaltyPoints() {
        verifyLoyaltyPointsEarned();
    }

    @Then("the customer should receive any applicable discounts")
    public void receiveDiscounts() {
        verifyDiscountsApplied();
    }

    @Given("a customer has sufficient loyalty points")
    public void customerHasSufficientPoints() {
        verifySufficientLoyaltyPoints();
    }

    @When("the customer chooses to redeem points for a reward")
    public void redeemPointsForReward() {
        redeemLoyaltyPoints();
    }

    @Then("the loyalty points should be deducted from the customer's account")
    public void deductLoyaltyPoints() {
        verifyPointsDeduction();
    }

    @Then("the customer should receive the chosen reward")
    public void receiveChosenReward() {
        verifyRewardReceived();
    }

    @Given("a customer has made frequent purchases")
    public void customerHasFrequentPurchases() {
        verifyFrequentPurchases();
    }

    @When("the customer makes another purchase")
    public void customerMakesAnotherPurchase() {
        makeAnotherPurchase();
    }

    @Then("the customer should receive a discount based on their purchase frequency")
    public void receiveFrequencyDiscount() {
        verifyFrequencyDiscount();
    }

    @When("the customer checks their loyalty points balance")
    public void checkLoyaltyPointsBalance() {
        verifyLoyaltyPointsBalance();
    }

    @Then("the customer should see the correct number of loyalty points in their account")
    public void verifyCorrectPointsBalance() {
        checkCorrectPointsBalance();
    }

    @When("there is an update to the loyalty program")
    public void loyaltyProgramUpdate() {
        checkForProgramUpdates();
    }

    @Then("the customer should receive a notification about the update")
    public void receiveUpdateNotification() {
        verifyUpdateNotification();
    }
}