Feature: Successful Phone Number Update and Verification Code Receipt
Scenario: Verify that a user can update their phone number successfully and receive a verification code
Given User is logged into their account
And User has access to the new phone number
When User navigates to the user profile settings page
Then User profile settings page is displayed
And Current phone number is 123-456-7890
When User locates the phone number section
Then Phone number section is visible
When User clicks on the 'Edit' button next to the phone number
Then Phone number field becomes editable
When User enters the new phone number: 098-765-4321
Then New phone number is entered in the field
When User clicks the 'Save' button
Then System prompts for confirmation of the new phone number
When User confirms the update of the phone number
Then A confirmation message is displayed indicating the phone number update is successful
When User waits for the verification code to be sent to the new phone number
Then Verification code is received on the new phone number
When User enters the received verification code: 123456
Then Verification code is entered correctly
When User clicks on 'Verify' button
Then System verifies the code and confirms the phone number update
When User checks the updated phone number on the user profile
Then New phone number is displayed on the user profile
When User logs out and logs back into the account
Then User logs in successfully with the updated phone number
When User attempts to perform an action that requires phone verification
Then Action is performed successfully using the updated phone number
When User checks for any errors or alerts on the profile page
Then No errors or alerts are displayed
When User ensures the verification code is not sent to the old phone number
Then Verification code is only sent to the new phone number
When User reviews the account activity log for the phone number update entry
Then Account activity log shows entry for the phone number update