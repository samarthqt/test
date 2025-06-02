Feature: Ticket Submission and Confirmation Notifications
@TC-227
Scenario: Verify users can submit tickets and receive confirmation notifications via Email
Given the user is logged in
When the user navigates to the Help Center page
Then the Help Center page is displayed
When the user locates the ticket submission form
Then the ticket submission form is visible and accessible
When the user enters ticket subject "Account issue"
Then the ticket subject field is populated with "Account issue"
When the user enters ticket description "Unable to login with correct credentials"
Then the ticket description field is populated correctly
When the user selects contact method "Email"
Then the Email contact method is selected
When the user submits the ticket
Then the ticket is submitted successfully
And the user receives confirmation notification "Your ticket has been submitted successfully"
@TC-227
Scenario: Verify users can submit tickets and receive confirmation notifications via Phone
Given the user is logged in
When the user navigates to the Help Center page
Then the Help Center page is displayed
When the user locates the ticket submission form
Then the ticket submission form is visible and accessible
When the user enters ticket subject "Account issue"
Then the ticket subject field is populated with "Account issue"
When the user enters ticket description "Unable to login with correct credentials"
Then the ticket description field is populated correctly
When the user selects contact method "Phone"
Then the Phone contact method is selected
When the user submits the ticket
Then the ticket is submitted successfully
And the user receives confirmation notification "Your ticket has been submitted successfully"
@TC-227
Scenario: Check system logs for ticket submission entries
Given the user has submitted a ticket
Then the ticket submission is logged correctly
@TC-227
Scenario: Verify ticket submission form validation rules
Given the user is on the ticket submission form
When the user attempts to submit the form with invalid data
Then validation rules are enforced correctly
@TC-227
Scenario: Attempt ticket submission with invalid session
Given the user has an invalid session
When the user attempts to submit a ticket
Then the ticket submission fails due to session error
@TC-227
Scenario: Test ticket submission with expired session
Given the user session has expired
When the user attempts to submit a ticket
Then the system prompts the user to re-login
@TC-227
Scenario: Submit a ticket with incorrect user credentials
Given the user has incorrect credentials
When the user attempts to submit a ticket
Then the ticket submission fails and the user is notified
@TC-227
Scenario: Verify system's response to ticket submission during peak hours
Given the system is operating during peak hours
When the user submits a ticket
Then the system handles ticket submissions efficiently
@TC-227
Scenario: Test ticket submission form accessibility features
Given the user is on the ticket submission form
When the user checks accessibility features
Then accessibility features are functional