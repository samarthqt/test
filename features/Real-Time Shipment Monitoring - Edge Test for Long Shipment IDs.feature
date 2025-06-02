Feature: Real-Time Shipment Monitoring - Edge Test for Long Shipment IDs
@TC-14
Scenario: Test system response to extremely long shipment IDs
Given the user has a valid customer account
When the user logs in using valid credentials
Then the user is successfully logged into their account
Given the user navigates to the 'Track Shipment' section
Then the 'Track Shipment' section is displayed
When the user enters the long shipment ID "SHIP12345678901234567890" in the search bar
Then the system processes the input without crashing or displaying errors
When the system provides feedback or an error message for the long ID
Then the system either displays an error message or handles the input gracefully
When the user logs out of the customer account
Then the user is successfully logged out