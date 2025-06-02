Feature: User Registration via Email, Google, and Facebook
@TC-327
Scenario: Register user via email and redirect to home page
Given I navigate to the registration page
When I enter email "newuser@example.com" and password "SecurePass123!" in the registration form
And I submit the registration form
Then the user is registered successfully and redirected to the home page
@TC-327
Scenario: Log out and navigate back to registration page
Given I am logged in
When I log out
And I navigate back to the registration page
Then the registration page is displayed again
@TC-327
Scenario: Register user via Google and redirect to home page
Given I navigate to the registration page
When I select "Register with Google"
And I enter Google account credentials and submit
Then the user is registered successfully and redirected to the home page
@TC-327
Scenario: Log out and navigate back to registration page after Google registration
Given I am logged in with Google account
When I log out
And I navigate back to the registration page
Then the registration page is displayed again
@TC-327
Scenario: Register user via Facebook and redirect to home page
Given I navigate to the registration page
When I select "Register with Facebook"
And I enter Facebook account credentials and submit
Then the user is registered successfully and redirected to the home page
@TC-327
Scenario: Verify login with newly registered email credentials
Given I have registered with email "newuser@example.com"
When I log in with email "newuser@example.com" and password "SecurePass123!"
Then the user logs in successfully and is redirected to the home page
@TC-327
Scenario: Verify login with Google credentials
Given I have registered with Google account
When I log in with Google credentials
Then the user logs in successfully and is redirected to the home page
@TC-327
Scenario: Verify login with Facebook credentials
Given I have registered with Facebook account
When I log in with Facebook credentials
Then the user logs in successfully and is redirected to the home page
@TC-327
Scenario: Check system logs for errors during registration
Given registration has occurred
When I check the system logs
Then no errors should be present in the logs
@TC-327
Scenario: Verify feedback messages during registration
Given I am registering a user
When I complete the registration process
Then user receives clear feedback messages about registration status
@TC-327
Scenario: Ensure system returns to stable state after registration
Given registration has occurred
When I perform regular system operations
Then the system should be stable and responsive