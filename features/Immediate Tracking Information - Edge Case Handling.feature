Feature: Immediate Tracking Information - Edge Case Handling
This feature evaluates the system's handling of boundary conditions with tracking information. The user must have a valid customer account to perform these actions.
@TC-18
Scenario: Evaluate system handling of long Shipment ID
Given the user has a valid customer account with Customer ID "CUST77889"
When the user logs in to the customer account using valid credentials
Then the user is successfully logged in to their account
When the user navigates to the "Track Shipment" section
Then the "Track Shipment" section is displayed
When the user enters the Long Shipment ID "SHIP12345678901234567890" in the search bar
Then the system processes the input without crashing or displaying errors
When the user checks for system feedback or error message for the long ID
Then the system either displays an error message or handles the input gracefully
When the user logs out of the customer account
Then the user is successfully logged out