Feature: Account Creation Using Email, Google, or Facebook
@TC-83
Scenario: Verify account creation using email
Given I navigate to the account creation page
When I select the "Sign up with Email" option
And I enter the email address "testuser@example.com" and fill in the required details
And I submit the email sign-up form
Then an account is created successfully using the email address
@TC-83
Scenario: Verify account creation using Google
Given I am logged out and on the account creation page
When I select the "Sign up with Google" option
And I authenticate using Google account "googleuser@gmail.com"
Then Google authentication is successful and account is created
@TC-83
Scenario: Verify account creation using Facebook
Given I am logged out and on the account creation page
When I select the "Sign up with Facebook" option
And I authenticate using Facebook account "fbuser@facebook.com"
Then Facebook authentication is successful and account is created
@TC-83
Scenario: Verify login with created accounts
Given accounts are created using email, Google, and Facebook
When I attempt to log in using each account
Then I am able to log in using email, Google, and Facebook accounts
@TC-83
Scenario: Verify confirmation email or notification
Given accounts are created using email, Google, and Facebook
When I check for any confirmation email or notification received after account creation
Then confirmation email or notification is received for each account creation method
@TC-83
Scenario: Verify user account details accuracy
Given accounts are created using email, Google, and Facebook
When I verify the user account details
Then user account details are accurate and match the information provided during sign-up
@TC-83
Scenario: Attempt to create an account with an already registered email
Given there is an existing account with the email "testuser@example.com"
When I attempt to create another account using the same email
Then the system displays an error message indicating the email is already registered
@TC-83
Scenario: Check system response time to account creation requests
Given I am on the account creation page
When I initiate an account creation request
Then the system responds promptly to account creation requests