Feature: Registration with Already Registered Email
As a user, I want to attempt registration with an already registered email and verify error handling.
@TC-328
Scenario: Attempt registration with an already registered email
Given I am on the registration page
When I enter email "existinguser@example.com" and password "AnotherPass123!" in the registration form
And I submit the registration form
Then I should see an error message indicating the email is already registered
And the error logs should contain messages about the already registered email
And I should not be able to proceed with registration using the same email
@TC-328
Scenario Outline: Attempt registration with different already registered emails
Given I am on the registration page
When I enter email "<registered_email>" and password "AnotherPass123!" in the registration form
And I submit the registration form
Then I should see an error message indicating the email is already registered
And the error logs should contain messages about the already registered email
And I should not be able to proceed with registration using the same email
Examples:
| registered_email            |
| registereduser1@example.com |
| registereduser2@example.com |
@TC-328
Scenario: Successfully register with a new, unregistered email
Given I am on the registration page
When I enter email "newuser@example.com" and password "NewPass123!" in the registration form
And I submit the registration form
Then I should be registered successfully with a new email
@TC-328
Scenario: Verify system behavior with multiple registration attempts using registered emails
Given I am on the registration page
When I attempt registration with multiple registered emails
Then the system should handle multiple errors gracefully and display appropriate messages
And the system should return to a stable state after handling errors
@TC-328
Scenario: Verify user feedback for registration errors
Given I am on the registration page
When I attempt registration with an already registered email
Then I should receive clear and informative feedback about the registration error
@TC-328
Scenario: Check for unhandled exceptions during registration attempts
Given I am on the registration page
When I attempt registration with an already registered email
Then there should be no unhandled exceptions present
@TC-328
Scenario: Verify system logs do not contain critical errors
Given I am on the registration page
When I attempt registration with an already registered email
Then the system logs should not contain critical errors
@TC-328
Scenario: Inform user about alternative registration options
Given I am on the registration page
When I attempt registration with an already registered email
Then I should receive information about alternative registration methods
@TC-328
Scenario: Verify system scalability during multiple registration attempts
Given I am on the registration page
When I attempt multiple registrations with registered emails
Then the system should scale resources appropriately to handle multiple attempts
@TC-328
Scenario: Check system stability during registration error handling
Given I am on the registration page
When I attempt registration with an already registered email
Then the system should remain stable and responsive