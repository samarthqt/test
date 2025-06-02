Feature: Verify Order Confirmation Notification Post-Purchase
@TC-171
Scenario: Complete a purchase transaction
Given the user is logged into the application
When the user completes a purchase transaction
Then the purchase transaction is completed successfully
And the user has completed a purchase
@TC-171
Scenario: Verify receipt of an order confirmation email
Given the user's email is "user@example.com"
When the purchase transaction is completed
Then the user receives an order confirmation email with correct order details
@TC-171
Scenario: Verify receipt of an order confirmation SMS
Given the user's phone number is "+1234567890"
When the purchase transaction is completed
Then the user receives an order confirmation SMS with correct order details
@TC-171
Scenario: Check content of the order confirmation email
Given the user has received an order confirmation email
Then the email contains order ID, product details, and total amount
@TC-171
Scenario: Check content of the order confirmation SMS
Given the user has received an order confirmation SMS
Then the SMS contains order ID and total amount
@TC-171
Scenario: Verify timeliness of order confirmation notifications
Given the user has completed a purchase
Then notifications are received immediately after purchase
@TC-171
Scenario: Log out from the user account
Given the user is logged into the application
When the user logs out from the account
Then the user is logged out successfully