Feature: Email Marketing Signup
""
Scenario: User signs up for email marketing updates
Given the user is on the email marketing signup page
When the user enters a valid email address
And the user submits the signup form
Then the user should see a confirmation message
And the user should be added to the email marketing list
""
Scenario: User attempts to sign up with an invalid email
Given the user is on the email marketing signup page
When the user enters an invalid email address
And the user submits the signup form
Then the user should see an error message indicating the email is invalid
And the user should not be added to the email marketing list
""
Scenario: User attempts to sign up with an already registered email
Given the user is on the email marketing signup page
When the user enters an email address that is already registered
And the user submits the signup form
Then the user should see a message indicating the email is already registered
And the user should not be added to the email marketing list again
""
Scenario: User signs up without providing an email
Given the user is on the email marketing signup page
When the user submits the signup form without entering an email address
Then the user should see an error message indicating that an email address is required
And the user should not be added to the email marketing list
""
Scenario: User views the privacy policy before signing up
Given the user is on the email marketing signup page
When the user clicks on the privacy policy link
Then the user should be redirected to the privacy policy page
And the user should be able to return to the signup page
```
```gherkin
TCID:52