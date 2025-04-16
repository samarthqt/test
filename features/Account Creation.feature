Feature: Account Creation
TCID:TC-11
As a user
I want to be able to save a created account
So that I can receive a confirmation message upon successful creation
""
Scenario: Save created account and display confirmation message
Given I am logged in to the system with valid credentials
When I navigate to the account creation page
And I enter valid account details in the required fields
And I click on the 'Save' button
Then I should see a confirmation message indicating the successful creation of the account