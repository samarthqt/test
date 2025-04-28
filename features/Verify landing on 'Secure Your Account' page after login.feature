Feature: Verify landing on 'Secure Your Account' page after login
Scenario: User lands on the 'Secure Your Account' page after login
Given the user has a valid account
And account security settings are configured
When the user navigates to the login page
Then the login page is displayed
When the user enters email "user@example.com" in the email field
Then the email is entered correctly
When the user enters password "correct_password" in the password field
Then the password is entered correctly
When the user clicks on the 'Login' button
Then the user is authenticated and redirected to the 'Secure Your Account' page
Then the content and layout of the 'Secure Your Account' page are correct
And no security-related alerts or messages are displayed
And security options are available and functional
And no broken links or errors are found
Scenario: User logs out and repeats login process
When the user logs out from the account
Then the user is logged out successfully
When the user repeats the login process
Then the user consistently lands on the 'Secure Your Account' page
Scenario: Verify cross-device consistency
When the user attempts login from a different device
Then the user lands on the 'Secure Your Account' page on the different device
Scenario: System logs and security compliance
When the system logs are checked for any errors related to page redirection
Then no errors related to page redirection are found in system logs
When the page's compliance with security standards is verified
Then the page complies with security standards
Scenario: Page performance and updates
When the page load time is checked
Then the page load time is within the expected time frame
When the page content is checked for updates or changes
Then the page content is up-to-date and correct