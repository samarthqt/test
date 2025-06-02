Feature: Invalid Email Address for Alerts
In order to ensure alerts are not sent to invalid email addresses
As a system administrator
I want to verify that alerts are not sent if the customer's email address is invalid
@TC-7
Scenario: Alerts are not sent for invalid email address
Given a user is logged in to the Dynamics 365 system with valid credentials
And the dashboard is displayed
And a shipment order with ID 54321 exists
And the customer has subscribed to shipment alerts
When the user navigates to the 'Orders' module
And the orders module is displayed with a list of orders
And the customer's email address is invalid as "invalidemail@.com"
Then the user selects the order with ID 54321
And the order details for order ID 54321 are displayed
And the shipment status is 'Delivered'
When the user updates the shipment status to 'Delivered'
Then the shipment status is updated to 'Delivered'
And the alert system is checked for outgoing alerts
Then no alert is sent due to invalid email address
And the error logs are verified for alert sending failures
Then an error is logged indicating failure to send alert to "invalidemail@.com"