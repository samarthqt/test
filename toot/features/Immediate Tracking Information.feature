Feature: Immediate Tracking Information
Verify customers receive immediate tracking information reflecting real-time status.
@TC-15
Scenario: Verify real-time tracking information for shipments
Given the user has a valid customer account
And the user logs in using valid credentials
When the user navigates to the 'Track Shipment' section
Then the 'Track Shipment' section is displayed
And the user enters the Shipment ID "SHIP44556" in the search bar
Then the shipment details are displayed for "SHIP44556"
And the current status of the shipment is displayed as "In Transit"
When the user refreshes the tracking information
Then the tracking information updates immediately to reflect real-time changes
And the user logs out of the customer account
Then the user is successfully logged out