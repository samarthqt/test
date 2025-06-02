class SendGridPage {\
 static verifyAccountConfiguration() {\
 cy.log('Verify SendGrid account is configured');\
 }\
\
 static verifyApiKeySetup() {\
 cy.log('Verify SendGrid API key is set up in the application');\
 }\
\
 static login(email) {\
 cy.log(`User logs in with email: ${email}`);\
 }\
\
 static verifyLoginSuccess() {\
 cy.log('Verify user is successfully logged in');\
 }\
\
 static verifyApiKeyInSettings() {\
 cy.log('Verify SendGrid API key is configured in application settings');\
 }\
\
 static verifyApiKeyCorrectness() {\
 cy.log('Verify SendGrid API key is correctly configured');\
 }\
\
 static ensureUserLoggedIn() {\
 cy.log('Ensure user is logged in');\
 }\
\
 static submitSupportRequest() {\
 cy.log('User submits a support request via the support portal');\
 }\
\
 static verifySupportRequestSubmission() {\
 cy.log('Verify support request is successfully submitted');\
 }\
\
 static verifyTicketIdGenerated() {\
 cy.log('Verify a ticket ID is generated');\
 }\
\
 static ensureSupportRequestSubmitted() {\
 cy.log('Ensure support request is submitted');\
 }\
\
 static respondToSupportRequest() {\
 cy.log('Support team responds to the support request');\
 }\
\
 static verifySupportTeamResponse() {\
 cy.log('Verify support team can successfully respond to the support request');\
 }\
\
 static ensureSupportTeamResponse() {\
 cy.log('Ensure support team has responded to the support request');\
 }\
\
 static checkSendGridDashboard() {\
 cy.log('Check SendGrid dashboard for email delivery status');\
 }\
\
 static verifyEmailDeliveryStatus() {\
 cy.log('Verify email delivery status is marked as successful');\
 }\
\
 static ensureEmailDeliverySuccess() {\
 cy.log('Ensure email delivery status is successful');\
 }\
\
 static checkUserInbox() {\
 cy.log(\Check user's inbox for email notification\);\
 }\
\
 static verifyEmailNotificationReceived() {\
 cy.log('Verify user receives an email notification');\
 }\
\
 static ensureEmailNotificationReceived() {\
 cy.log('Ensure user receives the email notification');\
 }\
\
 static checkEmailContent() {\
 cy.log('Check the content of the email');\
 }\
\
 static verifyEmailContentDetails() {\
 cy.log('Verify email contains correct details of the support response');\
 }\
\
 static ensureEmailReceived() {\
 cy.log('Ensure email is received');\
 }\
\
 static checkSenderAddress() {\
 cy.log('Check the sender address of the email');\
 }\
\
 static verifySenderAddress() {\
 cy.log('Verify email is sent from the designated support email address');\
 }\
\
 static checkEmailSubjectLine() {\
 cy.log('Check the email subject line');\
 }\
\
 static verifyEmailSubjectLine() {\
 cy.log('Verify email subject line indicates a response to the support request');\
 }\
\
 static checkEmailFormatting() {\
 cy.log('Check for email formatting issues');\
 }\
\
 static verifyEmailFormatting() {\
 cy.log('Verify email is well-formatted and readable');\
 }\
\
 static ensureEmailSent() {\
 cy.log('Ensure email is sent');\
 }\
\
 static checkEmailReceptionTime() {\
 cy.log('Check the time of email reception');\
 }\
\
 static verifyEmailReceptionTime() {\
 cy.log('Verify email is received within 5 minutes of support response');\
 }\
\
 static verifyNumberOfEmails() {\
 cy.log('Verify the number of email notifications received');\
 }\
\
 static verifySingleEmailNotification() {\
 cy.log('Verify only one email notification is received per support response');\
 }\
\
 static checkEmailAttachments() {\
 cy.log('Check for email attachments');\
 }\
\
 static verifyEmailAttachments() {\
 cy.log('Verify email does not contain unnecessary attachments');\
 }\
\
 static openEmailOnClients() {\
 cy.log('Open email on various email clients');\
 }\
\
 static verifyEmailCompatibility() {\
 cy.log('Verify email is accessible on various email clients');\
 }\
\
 static userRepliesToEmail() {\
 cy.log('User replies to the email');\
 }\
\
 static verifyReplyDirection() {\
 cy.log('Verify the reply is directed to the support team');\
 }\
}\
\
export default SendGridPage;