Feature: Navigation to Users Page as Admin
@3
Scenario: Admin user successfully logs into CoCO
Given the Admin user is on the login page
When the Admin user enters valid credentials
Then the Admin user should be logged in successfully
@3
Scenario: Admin user views Admin profile menu options
Given the Admin user is logged into CoCO
When the Admin user navigates to the profile section
Then the Admin user should see the Admin profile menu options
@3
Scenario: Admin user navigates to Users page via projects menu option
Given the Admin user is logged into CoCO
And the Admin user can see the Admin profile menu options
When the Admin user clicks on the projects menu option
Then the Admin user should be redirected to the Users page
@3
Scenario: Verify "create new User" option on the Users page
Given the Admin user is on the Users page
When the Users page is loaded
Then the Admin user should see the "create new User" option on the Users page