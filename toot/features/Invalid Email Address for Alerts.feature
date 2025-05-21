Feature: Invalid Email Address for Alerts
To verify that alerts are not sent if the customer's email address is invalid.
@TC-7
Scenario: Alerts are not sent for invalid email address
Given a shipment order exists in the system
And I log in to the Dynamics 365 system with valid credentials
Then the user is logged in and the dashboard is displayed
And the customer has subscribed to shipment alerts
When I navigate to the 'Orders' module
Then the orders module is displayed with a list of orders
And the customer's email address is invalid (invalidemail@.com)
When I select the order with ID 54321
Then the order details for order ID 54321 are displayed
And the shipment status is "Delivered"
When I update the shipment status to "Delivered"
Then the shipment status is updated to "Delivered"
When I check the alert system for outgoing alerts
Then no alert is sent due to the invalid email address
When I verify the error logs for alert sending failures
Then an error is logged indicating failure to send alert to invalidemail@.com