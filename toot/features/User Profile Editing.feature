Feature: User Profile Editing
""
As a user, I want to be able to edit my personal information in my profile so that I can keep my account information up-to-date.
""
Background:
Given a user is logged into their account
And the user is on their profile page
""
Scenario: Edit user profile with valid information
"    When the user clicks on the ""Edit Profile"" button"
And the user updates their personal information with valid data
"    And the user clicks on the ""Save"" button"
Then the user's profile should be updated with the new information
And a confirmation message should be displayed
""
Scenario: Edit user profile with invalid information
"    When the user clicks on the ""Edit Profile"" button"
And the user updates their personal information with invalid data
"    And the user clicks on the ""Save"" button"
Then the user's profile should not be updated
And an error message should be displayed indicating the invalid fields
""
Scenario: Cancel editing user profile
"    When the user clicks on the ""Edit Profile"" button"
And the user updates their personal information
"    And the user clicks on the ""Cancel"" button"
Then the user's profile should not be updated
And the user should be redirected back to the profile page without changes
""
Scenario: View edit history of user profile
Given the user has edited their profile before
"    When the user navigates to the ""Edit History"" section"
Then the user should see a list of previous changes made to their profile
And each entry should include the date and time of the change
""
Scenario: Edit user profile with special characters
"    When the user clicks on the ""Edit Profile"" button"
And the user updates their personal information with special characters
"    And the user clicks on the ""Save"" button"
Then the user's profile should be updated with the new information
And a confirmation message should be displayed
""
Scenario: Edit user profile without changing any information
"    When the user clicks on the ""Edit Profile"" button"
And the user does not change any information
"    And the user clicks on the ""Save"" button"
Then the user's profile should remain unchanged
And a message should be displayed indicating no changes were made
```
```gherkin
TCID:45