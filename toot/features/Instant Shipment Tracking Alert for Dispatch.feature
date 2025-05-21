Feature: Instant Shipment Tracking Alert for Dispatch
@TC-3
Scenario: Verify that customers receive an instant alert when their shipment is dispatched
Given a shipment order exists in the system with Order ID 12345
And the customer has subscribed to shipment alerts
And I am logged into the Dynamics 365 system with valid credentials
When I navigate to the 'Orders' module
And I select the order with ID 12345
And I update the shipment status to 'Dispatched'
Then the shipment status is updated to 'Dispatched'
And an alert is sent to customer@example.com notifying them of the dispatch status
And the customer receives an alert with the message: 'Your shipment has been dispatched.'