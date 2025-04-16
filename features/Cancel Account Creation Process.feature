Feature: Cancel Account Creation Process
TCID:TC-12
As a user
I want to be able to cancel the account creation process
So that I can navigate back to the previous page without saving any changes
""
Scenario: Cancel Account Creation Process
Given I am on the account creation page
When I enter the required information for account creation
And I click on the 'Cancel' button
Then a confirmation message should be prompted
When I confirm the cancellation
Then the account creation process should be canceled and I should be navigated back to the previous page
And the entered information should not be saved
""
Business Priority: P3 - Low
""
Prerequisites:
- The user should be able to access the account creation page
""
Test Data:
- None