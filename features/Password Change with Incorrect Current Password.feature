Feature: Password Change with Incorrect Current Password
@TC-129
Scenario: Attempt to change password with incorrect current password
Given the user is logged into the account
When the user navigates to the account settings page
Then the account settings page is displayed
When the user clicks on the 'Change Password' option
Then the change password form is displayed
When the user enters "WrongPassword123!" in the 'Current Password' field
And the user enters "NewPassword456@" in the 'New Password' field
And the user re-enters "NewPassword456@" in the 'Confirm New Password' field
And the user clicks on the 'Submit' button
Then an error message is displayed indicating incorrect current password
When the user attempts to log out of the account
Then the user is logged out successfully
When the user attempts to log in using the new password
Then login fails with the new password
When the user attempts to log in using the old password
Then the user logs in successfully with the old password
When the user accesses account settings to verify password change attempt
Then account settings do not reflect any password change
When the system logs are checked for the failed password change attempt
Then system logs show the failed password change attempt
When ensuring no security alerts are triggered by the failed attempt
Then no security alerts are triggered
When the user attempts to change password using the correct current password
Then the password change process succeeds with correct current password
When verifying system behavior after multiple incorrect attempts
Then the system locks the account or prompts security questions after multiple failed attempts