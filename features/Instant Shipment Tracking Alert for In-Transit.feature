Feature: Instant Shipment Tracking Alert for In-Transit
In order to ensure customers are promptly informed about the status of their shipments
As a user of Dynamics 365
I want to verify that customers receive an instant alert when their shipment status changes to 'In Transit'
@TC-4
Scenario: Verify instant alert for 'In Transit' shipment status
Given a shipment order with ID 12345 exists in the system
And the customer has subscribed to shipment alerts
When I log in to the Dynamics 365 system with valid credentials
Then the dashboard is displayed
When I navigate to the 'Orders' module
Then the Orders module is displayed with a list of orders
When I select the order with ID 12345
Then order details for order ID 12345 are displayed
When I update the shipment status to 'In Transit'
Then the shipment status is updated to 'In Transit'
When I check the alert system for outgoing alerts
Then an alert is sent to customer@example.com notifying them of the 'In Transit' status
When I verify the alert received by the customer
Then the customer receives an alert with the message: 'Your shipment is now in transit'