Feature: Test Bulk Sign-In Attempts
Scenario: Test system response to bulk sign-in attempts with email/password
Given multiple user accounts are active
And valid credentials for each user are known
When I open the application login page
Then the login page is displayed
When I enter email "user1@example.com" and password "Pass123" for User1
Then credentials are entered for User1
When I attempt sign-in for User1
Then User1 is successfully signed in
When I sign out User1
Then User1 is successfully signed out
When I enter email "user2@example.com" and password "Pass123" for User2
Then credentials are entered for User2
When I attempt sign-in for User2
Then User2 is successfully signed in
When I sign out User2
Then User2 is successfully signed out
When I enter email "user3@example.com" and password "Pass123" for User3
Then credentials are entered for User3
When I attempt sign-in for User3
Then User3 is successfully signed in
When I sign out User3
Then User3 is successfully signed out
When I enter email "user4@example.com" and password "Pass123" for User4
Then credentials are entered for User4
When I attempt sign-in for User4
Then User4 is successfully signed in
When I sign out User4
Then User4 is successfully signed out
When I enter email "user5@example.com" and password "Pass123" for User5
Then credentials are entered for User5
When I attempt sign-in for User5
Then User5 is successfully signed in
When I sign out User5
Then User5 is successfully signed out