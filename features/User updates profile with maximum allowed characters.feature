Feature: User updates profile with maximum allowed characters
@TC-125
Scenario: Test updating profile fields with maximum allowed characters
Given a user account with valid login credentials
When the user logs in to the user account
Then the user is logged in successfully and redirected to the dashboard
When the user navigates to the profile settings page
Then the profile settings page is displayed with current user details
When the user updates the name field with maximum allowed characters
Then the name field is updated with maximum allowed characters
When the user updates the email field with maximum allowed characters
Then the email field is updated with maximum allowed characters
When the user updates the shipping address field with maximum allowed characters
Then the shipping address field is updated with maximum allowed characters
When the user updates the billing address field with maximum allowed characters
Then the billing address field is updated with maximum allowed characters
When the user updates the phone number field with maximum allowed characters
Then the phone number field is updated with maximum allowed characters
When the user saves the changes made to the profile
Then the changes are saved successfully and a confirmation message is displayed
When the user logs out and logs back in to verify updates
Then updated details are displayed correctly on the profile settings page
When the user checks email for confirmation of changes
Then email confirmation for each updated detail is received