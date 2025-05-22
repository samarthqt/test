Feature: Immediate Tracking Information - Positive
Ensure immediate tracking information is accurate and up-to-date. User must have a valid customer account.
@TC-16
Scenario: Verify immediate tracking information for a shipment
Given the user has a valid customer account with Customer ID "CUST33445"
When the user logs into the customer account using valid credentials
Then the user is successfully logged in to their account
And the shipment with Shipment ID "SHIP66778" is in transit
When the user navigates to the 'Track Shipment' section
Then the 'Track Shipment' section is displayed
When the user enters the Shipment ID "SHIP66778" in the search bar
Then the shipment details are displayed for "SHIP66778"
And the current status of the shipment is "Out for Delivery"
When the user verifies the current status of the shipment
Then the current status is accurately displayed as "Out for Delivery"
When the user refreshes the page to check for immediate updates
Then tracking information updates immediately to reflect any changes
When the user logs out of the customer account
Then the user is successfully logged out