Feature: No Alert for Unsubscribed Customer
@TC-6
Scenario: Verify no alert is sent to unsubscribed customers
Given a shipment order exists in the system with Order ID 67890
And the customer with email nonsubscriber@example.com has not subscribed to shipment alerts
When I log in to the Dynamics 365 system with valid credentials
Then the dashboard is displayed
And I navigate to the 'Orders' module
Then the Orders module is displayed with a list of orders
When I select the order with ID 67890
Then the order details for order ID 67890 are displayed
And the shipment status is 'Dispatched'
When I update the shipment status to 'Dispatched'
Then the shipment status is updated to 'Dispatched'
And I check the alert system for outgoing alerts
Then no alert is sent to nonsubscriber@example.com
And I verify the customer's email inbox
Then no alert is received by nonsubscriber@example.com