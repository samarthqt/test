Feature: Real-Time Shipment Monitoring - Negative Testing
In order to ensure the system handles invalid shipment IDs gracefully
As a user with a valid customer account
I want to see an appropriate error message when entering an invalid shipment ID
@TC-13
Scenario: Handle invalid shipment ID gracefully
Given the user logs into the customer account using valid credentials
And the user has Customer ID "CUST98765"
When the user navigates to the "Track Shipment" section
Then the "Track Shipment" section is displayed
When the user enters the invalid shipment ID "SHIP00000" in the search bar
Then the system displays an error message indicating the shipment ID is invalid
When the user attempts to refresh the page
Then the error message persists and no shipment details are displayed
When the user logs out of the customer account
Then the user is successfully logged out