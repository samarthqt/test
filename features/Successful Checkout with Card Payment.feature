Feature: Successful Checkout with Card Payment
@TC-338
Scenario: Verify successful checkout process using card payment
Given the user is logged in
When the user navigates to the cart page
Then the cart page is displayed with selected products
And products are available in the cart
@TC-338
Scenario: Verify the products listed in the cart
Given the user is on the cart page
Then products in the cart match the selected items
@TC-338
Scenario: Proceed to checkout
Given the user is on the cart page
When the user clicks on 'Proceed to Checkout' button
Then the checkout page is displayed
@TC-338
Scenario: Select Credit Card payment method
Given the user is on the checkout page
When the user selects 'Credit Card' as the payment method
Then the Credit Card payment section is displayed
@TC-338
Scenario: Enter credit card details
Given the user is on the Credit Card payment section
When the user enters valid credit card details
Then the credit card details are accepted
@TC-338
Scenario: Pay and confirm order
Given the user has entered valid credit card details
When the user clicks on 'Pay Now' button
Then the payment is processed
And the confirmation page is displayed
@TC-338
Scenario: Verify order confirmation message
Given the user is on the confirmation page
Then the order confirmation message is displayed with order details
@TC-338
Scenario: Check order summary in user account
Given the user is logged in
When the user checks the order summary in the user account
Then the order summary matches the transaction details
@TC-338
Scenario: Verify payment transaction in payment gateway
Given the payment has been processed
When the user verifies the payment transaction in the payment gateway
Then the transaction is recorded and successful
@TC-338
Scenario: Check email for order confirmation
Given the order has been confirmed
When the user checks email for order confirmation
Then the order confirmation email is received with correct details
@TC-338
Scenario: Verify order status in user dashboard
Given the user is logged in
When the user verifies the order status in the user dashboard
Then the order status is displayed as 'Processing' or 'Completed'
@TC-338
Scenario: Check delivery address details in order summary
Given the order has been placed
When the user checks the delivery address details in the order summary
Then the correct delivery address is displayed
@TC-338
Scenario: Verify loyalty points or discounts applied
Given the order has been placed
When the user verifies if the loyalty points or discounts were applied correctly
Then loyalty points/discounts are correctly applied to the order
@TC-338
Scenario: Ensure 'Print Receipt' option is available
Given the order has been confirmed
When the user checks for 'Print Receipt' option
Then 'Print Receipt' option is available and functional
@TC-338
Scenario: Verify order persistence after logout
Given the user is logged in
When the user logs out and logs back in
Then order details persist after logging back in