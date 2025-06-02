Feature: Unauthorized Access to Admin Dashboard
@TC-94
Scenario: Attempt unauthorized access to the admin dashboard as a logged-in regular user
Given I am logged in as a regular user with email "user@example.com" and password "userpass123"
When I attempt to access the admin dashboard using the URL "/admin/dashboard"
Then I should see an error message indicating insufficient permissions
And I should be redirected to the user dashboard
@TC-94
Scenario: Attempt to access admin dashboard features via direct URLs
Given I am logged in as a regular user
When I attempt to access admin dashboard features via direct URLs
Then I should see appropriate error messages for each feature
@TC-94
Scenario: Verify audit logs for unauthorized access attempts
Given I am logged in as a regular user
When I attempt unauthorized access to the admin dashboard
Then the audit logs should reflect denied access attempts with user details
@TC-94
Scenario: Log out from the user account
Given I am logged in as a regular user
When I log out from the user account
Then I should be successfully logged out
@TC-94
Scenario: Attempt to access the admin dashboard without logging in
Given I am not logged in
When I attempt to access the admin dashboard using the URL "/admin/dashboard"
Then I should see a login prompt
@TC-94
Scenario: Attempt to access the admin dashboard using incorrect admin credentials
Given I am not logged in
When I attempt to log in to the admin dashboard with incorrect credentials
Then I should see an error message indicating incorrect credentials
@TC-94
Scenario: System response to repeated unauthorized access attempts
Given I am logged in as a regular user
When I repeatedly attempt unauthorized access to the admin dashboard
Then the system should block further attempts after a threshold is reached
@TC-94
Scenario: Review system performance during unauthorized access attempts
Given I am logged in as a regular user
When I attempt unauthorized access to the admin dashboard
Then the system performance should remain stable and unaffected
@TC-94
Scenario: Ensure error messages are clear and user-friendly
Given I am logged in as a regular user
When I attempt unauthorized access to the admin dashboard
Then the error messages should provide clear guidance for correction
@TC-94
Scenario: Check for automatic notifications regarding unauthorized access attempts
Given I am logged in as a regular user
When I attempt unauthorized access to the admin dashboard
Then notifications should be sent to relevant stakeholders if applicable
@TC-94
Scenario: Verify security measures are updated and effective
Given I am logged in as a regular user
When I attempt unauthorized access to the admin dashboard
Then security measures should prevent unauthorized access effectively
@TC-94
Scenario: Perform security audit for unauthorized access attempts
Given I am logged in as a regular user
When I attempt unauthorized access to the admin dashboard
Then a security audit should confirm the effectiveness of existing measures
@TC-94
Scenario: Attempt authorized access using valid admin credentials
Given I am not logged in
When I log in with valid admin credentials
Then I should be successfully logged in and redirected to the admin dashboard