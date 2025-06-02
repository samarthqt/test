Feature: User Profile Email Update
@TC-124
Scenario: User updates profile with an invalid email format
Given a user account with valid login credentials
When the user logs in to the account
Then the user is redirected to the dashboard
When the user navigates to the profile settings page
Then the profile settings page is displayed with current user details
When the user attempts to update the email field with "johndoe.com"
Then the system displays an error message indicating invalid email format
And changes cannot be saved with the invalid email
And the save button is disabled or error prevents saving changes
When the user corrects the email format
And attempts to save changes
Then the changes are saved successfully after correcting the email format