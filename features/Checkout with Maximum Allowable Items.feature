Feature: Checkout with Maximum Allowable Items
@TC-342
Scenario: Test checkout process with maximum allowable items in the cart to assess system performance
Given the user is logged in
When the user navigates to the cart page
Then the cart page is displayed with maximum allowable items
@TC-342
Scenario: Verify the number of items in the cart
Given the cart is filled with maximum allowable items
When the user checks the number of items in the cart
Then the cart displays the maximum allowable number of items
@TC-342
Scenario: Proceed to checkout
Given the user is on the cart page with maximum allowable items
When the user clicks on 'Proceed to Checkout' button
Then the checkout page is displayed
@TC-342
Scenario: Enter valid shipping information
Given the user is on the checkout page
When the user enters valid shipping information
Then the shipping information is accepted
@TC-342
Scenario: Select payment method and enter valid payment details
Given the user is on the checkout page
When the user selects a payment method and enters valid payment details
Then the payment details are accepted
@TC-342
Scenario: Process payment
Given the user has entered valid payment details
When the user clicks on 'Pay Now' button
Then the payment is processed without performance issues
@TC-342
Scenario: Verify order confirmation message
Given the payment is processed
When the user checks for the order confirmation message
Then the order confirmation message is displayed with order details
@TC-342
Scenario: Check order summary in user account
Given the order is confirmed
When the user checks the order summary in the user account
Then the order summary matches the transaction details
@TC-342
Scenario: Verify system performance metrics during checkout
Given the checkout process is completed
When the user verifies system performance metrics
Then the system performance metrics are within acceptable limits
@TC-342
Scenario: Check email for order confirmation
Given the order is confirmed
When the user checks their email for order confirmation
Then the order confirmation email is received with correct details
@TC-342
Scenario: Verify order status in user dashboard
Given the order is confirmed
When the user checks the order status in the user dashboard
Then the order status is displayed as 'Processing' or 'Completed'
@TC-342
Scenario: Check delivery address details in order summary
Given the order is confirmed
When the user checks the delivery address details in the order summary
Then the correct delivery address is displayed
@TC-342
Scenario: Verify loyalty points or discounts applied correctly
Given the order is confirmed
When the user verifies if loyalty points or discounts were applied
Then the loyalty points/discounts are correctly applied to the order
@TC-342
Scenario: Ensure 'Print Receipt' option is available
Given the order is confirmed
When the user looks for the 'Print Receipt' option
Then the 'Print Receipt' option is available and functional
@TC-342
Scenario: Log out and log back in to verify order persistence
Given the order is confirmed
When the user logs out and logs back in
Then the order details persist after logging back in