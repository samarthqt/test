Feature: Instant Shipment Tracking Alert for Delivery Confirmation
@TC-5
Scenario: Verify instant alert for shipment delivery confirmation
Given a shipment order exists in the system with Order ID "12345"
And the customer has subscribed to shipment alerts
When the user logs in to the Dynamics 365 system with valid credentials
Then the dashboard is displayed
When the user navigates to the 'Orders' module
Then the Orders module is displayed with a list of orders
When the user selects the order with ID "12345"
Then the order details for order ID "12345" are displayed
When the user updates the shipment status to "Delivered"
Then the shipment status is updated to "Delivered"
When the user checks the alert system for outgoing alerts
Then an alert is sent to "customer@example.com" notifying them of the delivery confirmation
When the user verifies the alert received by the customer
Then the customer receives an alert with the message: "Your shipment has been delivered."