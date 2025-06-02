Feature: Instant Shipment Tracking Alert for Dispatch
@TC-3
Scenario: Verify instant alert when shipment is dispatched
Given a shipment order exists in the system with Order ID 12345
And the customer has subscribed to shipment alerts
And I am logged into the Dynamics 365 system with valid credentials
When I navigate to the 'Orders' module
Then the Orders module is displayed with a list of orders
When I select the order with ID 12345
Then the order details for order ID 12345 are displayed
And the shipment status is "Dispatched"
When I update the shipment status to "Dispatched"
Then the shipment status is updated to "Dispatched"
When I check the alert system for outgoing alerts
Then an alert is sent to customer@example.com notifying them of the dispatch status
And the customer receives an alert with the message: "Your shipment has been dispatched."