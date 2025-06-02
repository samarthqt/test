Feature: Immediate Tracking Information
@TC-15
Scenario: Verify customers receive immediate tracking information reflecting real-time status
Given the user has a valid customer account with Customer ID "CUST11223"
When the user logs in to the customer account using valid credentials
Then the user is successfully logged in to their account
Given the shipment with Shipment ID "SHIP44556" is in transit
When the user navigates to the "Track Shipment" section
Then the "Track Shipment" section is displayed
When the user enters the Shipment ID "SHIP44556" in the search bar
Then the shipment details are displayed for "SHIP44556"
And the current status of the shipment is displayed as "In Transit"
Then the current status is accurately displayed as "In Transit"
When the user refreshes the tracking information
Then the tracking information updates immediately to reflect real-time changes
When the user logs out of the customer account
Then the user is successfully logged out