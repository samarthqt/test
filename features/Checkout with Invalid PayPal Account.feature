Feature: Checkout with Invalid PayPal Account
@TC-341
Scenario: Attempt checkout with invalid PayPal account and verify error handling
Given the user is logged in
When the user navigates to the cart page
Then the cart page is displayed with selected products
And products are available in the cart
@TC-341
Scenario: Verify products listed in the cart
Given the user is on the cart page
Then products in the cart match the selected items
@TC-341
Scenario: Proceed to checkout
Given the user is on the cart page
When the user clicks on 'Proceed to Checkout' button
Then the checkout page is displayed
@TC-341
Scenario: Select PayPal as payment method
Given the user is on the checkout page
When the user selects 'PayPal' as the payment method
Then the PayPal payment section is displayed
@TC-341
Scenario: Enter invalid PayPal email
Given the PayPal payment section is displayed
When the user enters an invalid PayPal email
Then the system displays an error message for invalid PayPal email
@TC-341
Scenario: Attempt PayPal login with invalid email
Given the user has entered an invalid PayPal email
When the user attempts to log in to PayPal
Then PayPal login fails with an error message
@TC-341
Scenario: Enter PayPal account with insufficient funds
Given the PayPal payment section is displayed
When the user enters a PayPal account with insufficient funds
Then the system displays an error message for insufficient funds
@TC-341
Scenario: Attempt to proceed with payment
Given the user has entered a PayPal account with insufficient funds
When the user attempts to proceed with payment
Then payment is not processed, and an error message is displayed
@TC-341
Scenario: Verify no order is created
Given the payment was not processed
Then no order is created in the system
@TC-341
Scenario: Check email for order confirmation
Given no order is created in the system
Then no order confirmation email is received
@TC-341
Scenario: Ensure cart retains the products
Given the payment was not processed
Then products remain in the cart for future checkout attempts
@TC-341
Scenario: Verify cart persistence after logging out and back in
Given the user logs out
When the user logs back in
Then cart contents persist after logging back in
@TC-341
Scenario: Retry checkout with different payment method
Given the payment was not processed
When the user retries checkout with a different payment method
Then the user is able to retry checkout successfully
@TC-341
Scenario: Check for transaction attempts in PayPal account
Given the payment was not processed
Then no transaction is recorded in the PayPal account
@TC-341
Scenario: Ensure system logs the error for audit purposes
Given the payment was not processed
Then the error is logged in the system for auditing