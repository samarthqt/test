Feature: Multi-Factor Authentication (MFA) Verification Code
Scenario: Verify sending of 6-digit verification code during MFA
Given a user has a registered phone number in the system
When the user initiates the MFA process by logging into the system with a registered account
Then the system prompts for MFA verification
Scenario: Select phone number as the verification method
Given the system prompts for MFA verification
When the user selects the phone number as the verification method
Then the system displays the registered phone number for verification
Scenario: Confirm phone number selection
Given the user has selected the phone number for verification
When the user confirms the phone number selection
Then the system sends a 6-digit verification code to the registered phone number
Scenario: Check the phone for the received verification code
Given a verification code is sent to the registered phone number
When the user checks the phone for the received verification code
Then verification code '123456' is received via SMS
Scenario: Enter the received verification code into the system
Given the verification code is received via SMS
When the user enters the received verification code into the system
Then the system verifies the code and grants access to the account
Scenario: Verify the code format received
Given a verification code is received
When the user checks the code format
Then the code is exactly 6 digits long
Scenario: Repeat the process with a different registered phone number
Given a different registered phone number is available
When the user repeats the MFA process with the different phone number
Then the verification code is sent successfully to the new number
Scenario: Attempt to initiate MFA without selecting a phone number
Given the user initiates the MFA process
When the user does not select a phone number
Then the system prompts to select a phone number for verification
Scenario: Verify the delivery time of the verification code
Given a verification code is sent
When the user checks the delivery time
Then the code is received within a reasonable time frame (e.g., 30 seconds)
Scenario: Check the SMS content for any additional information
Given a verification code is received via SMS
When the user checks the SMS content
Then the SMS contains only the verification code and no sensitive information
Scenario: Verify the code's uniqueness for different login attempts
Given multiple login attempts are made
When the user checks the verification codes for each attempt
Then a different code is sent for each login attempt
Scenario: Ensure the code is sent only once per login attempt
Given a login attempt is made
When the user checks the number of verification codes sent
Then no duplicate codes are sent for the same attempt
Scenario: Check the phone number format in the system settings
Given a phone number is registered in the system
When the user checks the phone number format in the system settings
Then the phone number is correctly formatted and matches the registered number
Scenario: Verify the system logs the sending of the verification code
Given a verification code is sent to a registered phone number
When the user checks the system logs
Then the system logs show the verification code sent to the registered number
Scenario: Attempt MFA with an unregistered phone number
Given an unregistered phone number is used for MFA
When the user attempts MFA
Then the system does not send a verification code and prompts to register the number