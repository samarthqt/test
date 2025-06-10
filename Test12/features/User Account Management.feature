Feature: User Account Management
@65
Scenario: User sign up using email
Given a user navigates to the sign-up page
When the user enters valid email and password
And clicks on the sign-up button
Then the user account should be created successfully
@65
Scenario: User sign up using Google credentials
Given a user navigates to the sign-up page
When the user selects the option to sign up with Google
And completes the Google authentication process
Then the user account should be created successfully
@65
Scenario: User sign up using Facebook credentials
Given a user navigates to the sign-up page
When the user selects the option to sign up with Facebook
And completes the Facebook authentication process
Then the user account should be created successfully
@65
Scenario: Password recovery with email
Given a user navigates to the password recovery page
When the user enters their registered email address
And clicks on the recover password button
Then a password recovery email should be sent to the user
@65
Scenario: Update personal information
Given a user is logged in
When the user navigates to the personal information page
And updates their personal information
And clicks on the save button
Then the user's personal information should be updated successfully
@65
Scenario: View order history
Given a user is logged in
When the user navigates to the order history page
Then the user should be able to see a detailed view of past orders
@65
Scenario: Track orders in real-time
Given a user is logged in
When the user navigates to the order tracking page
Then the user should receive real-time updates on their order status
@65
Scenario: Manage wishlist
Given a user is logged in
When the user navigates to the wishlist page
And adds, removes, or organizes products
Then the wishlist should be updated accordingly
@65
Scenario: Security measures for user data protection
Given a user account exists
When a user performs account-related actions
Then security measures should protect user data
@65
Scenario: Notifications for account changes
Given a user is logged in
When the user updates account information
Then a notification should be sent to the user
@65
Scenario: Error handling for account processes
Given a user performs an invalid action
When the system detects the error
Then appropriate error messages should be displayed to the user
@65
Scenario: Confirm functionality across all account management features
Given a user has access to the account management features
When the user interacts with each feature
Then each feature should function as expected without errors