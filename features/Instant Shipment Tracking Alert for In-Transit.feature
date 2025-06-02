Feature: Instant Shipment Tracking Alert for In-Transit
@TC-4
Scenario: Verify that customers receive an instant alert when their shipment status changes to 'In Transit'
Given a shipment order exists in the system
And the customer has subscribed to shipment alerts
And the user is logged into the Dynamics 365 system with valid credentials
When the user navigates to the 'Orders' module
And selects the order with ID 12345
And updates the shipment status to 'In Transit'
Then the alert system sends an alert to customer@example.com notifying them of the 'In Transit' status
And the customer receives an alert with the message: 'Your shipment is now in transit.'