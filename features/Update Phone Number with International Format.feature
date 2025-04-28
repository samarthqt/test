Feature: Update Phone Number with International Format
Scenario: Ensure the system allows updating the phone number in international format
Given the user is logged into the system
And the user has an existing phone number "123-456-7890" in the profile
When the user navigates to the user profile page
Then the user profile page is displayed
Scenario: Edit and save new international phone number
Given the user is on the user profile page
When the user clicks on the 'Edit' button next to the phone number field
Then the phone number field becomes editable
When the user enters the new international phone number "+44 7911 123456" in the phone number field
And the user clicks on the 'Save' button to update the phone number
Then a confirmation message is displayed indicating the phone number has been updated
And the new international phone number "+44 7911 123456" is displayed in the profile
Scenario: Verify phone number update after re-login
Given the user logs out and logs back into the system
When the user navigates back to the user profile page
Then the user profile page is displayed with the updated international phone number
Scenario: Check system logs for errors
When the user checks the system logs for any errors during the update process
Then no errors related to phone number update are found in the system logs
Scenario: Update phone number with a different international number
When the user attempts to update the phone number again with a different international number
Then the phone number is updated successfully with the new international number
Scenario: Verify notification for phone number update
When the user verifies the notification about the phone number update
Then the user receives a notification confirming the phone number update
Scenario: Database reflects updated phone number
When the user checks the database to ensure the phone number is updated
Then the database reflects the updated international phone number "+44 7911 123456"
Scenario: Verify system access using new phone number
When the user attempts to access the system using the new international phone number for verification
Then the user is able to verify their identity using the new international phone number
Scenario: Monitor server performance during update
When the user monitors the server performance during the phone number update process
Then the server performance remains stable during the phone number update
Scenario: Repeat phone number update with another valid international number
When the user repeats the phone number update process with a different valid international number
Then the phone number is updated successfully with the new valid international number
Scenario: Ensure update is reflected across all services
When the user ensures the phone number update is reflected across all user-related services
Then all user-related services reflect the updated international phone number