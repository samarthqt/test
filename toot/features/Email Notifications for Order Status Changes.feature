Feature: Email Notifications for Order Status Changes
""
Background:
Given the user is logged into the order management system
And the user has valid email notification settings configured
""
Scenario: Send email notification when order status changes to shipped
"    Given an order with ID ""12345"" is in the system"
"    When the order status is updated to ""shipped"""
Then an email notification should be sent to the customer's registered email address
"    And the email subject should be ""Your order #12345 has been shipped"""
And the email body should contain the shipping details and tracking information
""
Scenario: Send email notification when order status changes to delivered
"    Given an order with ID ""67890"" is in the system"
"    When the order status is updated to ""delivered"""
Then an email notification should be sent to the customer's registered email address
"    And the email subject should be ""Your order #67890 has been delivered"""
And the email body should contain the delivery confirmation and feedback request
""
Scenario: Do not send email notification for non-status changes
"    Given an order with ID ""11223"" is in the system"
"    When the order status is updated to ""processing"""
Then no email notification should be sent to the customer
""
Scenario: Send email notification when order status changes to cancelled
"    Given an order with ID ""44556"" is in the system"
"    When the order status is updated to ""cancelled"""
Then an email notification should be sent to the customer's registered email address
"    And the email subject should be ""Your order #44556 has been cancelled"""
And the email body should contain the cancellation details and refund information
""
Scenario: Handle email sending failure
"    Given an order with ID ""77889"" is in the system"
And the email server is down
"    When the order status is updated to ""shipped"""
Then the system should log an error indicating the email could not be sent
And the user should be notified of the failure to send the email notification
""
Scenario: Verify email content for status change to shipped
"    Given an order with ID ""33445"" is in the system"
"    When the order status is updated to ""shipped"""
Then the email notification should be sent
And the email should contain the correct order ID, status, and customer details
""
Scenario: Verify email content for status change to delivered
"    Given an order with ID ""55667"" is in the system"
"    When the order status is updated to ""delivered"""
Then the email notification should be sent
And the email should contain the correct order ID, status, and delivery details
```
```gherkin
TCID:16