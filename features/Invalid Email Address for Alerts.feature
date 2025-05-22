Feature: Invalid Email Address for Alerts
@TC-7
Scenario: Verify that alerts are not sent if the customer's email address is invalid
Given a shipment order exists in the system with Order ID 54321
And the customer has subscribed to shipment alerts
And the customer's email address is "invalidemail@.com"
When I log in to the Dynamics 365 system with valid credentials
Then the dashboard should be displayed
When I navigate to the 'Orders' module
Then the Orders module should be displayed with a list of orders
When I select the order with ID 54321
Then the order details for order ID 54321 should be displayed
And the shipment status should be "Delivered"
When I update the shipment status to "Delivered"
Then the shipment status should be updated to "Delivered"
When I check the alert system for outgoing alerts
Then no alert should be sent due to the invalid email address
And an error should be logged indicating failure to send alert to "invalidemail@.com"