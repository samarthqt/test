Feature: Instant Shipment Tracking Alert for In-Transit
@TC-4
Scenario: Verify instant alert for shipment status change to 'In Transit'
Given a shipment order exists in the system with Order ID "12345"
And the customer has subscribed to shipment alerts
When the user logs in to the Dynamics 365 system with valid credentials
Then the dashboard is displayed
When the user navigates to the 'Orders' module
Then the Orders module is displayed with a list of orders
When the user selects the order with ID "12345"
Then the order details for order ID "12345" are displayed
And the shipment status is "In Transit"
When the user updates the shipment status to "In Transit"
Then the shipment status is updated to "In Transit"
When the alert system is checked for outgoing alerts
Then an alert is sent to "customer@example.com" notifying them of the 'In Transit' status
When the alert received by the customer is verified
Then the customer receives an alert with the message: "Your shipment is now in transit."