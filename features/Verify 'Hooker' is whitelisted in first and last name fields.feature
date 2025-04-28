Feature: Verify 'Hooker' is whitelisted in first and last name fields
Scenario: Ensure the word 'Hooker' is accepted in the first and last name fields across all relevant pages without being flagged
Given User is on the registration or profile update page
When User navigates to the registration page
Then Registration page is displayed
When User enters 'Hooker' in the first name field
Then 'Hooker' is entered in the first name field
When User enters 'Hooker' in the last name field
Then 'Hooker' is entered in the last name field
When User submits the registration form
Then Form is submitted successfully without errors
Then Name 'Hooker' is displayed correctly on the profile page
When User navigates to the profile update page
Then Profile update page is displayed
When User enters 'Hooker' in the first name field
Then 'Hooker' is entered in the first name field
When User enters 'Hooker' in the last name field
Then 'Hooker' is entered in the last name field
When User submits the profile update
Then Profile is updated successfully without errors
Then Name 'Hooker' is displayed correctly on all relevant pages
When User checks for any error messages during submission
Then No error messages are displayed
Then Name 'Hooker' is stored correctly in the database
When User tests with different capitalization of 'Hooker'
Then Different capitalizations are accepted without errors
When User checks for any UI issues when displaying the name
Then No UI issues are present
When User verifies that the name is searchable in the system
Then Name 'Hooker' is searchable without issues