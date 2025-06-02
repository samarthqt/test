Feature: Verify integration with SendGrid for email notifications
@TC-29
Scenario: Ensure integration with SendGrid for sending email notifications
Given a SendGrid account is configured
And the SendGrid API key is set up in the application
When the user logs in to the application with email "user@example.com"
Then the user is successfully logged in
@TC-29
Scenario: Verify SendGrid API key configuration
Given the SendGrid API key is configured in the application settings
Then the SendGrid API key is correctly configured
@TC-29
Scenario: Submit a support request
Given the user has logged in
When the user submits a support request via the support portal
Then the support request is successfully submitted
And a ticket ID is generated
@TC-29
Scenario: Respond to the support request
Given the support request is submitted
When the support team responds to the support request from the support team dashboard
Then the support team can successfully respond to the support request
@TC-29
Scenario: Check email delivery status
Given the support team has responded to the support request
When checking the SendGrid dashboard
Then the email delivery status is marked as successful
@TC-29
Scenario: Verify email reception
Given the email delivery status is successful
When checking the user's inbox
Then the user receives an email notification about the support response
@TC-29
Scenario: Check email content correctness
Given the user receives the email notification
When checking the email content
Then the email contains the correct details of the support response
@TC-29
Scenario: Verify email sender address
Given the email is received
When checking the sender address
Then the email is sent from the designated support email address
@TC-29
Scenario: Verify email subject line
Given the email is received
When checking the email subject line
Then the email subject line clearly indicates a response to the support request
@TC-29
Scenario: Check email formatting
Given the email is received
When checking for formatting issues
Then the email is well-formatted and readable
@TC-29
Scenario: Verify email delivery time frame
Given the email is sent
When checking the time of reception
Then the email is received within 5 minutes of the support response
@TC-29
Scenario: Check for duplicate emails
Given the email is received
When verifying the number of emails
Then only one email notification is received per support response
@TC-29
Scenario: Check email attachments
Given the email is received
When checking for attachments
Then the email does not contain any unnecessary attachments unless specified
@TC-29
Scenario: Ensure email compatibility with different clients
Given the email is received
When opening the email on various email clients
Then the email is accessible and correctly displayed on various email clients
@TC-29
Scenario: Verify user can reply to the email
Given the email is received
When the user replies to the email
Then the reply is directed to the support team