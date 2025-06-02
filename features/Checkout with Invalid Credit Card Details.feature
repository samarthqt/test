Feature: Checkout with Invalid Credit Card Details
Attempt checkout with invalid credit card details and verify error handling.
@TC-340
Scenario: Attempt checkout with invalid credit card number
Given the user is logged in
And navigates to the cart page
Then the cart page is displayed with selected products
When the user verifies the products listed in the cart
Then products in the cart match the selected items
When the user clicks on 'Proceed to Checkout' button
Then the checkout page is displayed
When the user selects 'Credit Card' as the payment method
Then the Credit Card payment section is displayed
When the user enters an invalid credit card number
Then the system displays an error message for invalid card number
When the user attempts to proceed with payment
Then payment is not processed, and error message is displayed
And no order is created in the system
And no order confirmation email is received
And the cart retains the products for future checkout attempts
When the user logs out and logs back in
Then cart contents persist after logging back in
When the user retries with a different payment method
Then the user is able to retry checkout with a different payment method
And no transaction is recorded in the payment gateway
And the system logs the error for audit purposes
@TC-340
Scenario: Attempt checkout with expired credit card
Given the user is logged in
And navigates to the cart page
Then the cart page is displayed with selected products
When the user verifies the products listed in the cart
Then products in the cart match the selected items
When the user clicks on 'Proceed to Checkout' button
Then the checkout page is displayed
When the user selects 'Credit Card' as the payment method
Then the Credit Card payment section is displayed
When the user enters expired credit card details
Then the system displays an error message for expired card
When the user attempts to proceed with payment
Then payment is not processed, and error message is displayed
And no order is created in the system
And no order confirmation email is received
And the cart retains the products for future checkout attempts
When the user logs out and logs back in
Then cart contents persist after logging back in
When the user retries with a different payment method
Then the user is able to retry checkout with a different payment method
And no transaction is recorded in the payment gateway
And the system logs the error for audit purposes
@TC-340
Scenario: Attempt checkout with incorrect CVV
Given the user is logged in
And navigates to the cart page
Then the cart page is displayed with selected products
When the user verifies the products listed in the cart
Then products in the cart match the selected items
When the user clicks on 'Proceed to Checkout' button
Then the checkout page is displayed
When the user selects 'Credit Card' as the payment method
Then the Credit Card payment section is displayed
When the user enters incorrect CVV number
Then the system displays an error message for incorrect CVV
When the user attempts to proceed with payment
Then payment is not processed, and error message is displayed
And no order is created in the system
And no order confirmation email is received
And the cart retains the products for future checkout attempts
When the user logs out and logs back in
Then cart contents persist after logging back in
When the user retries with a different payment method
Then the user is able to retry checkout with a different payment method
And no transaction is recorded in the payment gateway
And the system logs the error for audit purposes