Feature: Verify payment process is secured with SSL/TLS encryption
@TC-71
Scenario: Verify payment process using Credit Card is secured
Given User has items in the cart
And User is logged in
When User navigates to the checkout page
Then User should be directed to the checkout page with SSL/TLS encryption enabled
When User selects 'Credit Card' as the payment method
Then Credit Card option should be selected
When User enters credit card details
Then Credit card details should be entered securely
When User proceeds to payment
Then Payment process should initiate securely with credit card
And Payment should be confirmed securely and receipt should be generated
@TC-71
Scenario: Verify payment process using PayPal is secured
Given User has logged out and logged back in securely
When User navigates to the checkout page again
Then User should be directed to the checkout page with SSL/TLS encryption enabled
When User selects 'PayPal' as the payment method
Then PayPal option should be selected
When User enters PayPal account details
Then PayPal account details should be entered securely
When User proceeds to payment
Then Payment process should initiate securely with PayPal
And Payment should be confirmed securely and receipt should be generated
@TC-71
Scenario: Verify SSL/TLS encryption works across different browsers
Given User switches browser and repeats the test
Then SSL/TLS encryption should work across different browsers
@TC-71
Scenario: Verify transaction details are accurate and consistent
Given User has completed a transaction
When User checks for discrepancies in transaction details
Then Transaction details should be accurate and consistent
@TC-71
Scenario: Verify guest checkout is secured
Given User attempts to checkout using guest account
Then Guest account should complete checkout securely
@TC-71
Scenario: Ensure no console errors during secure payment processing
Given User is processing payment securely
Then No console errors should appear during the test execution