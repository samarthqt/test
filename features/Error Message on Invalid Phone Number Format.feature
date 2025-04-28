Feature: Error Message on Invalid Phone Number Format
Scenario: Verify error message is displayed for invalid phone number format
Given the user is logged into their account
When the user navigates to the user profile settings page
Then the user profile settings page is displayed
When the user locates the phone number section
Then the phone number section is visible
When the user clicks on the 'Edit' button next to the phone number
Then the phone number field becomes editable
When the user enters an invalid phone number format "ABC-123-XYZ"
And clicks the 'Save' button
Then the system validates the phone number format
And an error message "Invalid phone number format. Please enter a valid number." is displayed
And the phone number is not updated in the system
Then the phone number remains unchanged
When the user attempts to perform an action that requires phone verification
Then the action cannot be performed due to invalid phone number
When the user reviews the account activity log for any entries related to the invalid phone number update attempt
Then the activity log does not show a successful update entry
When the user tries entering another invalid format "123-ABCD-7890"
Then an error message is displayed for the new invalid format
When the user enters a valid phone number format and saves
Then the system accepts the valid phone number and updates successfully
And verifies that the error message no longer appears with a valid format
Then no error message is displayed for the valid phone number
When the user checks the system logs for any errors during the invalid phone number entry
Then the system logs show validation error entries
When the user attempts to enter a valid phone number with extra spaces or special characters
Then the system trims spaces and removes special characters, accepting the valid number
And ensures that the input field has proper input validation to prevent invalid entries
Then the field has input validation preventing invalid formats from being submitted