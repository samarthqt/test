Feature: Verify email notifications for support responses
@TC-25
Scenario: Submit a support request via the support portal
Given the user has a registered email address "user@example.com"
When the user submits a support request via the support portal
Then the support request is successfully submitted
And a ticket ID is generated
@TC-25
Scenario: Ensure the system is configured to send email notifications for support responses
Given the system configuration settings confirm email notifications are enabled
And the support ticket ID is "12345"
Then email notifications should be sent for support responses
@TC-25
Scenario: Respond to the support request from the support team dashboard
Given the support team dashboard is accessible
When the support team responds to the support request
Then the response should be successful
@TC-25
Scenario: Check the user's email inbox for notification
Given the support team has responded to the support request
When the user checks their email inbox
Then the user should receive an email notification about the support response
@TC-25
Scenario: Verify the content of the email notification
Given the user has received an email notification
When the user opens the email
Then the email should contain the correct details of the support response
@TC-25
Scenario: Ensure the email is sent from the correct support email address
Given the user has received an email notification
When the user checks the sender's email address
Then the email should be sent from the designated support email address
@TC-25
Scenario: Check the email subject line for relevance
Given the user has received an email notification
When the user checks the email subject line
Then the subject line should clearly indicate a response to the support request
@TC-25
Scenario: Verify the email contains a link to the support request
Given the user has received an email notification
When the user checks the email content
Then the email should include a link that redirects to the support request in the portal
@TC-25
Scenario: Ensure the email is delivered within a reasonable time frame
Given the support team has responded to the support request
When the user checks their email inbox
Then the email should be received within 5 minutes of the support response
@TC-25
Scenario: Check for any email formatting issues
Given the user has received an email notification
When the user opens the email
Then the email should be well-formatted and readable
@TC-25
Scenario: Confirm the email is not marked as spam
Given the user has received an email notification
When the user checks their spam/junk folder
Then the email should be delivered to the inbox and not the spam/junk folder
@TC-25
Scenario: Verify that no duplicate emails are received for the same response
Given the user has received an email notification
When the user checks their email inbox
Then only one email notification should be received per support response
@TC-25
Scenario: Check the email for any attachments
Given the user has received an email notification
When the user checks the email content
Then the email should not contain any unnecessary attachments unless specified
@TC-25
Scenario: Ensure the email can be opened on different email clients
Given the user has received an email notification
When the user opens the email on various email clients
Then the email should be accessible and correctly displayed
@TC-25
Scenario: Verify user can reply to the email
Given the user has received an email notification
When the user replies to the email
Then the reply should be directed to the support team