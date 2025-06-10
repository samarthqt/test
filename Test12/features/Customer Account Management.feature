Feature: Customer Account Management
@18
Scenario: Recover password via email
Given a user wants to recover their password
When the user selects the "Recover Password" option
And the user chooses to receive recovery details via email
Then the system sends a recovery email to the user's registered email address
And the user can reset their password using the link in the email
@18
Scenario: Recover password via SMS
Given a user wants to recover their password
When the user selects the "Recover Password" option
And the user chooses to receive recovery details via SMS
Then the system sends a recovery SMS to the user's registered phone number
And the user can reset their password using the code in the SMS
@18
Scenario: Update personal information
Given a user wants to update their personal information
When the user navigates to the account settings
And the user updates their name, address, or phone number
Then the system saves the updated information successfully
And the changes are reflected in the user's account details
@18
Scenario: Change password with validation
Given a user wants to change their password
When the user navigates to the change password section
And the user enters their current password and a new password
Then the system validates the new password for security
And the system updates the password if validation passes
And the user receives a confirmation of the password change
@18
Scenario: View order history
Given a user wants to view their past orders
When the user navigates to the order history section
Then the system displays a list of past orders with details
And each order shows the order date, items, and status
@18
Scenario: Track order delivery status
Given a user wants to track their order delivery
When the user navigates to the order tracking section
And the user enters their tracking number
Then the system displays the current delivery status of the order
@18
Scenario: Manage wishlist
Given a user wants to manage their wishlist
When the user navigates to the wishlist section
And the user adds an item to the wishlist
Then the system adds the item to the user's wishlist
When the user removes an item from the wishlist
Then the system removes the item from the user's wishlist
@18
Scenario: Log actions for auditing purposes
Given a user performs any account management action
Then the system logs the action for auditing purposes
And the log includes details of the action performed
@18
Scenario: Handle errors gracefully
Given a user encounters an error while managing their account
Then the system handles the error gracefully
And the system provides a user-friendly error message
@18
Scenario: Comply with GDPR for data protection
Given a user manages their account
Then the system ensures compliance with GDPR
And the user's data is protected according to GDPR standards