public class PaymentSteps {

    WebDriver driver;
    CheckoutPage checkoutPage;

    @Given("the user is on the checkout page")
    public void userOnCheckoutPage() {
        driver = new ChromeDriver();
        driver.get("http://example.com/checkout");
        checkoutPage = new CheckoutPage(driver);
    }

    @When("the user selects \"Credit Card\" as the payment method")
    public void selectCreditCardPayment() {
        checkoutPage.selectPaymentMethod("Credit Card");
    }

    @When("the user enters valid credit card details")
    public void enterValidCreditCardDetails() {
        checkoutPage.enterCreditCardDetails("4111111111111111", "12/23", "123");
    }

    @When("the user submits the payment")
    public void submitPayment() {
        checkoutPage.submitPayment();
    }

    @Then("the payment should be processed successfully")
    public void verifySuccessfulPayment() {
        Assert.assertTrue(checkoutPage.isPaymentSuccessful());
    }

    @Then("the user should see a confirmation message for the successful payment")
    public void verifyConfirmationMessage() {
        Assert.assertTrue(checkoutPage.isConfirmationMessageDisplayed());
    }

    @When("the user selects \"PayPal\" as the payment method")
    public void selectPayPalPayment() {
        checkoutPage.selectPaymentMethod("PayPal");
    }

    @When("the user is redirected to the PayPal login page")
    public void redirectToPayPalLogin() {
        Assert.assertTrue(checkoutPage.isRedirectedToPayPal());
    }

    @When("the user logs in with valid PayPal credentials")
    public void loginToPayPal() {
        checkoutPage.loginToPayPal("user@example.com", "password123");
    }

    @When("the user confirms the payment on the PayPal platform")
    public void confirmPayPalPayment() {
        checkoutPage.confirmPayPalPayment();
    }

    @Then("the user should be redirected back to the checkout page")
    public void verifyRedirectToCheckout() {
        Assert.assertTrue(checkoutPage.isRedirectedBackToCheckout());
    }

    @When("the user enters invalid credit card details")
    public void enterInvalidCreditCardDetails() {
        checkoutPage.enterCreditCardDetails("1234567890123456", "01/20", "000");
    }

    @Then("the payment should be declined")
    public void verifyDeclinedPayment() {
        Assert.assertTrue(checkoutPage.isPaymentDeclined());
    }

    @Then("the user should see an error message indicating the payment was not successful")
    public void verifyErrorMessage() {
        Assert.assertTrue(checkoutPage.isErrorMessageDisplayed());
    }

    @When("the user cancels the payment on the PayPal platform")
    public void cancelPayPalPayment() {
        checkoutPage.cancelPayPalPayment();
    }

    @Then("the payment should not be processed")
    public void verifyPaymentNotProcessed() {
        Assert.assertFalse(checkoutPage.isPaymentSuccessful());
    }

    @Then("the user should see a message indicating the payment was canceled")
    public void verifyCancellationMessage() {
        Assert.assertTrue(checkoutPage.isCancellationMessageDisplayed());
    }

    @When("the user tries to proceed without selecting a payment method")
    public void proceedWithoutPaymentMethod() {
        checkoutPage.proceedWithoutPaymentMethod();
    }

    @Then("the user should see an error message indicating that a payment method must be selected")
    public void verifyMandatoryPaymentMethodMessage() {
        Assert.assertTrue(checkoutPage.isMandatoryPaymentMethodMessageDisplayed());
    }
}