Feature: Email Marketing Signup
""
As a user,
I want to be able to opt-in for email newsletters and promotions,
So that I can receive updates and offers from the company.
""
Background:
Given the user is on the marketing signup page
""
Scenario: Successful email opt-in
When the user enters a valid email address
And the user checks the opt-in checkbox for newsletters and promotions
And the user submits the signup form
Then the user should see a confirmation message stating that they have successfully signed up for email newsletters and promotions
And the user's email should be added to the marketing mailing list
""
Scenario: Opt-in with invalid email address
When the user enters an invalid email address
And the user checks the opt-in checkbox for newsletters and promotions
And the user submits the signup form
Then the user should see an error message indicating that the email address is invalid
And the user's email should not be added to the marketing mailing list
""
Scenario: Opt-in without checking the opt-in checkbox
When the user enters a valid email address
And the user does not check the opt-in checkbox for newsletters and promotions
And the user submits the signup form
Then the user should see a message indicating that they need to opt-in to receive newsletters and promotions
And the user's email should not be added to the marketing mailing list
""
Scenario: Opt-in with already subscribed email
Given the user has already subscribed to newsletters and promotions
When the user enters the same email address
And the user checks the opt-in checkbox for newsletters and promotions
And the user submits the signup form
Then the user should see a message indicating that the email is already subscribed
And no duplicate entry should be created in the marketing mailing list
```
```gherkin
TCID:61