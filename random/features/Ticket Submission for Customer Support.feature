Feature: Ticket Submission for Customer Support
Scenario: User submits a ticket via the support form
Given the user is on the customer support page
When the user fills in the contact details and issue description fields
And the user submits the ticket form
Then the user should receive a confirmation email upon ticket submission
Scenario: Support staff views and responds to a ticket
Given the support staff has access to the ticket management system
When a new ticket is submitted
Then the support staff should be able to view the ticket
And respond to the ticket within 24 hours
Scenario: User tracks the status of their submitted ticket
Given the user has submitted a ticket
When the user navigates to the ticket tracking page
Then the user should be able to view the status of their submitted ticket
Scenario: System handles concurrent ticket submissions
Given multiple users are submitting tickets simultaneously
When the system receives up to 500 concurrent ticket submissions
Then the system should handle the submissions without performance issues