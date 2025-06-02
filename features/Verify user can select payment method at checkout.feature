Feature: Verify user can select payment method at checkout
To ensure users can successfully select a payment method, either credit card or PayPal, during checkout.
@TC-70
Scenario: User selects Credit Card as payment method
Given User is logged in
And User has items in the cart
When User navigates to the checkout page
Then User is directed to the checkout page
When User selects 'Credit Card' as the payment method
Then Credit Card option is selected
When User enters credit card details
Then Credit card details are entered successfully
And Credit Card Number is "4111111111111111"
When User proceeds to payment
Then Payment process initiates with credit card
And PayPal Account is "user@example.com"
Then Payment is confirmed and receipt is generated
And Billing Address is "123 Main St"
@TC-70
Scenario: User selects PayPal as payment method
Given User logs out and logs back in
When User navigates to the checkout page again
Then User is directed to the checkout page
When User selects 'PayPal' as the payment method
Then PayPal option is selected
When User enters PayPal account details
Then PayPal account details are entered successfully
When User proceeds to payment
Then Payment process initiates with PayPal
Then Payment is confirmed and receipt is generated
@TC-70
Scenario: Payment method selection across different browsers
Given User switches browser
When User repeats the test
Then Payment method selection should work across different browsers
@TC-70
Scenario: Verify transaction details accuracy
When User checks for any discrepancies in transaction details
Then Transaction details should be accurate and consistent
@TC-70
Scenario: Guest account payment method selection
When User attempts to checkout using guest account
Then Guest account should be able to select payment method
@TC-70
Scenario: Ensure no console errors during payment selection
When User performs payment selection
Then No console errors should appear during the test execution