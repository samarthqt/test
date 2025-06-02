Feature: Instant Shipment Tracking Alert for Delivery Confirmation
@TC-5
Scenario: Verify instant alert for shipment delivery confirmation
Given a customer has subscribed to shipment alerts
And a shipment order with ID 12345 exists in the system
When the user logs in to the Dynamics 365 system with valid credentials
Then the user is logged in and the dashboard is displayed
When the user navigates to the 'Orders' module
Then the Orders module is displayed with a list of orders
When the user selects the order with ID 12345
Then the order details for order ID 12345 are displayed
When the user updates the shipment status to 'Delivered'
Then the shipment status is updated to 'Delivered'
When the user checks the alert system for outgoing alerts
Then an alert is sent to customer@example.com notifying them of the delivery confirmation
When the customer verifies the alert received
Then the customer receives an alert with the message: 'Your shipment has been delivered.'