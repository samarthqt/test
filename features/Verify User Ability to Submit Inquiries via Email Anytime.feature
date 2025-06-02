Feature: Verify User Ability to Submit Inquiries via Email Anytime
@TC-98
Scenario: User submits an inquiry email successfully
Given the user has access to an email client
When the user opens the email client application
Then the email client opens successfully
And the user composes a new email
Then the email composition window is displayed
When the user enters the support email address in the 'To' field
Then the support email address is entered correctly
When the user enters a subject for the inquiry
Then the subject is entered correctly
When the user composes the body of the inquiry email with relevant details
Then the email body is composed with all necessary details
When the user sends the email
Then the email is sent successfully without any errors
And no delivery failure notifications are received
And an automated acknowledgment email is received confirming receipt of the inquiry
And any response from the support team is logged for reference
@TC-98
Scenario: Submit inquiry email at different times
Given the user tests submitting an inquiry email at different times of the day
Then inquiry emails can be submitted successfully at any time of the day
@TC-98
Scenario: Submit inquiry email with a large attachment
Given the user attempts to submit an inquiry with a large attachment
Then the inquiry email with attachment is sent successfully, or appropriate error is displayed if size limit is exceeded
@TC-98
Scenario: Verify support email address display
Given the user verifies the support email address is correctly displayed in the application's support section
Then the support email address is displayed correctly and is clickable
@TC-98
Scenario: Check email submission on different email clients
Given the user checks the email submission feature on different email clients
Then inquiry emails can be submitted successfully using different email clients
@TC-98
Scenario: Submit inquiry email with special characters
Given the user tests submitting an inquiry with special characters in the subject or body
Then the inquiry email with special characters is sent successfully without issues
@TC-98
Scenario: Verify email submission with slow internet
Given the user verifies the email submission feature with a slow internet connection
Then inquiry emails can be submitted successfully, albeit with possible delays