Feature: User updates personal details successfully
@TC-123
Scenario: User updates name, email, shipping/billing addresses, and phone number
Given a user account with valid login credentials
When the user logs in to the user account
Then the user is logged in successfully and redirected to the dashboard
When the user navigates to the profile settings page
Then the profile settings page is displayed with current user details
When the user updates the name field with "John Doe"
Then the name field is updated with "John Doe"
When the user updates the email field with "john.doe@example.com"
Then the email field is updated with "john.doe@example.com"
When the user updates the shipping address field with "123 Elm St, Springfield"
Then the shipping address field is updated with "123 Elm St, Springfield"
When the user updates the billing address field with "123 Elm St, Springfield"
Then the billing address field is updated with "123 Elm St, Springfield"
When the user updates the phone number field with "123-456-7890"
Then the phone number field is updated with "123-456-7890"
When the user saves the changes made to the profile
Then the changes are saved successfully and a confirmation message is displayed
When the user logs out and logs back in to verify updates
Then the updated details are displayed correctly on the profile settings page
When the user checks email for confirmation of changes
Then email confirmation for each updated detail is received