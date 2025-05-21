Feature: Social Media Login
""
As a user,
I want to log in using my social media accounts,
So that I can easily access my account without creating a new username and password.
""
Background:
Given the user is on the login page
""
Scenario Outline: Successful login using social media account
"    When the user selects ""<Social Media Platform>"" login option"
"    And the user is redirected to ""<Social Media Platform>"" login page"
"    And the user enters valid ""<Social Media Platform>"" credentials"
And the user authorizes the application
Then the user should be redirected to the home page
And the user should be logged in successfully
""
Examples:
| Social Media Platform |
| Facebook              |
| Google                |
| Twitter               |
| LinkedIn              |
""
Scenario Outline: Unsuccessful login due to invalid credentials
"    When the user selects ""<Social Media Platform>"" login option"
"    And the user is redirected to ""<Social Media Platform>"" login page"
"    And the user enters invalid ""<Social Media Platform>"" credentials"
Then the user should see an error message indicating invalid credentials
And the user should not be logged in
""
Examples:
| Social Media Platform |
| Facebook              |
| Google                |
| Twitter               |
| LinkedIn              |
""
Scenario Outline: Unsuccessful login due to denied authorization
"    When the user selects ""<Social Media Platform>"" login option"
"    And the user is redirected to ""<Social Media Platform>"" login page"
"    And the user enters valid ""<Social Media Platform>"" credentials"
And the user denies the application authorization
Then the user should be redirected back to the login page
And the user should not be logged in
""
Examples:
| Social Media Platform |
| Facebook              |
| Google                |
| Twitter               |
| LinkedIn              |
""
Scenario: Social media login option not available
Given the user is on the login page
When the user looks for social media login options
Then the user should see options for Facebook, Google, Twitter, and LinkedIn
```
```gherkin
TCID:27