Feature: Attempt Checkout with Out-of-Stock Item
@TC-162
Scenario: Verify user notification when attempting to proceed to checkout with an out-of-stock item
Given a user account with items added to the cart
When the user logs in to the retail application
Then the user successfully logs in
@TC-162
Scenario: Navigate to the cart page
Given the user has logged in
When the user navigates to the cart page
Then the cart page is displayed with items
@TC-162
Scenario: Check for out-of-stock items in the cart
Given the cart contains 3 out-of-stock items
When the user views the cart
Then out-of-stock items are clearly marked
@TC-162
Scenario: Click the 'Proceed to Checkout' button
Given the cart contains mixed in-stock and out-of-stock items
When the user clicks the 'Proceed to Checkout' button
Then the system checks item availability
@TC-162
Scenario: Verify notification for out-of-stock items
Given the cart contains out-of-stock items
When the user attempts to proceed to checkout
Then the user receives a notification indicating out-of-stock items
@TC-162
Scenario: Attempt to remove out-of-stock items from the cart
Given the cart contains out-of-stock items
When the user attempts to remove out-of-stock items from the cart
Then the items are successfully removed
@TC-162
Scenario: Try proceeding to checkout again
Given the cart no longer contains out-of-stock items
When the user tries proceeding to checkout again
Then the user is redirected to the checkout page without out-of-stock items
@TC-162
Scenario: Repeat steps with different combinations of in-stock and out-of-stock items
Given various combinations of in-stock and out-of-stock items in the cart
When the user repeats the checkout attempt
Then the notification for out-of-stock items remains consistent
@TC-162
Scenario: Verify checkout page does not list out-of-stock items
Given the user has removed out-of-stock items
When the user views the checkout page
Then out-of-stock items are not listed on the checkout page
@TC-162
Scenario: Check for any error messages during checkout attempt
Given the user attempts to checkout
When the system processes the checkout
Then no errors other than out-of-stock notification are displayed
@TC-162
Scenario: Test notification visibility on mobile devices
Given the user is using a mobile device
When the notification is displayed
Then the notification is visible and readable on mobile devices
@TC-162
Scenario: Test notification visibility on different browsers
Given various browsers are used
When the notification is displayed
Then the notification is visible and readable on all tested browsers
@TC-162
Scenario: Verify system allows adding in-stock items after removing out-of-stock ones
Given the user has removed out-of-stock items
When the user adds in-stock items
Then in-stock items can be added and proceed to checkout
@TC-162
Scenario: Ensure user can proceed to checkout with only in-stock items
Given the cart contains only in-stock items
When the user initiates the checkout process
Then the checkout process initiates successfully
@TC-162
Scenario: Verify system updates cart when stock status changes
Given the stock status changes
When the user views the cart
Then the cart reflects current stock status accurately