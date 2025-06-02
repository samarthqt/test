Feature: User successfully changes password meeting all security criteria
@TC-128
Scenario: User changes password successfully
Given the user is logged into the account
When the user navigates to the account settings page
Then the account settings page is displayed
When the user clicks on the 'Change Password' option
Then the change password form is displayed
When the user enters the current password "CurrentPassword123!" in the 'Current Password' field
Then the current password is entered successfully
When the user enters the new password "NewPassword456@" in the 'New Password' field
And the user re-enters the new password "NewPassword456@" in the 'Confirm New Password' field
Then the new password is confirmed successfully
When the user clicks on the 'Submit' button
Then the password change request is submitted
And a success message is displayed confirming the password change
When the user logs out of the account
Then the user is logged out successfully
When the user logs in using the new password "NewPassword456@"
Then the user logs in successfully with the new password
When the user accesses account settings to verify password change
Then the account settings reflect the new password change
When the user ensures the new password meets security criteria (e.g., length, special character)
Then the new password meets all security criteria
When the user checks if the old password "CurrentPassword123!" is no longer valid
Then the old password does not allow login
When the user attempts to change the password again using the same steps
Then the password change process repeats successfully
When the user verifies the system logs for password change activity
Then the system logs show the password change activity
When the user checks for any security alerts related to password change
Then no security alerts are triggered