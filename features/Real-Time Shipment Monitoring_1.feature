Feature: Real-Time Shipment Monitoring
@TC-12
Scenario: Confirm that shipment details are updated in real-time for the customer
Given the user has a valid customer account with Customer ID "CUST54321"
And the shipment "SHIP09876" is in transit
When the user logs in to the customer account using valid credentials
Then the user is successfully logged in to their account
When the user navigates to the 'Track Shipment' section
Then the 'Track Shipment' section is displayed
When the user enters the Shipment ID "SHIP09876" in the search bar
Then shipment details are displayed for "SHIP09876"
And the current location of the shipment is displayed as "Distribution Center B"
And the estimated delivery time is displayed as "3 hours"
When the user waits for 5 minutes and refreshes the page
Then any changes in location or delivery time are updated in real-time
When the user logs out of the customer account
Then the user is successfully logged out