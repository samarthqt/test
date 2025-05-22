Feature: No Alert for Unsubscribed Customer
@TC-6
Scenario: Verify no alert is sent to unsubscribed customers
Given a shipment order exists in the system with Order ID 67890
And the customer has not subscribed to shipment alerts
And I am logged into the Dynamics 365 system with valid credentials
When I navigate to the 'Orders' module
And I select the order with ID 67890
And I update the shipment status to 'Dispatched'
Then no alert is sent to nonsubscriber@example.com
And no alert is received by nonsubscriber@example.com in their email inbox