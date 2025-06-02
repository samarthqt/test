Feature: No Alert for Unsubscribed Customer
In order to ensure no alerts are sent to customers who have not subscribed to shipment alerts
As a system user
I want to verify that no alert is sent to unsubscribed customers when shipment status is updated
@TC-6
Scenario: Verify no alert is sent to unsubscribed customer
Given I am logged into the Dynamics 365 system with valid credentials
And a shipment order with ID 67890 exists in the system
And the customer has not subscribed to shipment alerts
When I navigate to the 'Orders' module
And I select the order with ID 67890
And I update the shipment status to 'Dispatched'
Then no alert should be sent to nonsubscriber@example.com
And no alert should be received by nonsubscriber@example.com in their email inbox