Feature: Verification during high traffic periods
Scenario: Ensure successful verification during high traffic periods
Given the user is registered and attempting to log in during peak hours
When the user initiates the login process on the mobile application during peak hours
Then the user is prompted to enter their phone number
And the user enters the registered phone number "+1234567890" and submits
Then the system sends an SMS code to the provided phone number
And the user checks the phone for the SMS code
Then the SMS code "123456" is received on the user's phone within expected time even during high traffic
When the user enters the received SMS code in the application
Then the system validates the code and allows the user to proceed
And verify system performance and response time during the process
Then the system performs efficiently without significant delays