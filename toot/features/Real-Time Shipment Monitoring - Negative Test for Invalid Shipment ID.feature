Feature: Real-Time Shipment Monitoring - Negative Test for Invalid Shipment ID
@TC-13
Scenario: Ensure the system handles invalid shipment IDs gracefully
Given the user has a valid customer account with Customer ID "CUST98765"
When the user logs in using valid credentials
Then the user is successfully logged into their account
When the user navigates to the "Track Shipment" section
Then the "Track Shipment" section is displayed
When the user enters the invalid Shipment ID "SHIP00000" in the search bar
Then the system displays an error message indicating the shipment ID is invalid
When the user attempts to refresh the page
Then the error message persists and no shipment details are displayed
When the user logs out of the customer account
Then the user is successfully logged out