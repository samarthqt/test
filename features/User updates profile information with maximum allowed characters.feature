Feature: User updates profile information with maximum allowed characters
@TC-127
Scenario: User updates profile information fields with maximum allowed characters
Given the user has valid login credentials
When the user logs in to the account
Then the user is logged in successfully and redirected to the dashboard
When the user navigates to the profile settings page
Then the profile settings page is displayed with current user details
When the user updates the name field with maximum allowed characters of 50
Then the name field is updated with maximum allowed characters
When the user updates the email field with maximum allowed characters of 100
Then the email field is updated with maximum allowed characters
When the user updates the shipping address field with maximum allowed characters of 200
Then the shipping address field is updated with maximum allowed characters
When the user updates the billing address field with maximum allowed characters of 200
Then the billing address field is updated with maximum allowed characters
When the user updates the phone number field with maximum allowed characters of 15
Then the phone number field is updated with maximum allowed characters
When the user saves the changes made to the profile
Then the changes are saved successfully and a confirmation message is displayed
When the user logs out and logs back in to verify updates
Then the updated details are displayed correctly on the profile settings page
When the user checks email for confirmation of changes
Then email confirmation for each updated detail is received