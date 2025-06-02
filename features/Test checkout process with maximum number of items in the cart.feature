Feature: Test checkout process with maximum number of items in the cart
@TC-271
Scenario: Ensure the checkout process works correctly with the maximum number of items allowed in the cart
Given the user has access to the account
When the user logs into the account
Then the user is logged into the account
And the cart contains the maximum allowed items
@TC-271
Scenario: Add maximum number of items to the shopping cart
When the user adds the maximum number of items allowed to the shopping cart
Then the maximum number of items are added to the cart
@TC-271
Scenario: Navigate to the shopping cart
When the user navigates to the shopping cart
Then the shopping cart is displayed with maximum items
@TC-271
Scenario: Proceed to checkout
When the user proceeds to checkout
Then the checkout page is displayed
@TC-271
Scenario: Enter valid shipping address details
When the user enters valid shipping address details
Then the shipping address details are entered correctly
@TC-271
Scenario: Enter valid billing information
When the user enters valid billing information
Then the billing information is entered correctly
@TC-271
Scenario: Select payment method and enter payment details
When the user selects payment method and enters payment details
Then the payment method and details are entered correctly
@TC-271
Scenario: Review order summary and verify total price
When the user reviews order summary and verifies total price
Then the order summary and total price are displayed correctly
@TC-271
Scenario: Agree to terms and conditions
When the user agrees to terms and conditions
Then the terms and conditions are agreed to
@TC-271
Scenario: Place the order
When the user clicks 'Place Order' button
Then the order is placed successfully
@TC-271
Scenario: Verify order confirmation is displayed
When the user verifies order confirmation
Then the order confirmation is displayed with order details
@TC-271
Scenario: Check email for order confirmation receipt
When the user checks email for order confirmation receipt
Then the order confirmation receipt is received via email
@TC-271
Scenario: Verify order details in the user account order history
When the user verifies order details in the user account order history
Then the order details are correctly displayed in order history
@TC-271
Scenario: Check if the cart is empty after checkout
When the user checks if the cart is empty after checkout
Then the shopping cart is empty after successful checkout
@TC-271
Scenario: Attempt to add more items to the cart after checkout
When the user attempts to add more items to the cart after checkout
Then items can be added to the cart after checkout