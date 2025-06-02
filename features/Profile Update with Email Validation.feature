Feature: Profile Update with Email Validation
@TC-126
Scenario: User enters invalid email format and attempts to save changes
Given the user has valid login credentials
When the user logs into the account
Then the user is logged in successfully and redirected to the dashboard
When the user navigates to the profile settings page
Then the profile settings page is displayed with current user details
When the user attempts to update the email field with "johndoe.com"
Then the system displays an error message indicating invalid email format
And the save button is disabled or error prevents saving changes
When the user corrects the email format and attempts to save changes
Then the changes are saved successfully after correcting the email format