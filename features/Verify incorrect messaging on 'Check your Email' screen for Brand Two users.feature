Feature: Verify incorrect messaging on 'Check your Email' screen for Brand Two users
Scenario: System response to incorrect messaging on 'Check your Email' screen
Given a user is registered with Brand Two and has initiated an email verification process
When the user initiates the email verification process for Brand Two
Then the user is directed to the 'Check your Email' screen
Scenario: Verify correct messaging is displayed on the screen
Given the user is on the 'Check your Email' screen
When the system displays a message
Then the correct message "Please check your email for the verification link." should be displayed
Scenario: Identify discrepancies in the messaging
Given the user is on the 'Check your Email' screen
When the system displays a message
Then identify and report any incorrect messaging
And the incorrect message "Check your inbox for the email." should be noted
Scenario: Check for additional instructions or links on the screen
Given the user is on the 'Check your Email' screen
Then no additional instructions or links are present
Scenario: Verify user is not misled by incorrect messaging
Given the user sees an incorrect message on the 'Check your Email' screen
Then the user is not misled by the incorrect message