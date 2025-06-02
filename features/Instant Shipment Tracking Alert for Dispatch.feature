Feature: Instant Shipment Tracking Alert for Dispatch
@TC-3
Scenario: Verify instant alert is received when shipment is dispatched
Given a shipment order with ID 12345 exists in the system
And the customer has subscribed to shipment alerts
When the user logs in to the Dynamics 365 system with valid credentials
Then the dashboard is displayed
And the user navigates to the 'Orders' module
Then the orders module is displayed with a list of orders
When the user selects the order with ID 12345
Then order details for order ID 12345 are displayed
And the shipment status is 'Dispatched'
When the user updates the shipment status to 'Dispatched'
Then the shipment status is updated to 'Dispatched'
And the alert system sends an alert to customer@example.com notifying them of the dispatch status
Then the customer receives an alert with the message: 'Your shipment has been dispatched.'