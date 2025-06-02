Feature: Checkout with Maximum Cart Items
@TC-6
Scenario: Verify the checkout process with maximum number of items allowed in the cart
Given the user is logged in
And the user navigates to the cart page
Then the cart page displays 50 items with IDs ranging from 201 to 250
And the cart contains the maximum allowed number of items
@TC-6
Scenario: Verify the total number of items in the cart
Given the user is on the cart page
Then the cart correctly lists 50 items
And the item IDs range from 201 to 250
@TC-6
Scenario: Proceed to checkout
Given the user is on the cart page with 50 items
When the user clicks on the 'Proceed to Checkout' button
Then the user is redirected to the checkout page
@TC-6
Scenario: Enter valid shipping information
Given the user is on the checkout page
When the user enters valid shipping information
Then the shipping information is accepted without errors
@TC-6
Scenario: Enter valid billing information
Given the user is on the checkout page
When the user enters valid billing information
Then the billing information is accepted without errors
@TC-6
Scenario: Review order summary and total cost
Given the user has entered valid shipping and billing information
When the user reviews the order summary
Then the order summary displays all 50 items and correct total cost
@TC-6
Scenario: Confirm the order
Given the user has reviewed the order summary
When the user clicks on 'Confirm Order'
Then the order is successfully confirmed
@TC-6
Scenario: Verify the confirmation message
Given the order is confirmed
Then the confirmation message reads: 'Your order has been placed successfully.'
@TC-6
Scenario: Check email for order confirmation
Given the order is confirmed
Then the user receives an order confirmation email with correct details
@TC-6
Scenario: Verify the order appears in the user's order history
Given the order is confirmed
Then the order is listed in the user's order history with correct details
@TC-6
Scenario: Check the payment method used
Given the order is confirmed
Then the payment method is correctly recorded
@TC-6
Scenario: Verify the cart is emptied post-checkout
Given the order is confirmed
Then the cart is empty after successful checkout
@TC-6
Scenario: Attempt to add more items to the cart post-checkout
Given the cart is empty post-checkout
When the user attempts to add more items to the cart
Then items can be added to the cart again
@TC-6
Scenario: Review any shipping tracking information provided
Given the order is confirmed
Then the shipping tracking information is available and accurate
@TC-6
Scenario: Check for any system performance issues during checkout
Given the user is checking out
Then the system performs efficiently without lag