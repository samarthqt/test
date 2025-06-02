Feature: Test checkout process with maximum number of items allowed in the cart
Validate the checkout process when the cart contains the maximum number of items.
@TC-305
Scenario: Log in to the e-commerce website using valid credentials
Given a user account with User ID "U12345" and password "********"
When the user logs in to the e-commerce website
Then the user should be successfully logged in and redirected to the homepage
@TC-305
Scenario: Navigate to the product catalog
Given the user is logged in
When the user navigates to the product catalog
Then the product catalog should be displayed with various items available for purchase
@TC-305
Scenario: Add the maximum number of items to the cart
Given the user is viewing the product catalog
When the user adds 50 items to the cart
Then all selected items should be added to the cart successfully
@TC-305
Scenario: Verify the cart displays the correct number of items
Given the user has added 50 items to the cart
When the user views the cart
Then the cart should display 50 items with correct details like name, price, and quantity
@TC-305
Scenario: Proceed to checkout
Given the cart contains 50 items
When the user proceeds to checkout
Then the user should be directed to the checkout page with all items listed
@TC-305
Scenario: Enter valid shipping and billing information
Given the user is on the checkout page
When the user enters valid shipping and billing information
Then the shipping and billing information should be accepted without errors
@TC-305
Scenario: Select a payment method and enter valid payment details
Given the user has entered shipping and billing information
When the user selects a payment method and enters valid payment details
Then the payment details should be processed successfully
@TC-305
Scenario: Confirm the order
Given the payment details are processed successfully
When the user confirms the order
Then order confirmation should be displayed with a unique order ID
@TC-305
Scenario: Verify the order summary in the user account
Given the order is confirmed
When the user views the order summary in their account
Then the order summary should reflect the correct items, quantities, and total amount
@TC-305
Scenario: Check for email confirmation of the order
Given the order is confirmed
When the user checks their email
Then the user should receive an email confirmation with order details
@TC-305
Scenario: Attempt to add one more item to the cart
Given the cart contains the maximum number of items
When the user attempts to add one more item to the cart
Then the system should prevent adding more than the maximum limit and display a relevant error message
@TC-305
Scenario: Log out from the website
Given the user is logged in
When the user logs out from the website
Then the user should be logged out successfully
@TC-305
Scenario: Log back in and verify the cart contents
Given the user has logged out
When the user logs back in
Then the cart should retain the items added before logout
@TC-305
Scenario: Check order history for the placed order
Given the user is logged in
When the user checks the order history
Then the order history should display the recently placed order with correct status
@TC-305
Scenario: Ensure the website's responsiveness and performance
Given the user is interacting with the website
When the user performs actions during the checkout process
Then the website should perform efficiently without delays or errors