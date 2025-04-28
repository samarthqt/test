Feature: Validate the flagging of the word 'Nude' in name fields
Scenario: Ensure 'Nude' is flagged only for exact matches in name fields
Given the user is on the registration page
When the user enters "Nude" in the first name field
And the user enters "Nude" in the last name field
And the user submits the registration form
Then the form submission is blocked with an appropriate error message
Scenario: Allow non-exact matches in name fields
Given the user is on the registration page
When the user enters "Anudeep" in the first name field
And the user enters "Canude" in the last name field
And the user submits the registration form
Then the form is submitted successfully without errors
And the names "Anudeep" and "Canude" are displayed correctly on the profile page
Scenario: Flag 'Nude' during profile update for exact matches
Given the user is on the profile update page
When the user enters "Nude" in any name field and attempts to update
Then the update is blocked with an appropriate error message
Scenario: Allow profile update with non-exact matches
Given the user is on the profile update page
When the user enters "Anudeep" in the first name field
And the user enters "Canude" in the last name field
And the user submits the profile update
Then the profile is updated successfully without errors
Scenario: Verify only exact matches of 'Nude' are flagged
Given the system logs are accessible
When checking the system logs for errors or warnings related to name entries
Then no errors or warnings are logged for acceptable names