Feature: Immediate Tracking Information - Negative Test
This feature tests the system's response to invalid tracking requests. User must have a valid customer account.
@TC-17
Scenario: Test invalid shipment ID tracking
Given the user has a valid customer account with Customer ID "CUST55667"
When the user logs in using valid credentials
Then the user is successfully logged in to their account
When the user navigates to the "Track Shipment" section
Then the "Track Shipment" section is displayed
When the user enters the invalid Shipment ID "SHIP99999" in the search bar
Then the system displays an error message indicating the shipment ID is invalid
When the user attempts to refresh the page
Then the error message persists and no shipment details are displayed
When the user logs out of the customer account
Then the user is successfully logged out