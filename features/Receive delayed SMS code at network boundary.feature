Feature: Receive delayed SMS code at network boundary
Scenario: Test the system's handling of delayed SMS code reception at network boundary
Given the user is registered and attempting to log in from a location at the network boundary
When the user initiates the login process on the mobile application
Then the user is prompted to enter their phone number
Scenario: Enter registered phone number and receive SMS code
Given the user enters the registered phone number "+1234567890" and submits
When the system sends an SMS code to the provided phone number
Then the user experiences a delay in receiving the SMS code due to network coverage in the boundary area
Scenario: Receive and enter delayed SMS code
Given the user receives the SMS code "123456" after a delay
When the user enters the received SMS code in the application after the delay
Then the system validates the code and allows the user to proceed
Scenario: Verify system handles delayed input correctly
Given the user has entered the delayed SMS code
When the system processes the input
Then the system accepts the delayed SMS code without errors