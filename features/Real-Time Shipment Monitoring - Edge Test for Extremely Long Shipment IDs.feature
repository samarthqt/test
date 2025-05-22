Feature: Real-Time Shipment Monitoring - Edge Test for Extremely Long Shipment IDs
@TC-14
Scenario: Test the system's response to extremely long shipment IDs
Given the user has a valid customer account
When the user logs in to the customer account using valid credentials
Then the user is successfully logged in to their account
@TC-14
Scenario: Navigate to the 'Track Shipment' section
Given the user is logged in to their account
When the user navigates to the 'Track Shipment' section
Then the 'Track Shipment' section is displayed
@TC-14
Scenario: Enter a long shipment ID in the search bar
Given the user is in the 'Track Shipment' section
When the user enters the long shipment ID "SHIP12345678901234567890" in the search bar
Then the system processes the input without crashing or displaying errors
@TC-14
Scenario: Check system feedback for long shipment ID
Given the user has entered a long shipment ID
When the system processes the input
Then the system either displays an error message or handles the input gracefully
@TC-14
Scenario: Log out of the customer account
Given the user is logged in to their account
When the user logs out of the customer account
Then the user is successfully logged out