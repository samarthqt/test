Feature: Password Recovery with Edge Case Email Formats
Scenario: Verify password recovery functionality with valid edge case email format 'user.name+tag@example.com'
@TC-57
Given the password recovery page is open
When I enter the email format 'user.name+tag@example.com'
And I click on 'Recover Password'
Then the system sends a recovery email successfully
Scenario: Verify password recovery functionality with valid edge case email format 'user_name@example.co.uk'
@TC-57
Given the password recovery page is open
When I enter the email format 'user_name@example.co.uk'
And I click on 'Recover Password'
Then the system sends a recovery email successfully
Scenario: Verify password recovery functionality with valid edge case email format 'user@sub.example.com'
@TC-57
Given the password recovery page is open
When I enter the email format 'user@sub.example.com'
And I click on 'Recover Password'
Then the system sends a recovery email successfully
Scenario: Verify password recovery functionality with valid edge case email format 'user@123.123.123.123'
@TC-57
Given the password recovery page is open
When I enter the email format 'user@123.123.123.123'
And I click on 'Recover Password'
Then the system sends a recovery email successfully
Scenario: Verify password recovery functionality with valid edge case email format 'user@[IPv6:2001:db8::1]'
@TC-57
Given the password recovery page is open
When I enter the email format 'user@[IPv6:2001:db8::1]'
And I click on 'Recover Password'
Then the system sends a recovery email successfully
Scenario: Verify recovery emails are received for all valid edge case email formats
@TC-57
Given the recovery emails are sent for all valid formats
When I check the email inbox
Then recovery emails are received for all formats
Scenario: Attempt password recovery with an invalid email format
@TC-57
Given the password recovery page is open
When I enter an invalid email format
And I click on 'Recover Password'
Then the system displays an error message for invalid format
Scenario: Verify email format validation on the recovery page
@TC-57
Given the password recovery page is open
When I enter various email formats
Then the system validates email formats correctly
Scenario: Check system logs for recovery attempts
@TC-57
Given the password recovery process is initiated
When I check the system logs
Then logs reflect all recovery attempts with respective outcomes
Scenario: Verify recovery link functionality for all email formats
@TC-57
Given the recovery emails are received
When I click on the recovery link in each email
Then recovery links work correctly for all formats
Scenario: Attempt recovery with duplicate email format entries
@TC-57
Given the password recovery page is open
When I enter duplicate email format entries
And I click on 'Recover Password'
Then the system handles duplicate entries gracefully
Scenario: Verify system notifications for recovery attempts
@TC-57
Given the password recovery process is completed
When I check system notifications
Then system sends notifications for successful recovery attempts
Scenario: Check recovery email content for all formats
@TC-57
Given the recovery emails are received
When I review the email content
Then email content is consistent and accurate for all formats