Feature: Instant Shipment Tracking Alert for Dispatch
@TC-3
Scenario: Verify instant alert is sent when shipment is dispatched
Given a shipment order exists in the system with Order ID 12345
And the customer has subscribed to shipment alerts
And the customer email is customer@example.com
When the user logs in to the Dynamics 365 system with valid credentials
Then the dashboard should be displayed
When the user navigates to the 'Orders' module
Then the Orders module should be displayed with a list of orders
When the user selects the order with ID 333
Then the order details for order ID 333 should be displayed
And the shipment status should be 'Shipped'
When the user updates the shipment status to 'Shipped'
Then the shipment status should be updated to 'Shipped'
When the user checks the alert system for outgoing alerts
Then an alert should be sent to customer@qualitest.com notifying them of the dispatch status
And the customer should receive an alert with the message: 'Your shipment has been shipped.'