Feature: Test Checkout Process Under High Load
@TC-163
Scenario: Simulate high user traffic on the retail application
Given the application is under simulated high traffic conditions
When a user account with items added to the cart is accessed
Then the application handles increased load without crashing
@TC-163
Scenario: Login to the application under high load
Given a user account with items added to the cart
When the user attempts to log in
Then the user successfully logs in under high load
@TC-163
Scenario: Navigate to the cart page
Given a user is logged in with items in the cart
When the user navigates to the cart page
Then the cart page loads within acceptable time limits
@TC-163
Scenario: Click 'Proceed to Checkout'
Given a user is on the cart page with the maximum allowed items
When the user clicks 'Proceed to Checkout'
Then the system processes the checkout request without delay
@TC-163
Scenario: Verify checkout page loads correctly
Given the user has proceeded to the checkout
When the checkout page loads
Then the checkout page displays all items and details correctly
@TC-163
Scenario: Check response time for checkout page loading
Given the user is on the checkout page
When the page is loading
Then the response time remains within acceptable limits
@TC-163
Scenario: Attempt payment processing
Given the user is on the checkout page
When the user attempts payment processing
Then payment is processed successfully despite high load
@TC-163
Scenario: Verify order confirmation is received
Given the payment is processed successfully
When the order confirmation is generated
Then the user receives confirmation without delay
@TC-163
Scenario Outline: Repeat checkout process with different cart sizes
Given the application is under simulated high traffic conditions
When the user performs steps 1 to 8 with a cart containing <cart_size> items
Then the performance remains consistent across different cart sizes
Examples:
| cart_size |
| 10        |
| 20        |
| 5         |
@TC-163
Scenario: Monitor server resource utilization during checkout
Given the application is processing multiple checkouts
When server resource utilization is monitored
Then resource usage remains within expected thresholds
@TC-163
Scenario: Check for any error messages during checkout
Given the checkout process is ongoing
When the system is monitored for errors
Then no errors or system crashes occur
@TC-163
Scenario: Test checkout process on mobile devices under high load
Given the application is accessed via mobile devices under high load
When the user attempts checkout
Then the mobile checkout process functions properly
@TC-163
Scenario: Test checkout process on different browsers under high load
Given the application is accessed via different browsers under high load
When the user attempts checkout
Then the checkout process functions properly across all tested browsers
@TC-163
Scenario: Verify system stability during peak checkout times
Given the application is under peak checkout times
When system stability is monitored
Then the system remains stable without performance degradation
@TC-163
Scenario: Ensure order details are accurately recorded
Given the checkout process is completed
When order details are reviewed
Then order details match the items selected during checkout