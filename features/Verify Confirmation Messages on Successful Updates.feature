Feature: Verify Confirmation Messages on Successful Updates
@TC-36
Scenario: User receives confirmation messages upon successful profile updates
Given a user account with update permissions
When the user logs in using valid credentials
Then the user should be successfully logged in and directed to the dashboard
@TC-36
Scenario: Navigate to profile settings page
Given the user is on the dashboard
When the user navigates to the profile settings page
Then the profile settings page should be displayed
@TC-36
Scenario: Update email address with a new valid email
Given the user is on the profile settings page
When the user updates the email address field with a new valid email
Then the email field should accept the new email address
@TC-36
Scenario: Save changes and verify confirmation message
Given the user has updated the email address
When the user clicks on the 'Save Changes' button
Then changes should be saved successfully
And a confirmation message should be displayed indicating successful update
@TC-36
Scenario: Verify updated email in profile settings
Given the user has saved the changes
When the user checks the updated email in the profile settings
Then the new email should be displayed in the email field
@TC-36
Scenario: Log out and log back in using updated email
Given the user is logged in
When the user logs out of the account
Then the user should be successfully logged out
When the user logs back in using the new email address
Then the user should be able to log in using the updated email
@TC-36
Scenario: Verify confirmation email received
Given the user has updated the email address
When the user checks the inbox for a confirmation email
Then a confirmation email should be received with details of the update
@TC-36
Scenario: Check for error messages during update process
Given the user is updating profile information
When the user performs the update
Then no error messages should appear during the update process
@TC-36
Scenario: Update another field and verify confirmation message
Given the user is on the profile settings page
When the user attempts to update another field
Then a confirmation message should appear for each successful update
@TC-36
Scenario: Check user notifications for update confirmation
Given the user has updated profile information
When the user checks notifications
Then notification should confirm the successful update
@TC-36
Scenario: Verify system logs for update entries
Given the user has performed an update
When the system logs are checked
Then system logs should record the update action with a timestamp
@TC-36
Scenario: Attempt to update with invalid data
Given the user is on the profile settings page
When the user attempts to update with invalid data
Then no confirmation message should appear
And error handling should activate
@TC-36
Scenario: Ensure confirmation message clarity
Given the user receives a confirmation message
Then the confirmation message should clearly state the update was successful