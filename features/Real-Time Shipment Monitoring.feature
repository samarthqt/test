Feature: Real-Time Shipment Monitoring
@TC-11
Scenario: Verify the system's ability to allow customers to monitor their shipments in real-time
Given the user has a valid customer account with Customer ID "CUST12345"
And the shipment is in transit
When the user logs in to the customer account using valid credentials
Then the user is successfully logged in to their account
When the user navigates to the 'Track Shipment' section
Then the 'Track Shipment' section is displayed
When the user enters the Shipment ID "SHIP67890" in the search bar
Then shipment details are displayed for "SHIP67890"
And the current location of the shipment is displayed as "Warehouse A"
And the estimated delivery time is displayed as "2 hours"
When the user refreshes the page
Then any changes in location or delivery time are updated in real-time
When the user logs out of the customer account
Then the user is successfully logged out