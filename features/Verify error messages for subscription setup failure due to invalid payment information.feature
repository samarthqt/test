Feature: Verify error messages for subscription setup failure due to invalid payment information
@TC-367
Scenario: Navigate to the subscription setup page
Given the user is logged in with User ID: 33445
When the user navigates to the subscription setup page
Then the user is directed to the subscription setup page displaying available options
@TC-367
Scenario: Select a product for subscription setup
Given the user is on the subscription setup page
When the user selects a product for subscription setup
Then product details are displayed including subscription options
@TC-367
Scenario: Choose a delivery frequency
Given the user has selected a product for subscription setup
When the user chooses a delivery frequency of weekly
Then the selected frequency is highlighted and ready for confirmation
@TC-367
Scenario: Enter invalid payment information
Given the user is on the subscription setup page
When the user enters invalid payment information such as expired Credit Card details
Then the system detects invalid payment information and displays an error message
@TC-367
Scenario: Attempt to confirm the subscription setup
Given the user has entered invalid payment information
When the user attempts to confirm the subscription setup
Then the subscription setup fails and an error message is displayed indicating payment issue
@TC-367
Scenario: Check email for subscription failure notification
Given the subscription setup has failed due to payment issue
When the user checks their email
Then an email is received indicating subscription setup failure due to payment issue
@TC-367
Scenario: Verify error message details in user account
Given the subscription setup has failed
When the user checks error message details in their account
Then error message details are correctly listed under user account
@TC-367
Scenario: Attempt to rectify payment information
Given the user has invalid payment information
When the user attempts to update payment information
Then the user is able to update payment information successfully
@TC-367
Scenario: Verify system response after payment information rectification
Given the user has rectified payment information
When the user attempts the subscription setup again
Then the subscription setup is processed successfully with updated payment information
@TC-367
Scenario: Check for any subscription setup conflicts post rectification
Given the subscription setup is processed successfully
When the user checks for any subscription setup conflicts
Then no conflicts are found; setup is clear
@TC-367
Scenario: Verify notification settings for subscription setup issues
Given the user wants to manage notifications for subscription setup issues
When the user attempts to enable or disable notifications
Then the user can enable/disable notifications successfully
@TC-367
Scenario: Attempt subscription setup with another invalid payment method
Given the user is on the subscription setup page
When the user attempts subscription setup with another invalid payment method
Then an error message is displayed indicating payment method issue
@TC-367
Scenario: Check system response to repeated subscription setup failures
Given the user has attempted subscription setup multiple times with invalid payment methods
When the user checks system response
Then the system continues to display error messages without processing setup
@TC-367
Scenario: Verify subscription renewal process post payment rectification
Given the user has rectified payment information
When the subscription renewal process is initiated
Then the subscription renews automatically as per schedule with updated payment
@TC-367
Scenario: Attempt to setup subscription with invalid payment during renewal
Given the subscription is due for renewal
When the user attempts to setup subscription with invalid payment during renewal
Then the subscription setup fails and an error message is displayed indicating payment issue