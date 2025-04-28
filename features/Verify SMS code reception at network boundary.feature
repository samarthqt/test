Feature: Verify SMS code reception at network boundary
Scenario: Ensure that users receive an SMS code when they are at the boundary of network coverage
Given a user is registered and attempting to log in from a location at the network boundary
When the user initiates the login process on the mobile application
Then the user is prompted to enter their phone number
When the user enters the registered phone number "+1234567890" and submits
Then the system sends an SMS code to the provided phone number
When the user checks the phone for the SMS code
Then the SMS code "123456" is received on the user's phone within expected time
When the user enters the received SMS code in the application
Then the system validates the code and allows the user to proceed
When the user verifies that the SMS code is correct and matches the expected format
Then the SMS code matches the expected format and is accepted by the system