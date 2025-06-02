Feature: Recovery link expiration handling at boundary conditions
@TC-122
Scenario: Initiate password recovery process for the user account
Given User account with email verification enabled
When I initiate password recovery process for the user account
Then A recovery link is sent to the user's email "user@example.com"
@TC-122
Scenario: Access the recovery link exactly at 24 hours
Given User has received a recovery link via email
When I access the email and click on the recovery link exactly at 24 hours
Then User is directed to the password recovery page successfully
@TC-122
Scenario: Attempt to use the recovery link one minute after 24 hours
Given User has received a recovery link via email
When I attempt to use the recovery link one minute after 24 hours
Then User receives an error message indicating the link has expired
@TC-122
Scenario: Check system logs for link expiration events at boundary conditions
Given System logs are accessible
When I check the system logs for link expiration events at boundary conditions
Then System logs show accurate handling of boundary expiration
@TC-122
Scenario: Request a new recovery link after testing boundary conditions
Given User has tested boundary conditions for link expiration
When I request a new recovery link
Then A new recovery link is sent to the user's email