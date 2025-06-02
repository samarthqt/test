Feature: Verify Data Accuracy and Consistency in Order History
@TC-191
Scenario: User logs into their account and accesses the order history
Given the user is logged into their account with multiple past orders
When the user navigates to the 'Order History' section
Then the Order History page is displayed
@TC-191
Scenario: Verify all past orders are listed in order history
Given the user is on the Order History page
Then all past orders are accurately listed
@TC-191
Scenario: Verify the order date for a selected order
Given the user selects a random order from the Order History
Then the displayed order date matches the date in the order confirmation email
@TC-191
Scenario: Verify the order status for a selected order
Given the user selects a random order from the Order History
Then the order status is consistent with the status in the order confirmation email
@TC-191
Scenario: Verify the payment details for a selected order
Given the user selects a random order from the Order History
Then the payment details match those in the order confirmation email
@TC-191
Scenario: Verify the product details within a selected order
Given the user selects a random order from the Order History
Then the product details are consistent with those in the order confirmation email
@TC-191
Scenario: Verify the consistency of the total cost displayed for a selected order
Given the user selects a random order from the Order History
Then the total cost matches the amount in the order confirmation email
@TC-191
Scenario: Check for discrepancies in order history data
Given the user is on the Order History page
Then no discrepancies are found; data is accurate and consistent
@TC-191
Scenario: Verify accuracy of order history data after applying filters
Given the user applies filters in the Order History section
Then the filtered data remains accurate and consistent
@TC-191
Scenario: Check for missing orders in order history
Given the user is on the Order History page
Then all orders are present; no orders are missing
@TC-191
Scenario: Attempt to manipulate order history data through browser console
Given the user is on the Order History page
When the user attempts to manipulate data through the browser console
Then data manipulation is not possible; data integrity is maintained
@TC-191
Scenario: Verify accuracy of order history data after a system update
Given the system has been updated
When the user accesses the Order History section
Then data remains accurate and consistent post-update
@TC-191
Scenario: Log out and attempt to view order history
Given the user logs out of their account
When the user attempts to view the Order History
Then the user is redirected to the login page
@TC-191
Scenario: Verify accuracy of order history data on different devices
Given the user accesses the Order History section on different devices
Then data is accurate and consistent across all devices