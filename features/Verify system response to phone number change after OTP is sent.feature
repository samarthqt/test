Feature: Verify system response to phone number change after OTP is sent
Scenario: Check system behavior when phone number in IDP is changed after OTP is sent
Given User is logged into the system
And User has access to IDP
When User navigates to the IDP phone number update page
Then Phone number update page is displayed
Scenario: Enter original phone number
Given User is on the phone number update page
When User enters the original phone number "1234567890" in the phone number field
Then Original phone number is accepted
Scenario: Request OTP for the original phone number
Given Original phone number "1234567890" is accepted
When User requests OTP for the original phone number
Then OTP is sent to the original phone number
Scenario: Change phone number in IDP to new phone number
Given OTP is sent to the original phone number
When User changes the phone number in IDP to the new phone number "0987654321"
Then System accepts the new phone number and updates IDP
Scenario: Attempt OTP verification using the original phone number
Given Phone number is changed in IDP
When User attempts OTP verification using the original phone number
Then System displays error message indicating phone number change
Scenario: Check system logs for phone number change entries
Given Phone number change has occurred
When User checks system logs for entries related to phone number change
Then System logs contain entries for phone number change
Scenario: Verify system guidance for next steps after phone number change
Given Phone number change is logged
When User verifies system guidance provided for next steps after phone number change
Then System provides clear guidance on next steps after phone number change
Scenario: Request OTP for the new phone number
Given Phone number is updated in IDP
When User requests OTP for the new phone number "0987654321"
Then OTP is sent to the new phone number
Scenario: Attempt OTP verification using the new phone number
Given OTP is sent to the new phone number
When User attempts OTP verification using the new phone number
Then System successfully verifies OTP for the new phone number
Scenario: Check system response time for phone number update confirmation
Given Phone number is updated
When User checks system's response time for phone number update confirmation
Then System promptly confirms phone number update
Scenario: Ensure system maintains security during phone number change
Given Phone number change is in process
When User ensures system maintains security during phone number change
Then System maintains security, no unauthorized access during phone number change
Scenario: Test system behavior under high phone number change volumes
Given High volume of phone number changes
When User tests system behavior under high phone number change volumes
Then System maintains performance under high phone number change volumes
Scenario: Verify user notification methods for phone number change status
Given Phone number change is completed
When User verifies user notification methods for phone number change status
Then User is notified of phone number change status through multiple channels
Scenario: Ensure logs contain detailed information for auditing phone number changes
Given Phone number change is logged
When User ensures logs contain detailed information for auditing phone number changes
Then Logs contain detailed information for auditing phone number changes
Scenario: Attempt to bypass phone number change using different device
Given Phone number change is in process
When User attempts to bypass phone number change using different device
Then System detects and blocks attempts to bypass phone number change