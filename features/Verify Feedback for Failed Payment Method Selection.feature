Feature: Verify Feedback for Failed Payment Method Selection
@TC-169
Scenario: Verify feedback for invalid credit card details during payment method selection
Given User is logged into the application
And User navigates to the shopping cart page
When User clicks on the 'Proceed to Checkout' button
And User selects 'Credit Card' as the payment method
And User enters invalid credit card details
Then System displays an error message indicating invalid credit card details
@TC-169
Scenario: Verify feedback for expired PayPal account during payment method selection
Given User is logged into the application
And User navigates to the shopping cart page
When User clicks on the 'Proceed to Checkout' button
And User selects 'PayPal' as the payment method
And User attempts to use an expired PayPal account
Then System displays an error message indicating account expiration
@TC-169
Scenario: Verify feedback for depleted Gift Card balance during payment method selection
Given User is logged into the application
And User navigates to the shopping cart page
When User clicks on the 'Proceed to Checkout' button
And User selects 'Gift Card' as the payment method
And User attempts to use a Gift Card with depleted balance
Then System displays an error message indicating insufficient balance
@TC-169
Scenario: Verify presence of retry options for failed transactions
Given User is logged into the application
And User navigates to the shopping cart page
When User clicks on the 'Proceed to Checkout' button
Then System provides options to retry or select a different payment method
@TC-169
Scenario: Log out from the user account
Given User is logged into the application
When User logs out from the user account
Then User is logged out successfully