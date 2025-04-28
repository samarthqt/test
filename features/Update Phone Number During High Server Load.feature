Feature: Update Phone Number During High Server Load
Scenario: Validate that a user can update their phone number successfully during high server load
Given the user is logged into the system
And the system is experiencing high server load
And the existing phone number is "123-456-7890"
When the user navigates to the user profile page
Then the user profile page is displayed
When the user clicks on the "Edit" button next to the phone number field
Then the phone number field becomes editable
When the user enters the new phone number "098-765-4321" in the phone number field
Then the new phone number is entered in the field
When the user clicks on the "Save" button to update the phone number
Then a confirmation message is displayed indicating the phone number has been updated
When the user verifies that the new phone number is displayed in the profile
Then the new phone number "098-765-4321" is displayed in the profile
When the user logs out and logs back into the system
Then the user is able to log back into the system successfully
When the user navigates back to the user profile page
Then the user profile page is displayed with the updated phone number
When the user checks the system logs for any errors during the update process
Then no errors related to phone number update are found in the system logs
When the user attempts to update the phone number again during peak server load
Then the phone number is updated successfully without any delay
When the user verifies they receive a notification about the phone number update
Then the user receives a notification confirming the phone number update
When the user checks the database to ensure the phone number is updated
Then the database reflects the updated phone number "098-765-4321"
When the user attempts to access the system using the new phone number for verification
Then the user is able to verify their identity using the new phone number
When the user monitors the server performance during the phone number update process
Then server performance remains stable during the phone number update
When the user repeats the phone number update process with a different valid number
Then the phone number is updated successfully with the new valid number
When the user ensures the phone number update is reflected across all user-related services
Then all user-related services reflect the updated phone number