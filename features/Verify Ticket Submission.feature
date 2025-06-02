Feature: Verify Ticket Submission
@TC-23
Scenario: Ensure users can submit detailed inquiries via a ticket system
Given the user is logged into the application
When the user navigates to the support section of the application
Then the support section is displayed with ticket submission option
@TC-23
Scenario: Access ticket submission form
Given the user is in the support section
When the user selects the 'Submit a Ticket' option
Then the ticket submission form is displayed with required fields
@TC-23
Scenario: Fill in the ticket submission form
Given the ticket submission form is displayed
When the user fills in the required details in the form
Then the form accepts input and displays entered details
@TC-23
Scenario: Attach documents to the ticket submission
Given the user has filled in the ticket submission form
When the user attaches relevant documents to the ticket submission
Then the documents are attached successfully without errors
@TC-23
Scenario: Submit the ticket
Given the user has completed the ticket submission form
When the user submits the ticket
Then the ticket is submitted successfully and confirmation message is displayed
@TC-23
Scenario: Verify confirmation email for ticket submission
Given the ticket is submitted successfully
When the user checks their email
Then a confirmation email is received with ticket details
@TC-23
Scenario: Check for error messages during ticket submission
Given the user is submitting a ticket
When the user completes the submission process
Then no error messages are displayed
@TC-23
Scenario: Submit a ticket with incomplete details
Given the user is filling in the ticket submission form
When the user attempts to submit the form with incomplete details
Then the system prompts for missing required fields
@TC-23
Scenario: Verify ticket submission functionality on mobile devices
Given the user is accessing the application on a mobile device
When the user navigates to the support section and selects 'Submit a Ticket'
Then the ticket submission form is accessible and functional on mobile devices
@TC-23
Scenario: Check if ticket submissions are logged in CRM systems
Given the user has submitted a ticket
When the system processes the ticket
Then the submitted tickets are recorded in CRM systems for future reference
@TC-23
Scenario: Verify the ticket system's compatibility with different browsers
Given the user is accessing the application on different browsers
When the user navigates to the ticket submission form
Then the ticket system functions correctly across different browsers
@TC-23
Scenario: Test the ticket system's response time
Given the user submits a ticket
When the system processes the ticket
Then the ticket system processes submissions within expected time frame
@TC-23
Scenario: Ensure ticket submission is available during peak times
Given the system is experiencing peak times
When the user submits a ticket
Then the system handles ticket submissions without performance degradation
@TC-23
Scenario: Check if users can view submitted ticket status
Given the user has submitted a ticket
When the user accesses the ticket status section
Then users can access and view the status of their submitted tickets
@TC-23
Scenario: Attempt to submit multiple tickets simultaneously
Given the user is submitting multiple tickets
When the user submits the tickets simultaneously
Then the system processes multiple ticket submissions without errors