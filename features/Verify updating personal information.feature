Feature: Verify updating personal information
@TC-31
Scenario: Ensure that users can update their personal information such as name, email, and phone number
Given User is logged into their account
When User navigates to the profile settings page
Then Profile settings page is displayed
When User enters new name "John Doe" in the name field
Then New name is entered in the name field
When User enters new email "john.doe@example.com" in the email field
Then New email is entered in the email field
When User enters new phone number "+1234567890" in the phone number field
Then New phone number is entered in the phone number field
When User saves the changes
Then Changes are saved successfully
Then Profile page displays the updated name, email, and phone number
When User logs out and logs back in
Then User is successfully logged in again
When User navigates to the profile settings page
Then Profile settings page is displayed
Then Profile page still displays the updated name, email, and phone number
When User checks the email inbox for confirmation email
Then User receives a confirmation email about the email change
When User checks the phone for confirmation SMS
Then User receives a confirmation SMS about the phone number change
Then Account settings display the updated name, email, and phone number
When User logs in using the updated email address
Then User can log in using the updated email address
When User verifies that the updated phone number can receive SMS notifications
Then User can receive SMS notifications on the updated phone number