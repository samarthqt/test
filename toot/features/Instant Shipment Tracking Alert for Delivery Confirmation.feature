Feature: Instant Shipment Tracking Alert for Delivery Confirmation
To verify that customers receive an instant alert when their shipment is delivered.
@TC-5
Scenario: Verify instant alert for shipment delivery confirmation
Given a shipment order exists in the system
And the customer has subscribed to shipment alerts
And the order ID is 12345
And the customer email is customer@example.com
When the user logs in to the Dynamics 365 system with valid credentials
Then the dashboard is displayed
When the user navigates to the 'Orders' module
Then the Orders module is displayed with a list of orders
When the user selects the order with ID 12345
Then the order details for order ID 12345 are displayed
And the shipment status is 'Delivered'
When the user updates the shipment status to 'Delivered'
Then the shipment status is updated to 'Delivered'
When the user checks the alert system for outgoing alerts
Then an alert is sent to customer@example.com notifying them of the delivery confirmation
And the customer receives an alert with the message: 'Your shipment has been delivered.'