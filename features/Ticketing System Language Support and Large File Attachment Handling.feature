Feature: Ticketing System Language Support and Large File Attachment Handling
@TC-229
Scenario: Verify ticket submission page loads successfully
Given the user has access to the ticketing system
When the user navigates to the ticket submission page
Then the ticket submission page loads successfully
@TC-229
Scenario: Change language preference to French
Given the ticket submission page is loaded
When the user selects the language preference as French
Then the system interface changes to French language
@TC-229
Scenario: Enter ticket details in French
Given the system interface is in French language
When the user enters ticket details in French
Then the ticket details are entered in French
@TC-229
Scenario: Attach a large file (50MB) to the ticket submission
Given the ticket details are entered in French
When the user attaches a large file of 50MB to the ticket submission
Then the system accepts the large file without error
@TC-229
Scenario: Submit the ticket with the attached file
Given the large file is attached to the ticket
When the user submits the ticket with the attached file
Then the ticket is submitted successfully with the large file attachment
@TC-229
Scenario: Verify confirmation message in French
Given the ticket is submitted successfully
When the system generates a confirmation message
Then the confirmation message is displayed in French
@TC-229
Scenario: Check ticket status in the system
Given the ticket is submitted
When the user checks the ticket status in the system
Then the ticket appears in the system with a status indicating successful submission
@TC-229
Scenario: Retrieve the attached file
Given the ticket is submitted with an attachment
When the user attempts to retrieve the attached file
Then the attached file can be retrieved and viewed successfully
@TC-229
Scenario: Ensure system logs language preference and file attachment details
Given the ticket is submitted
When the system logs the submission details
Then the system logs include the language preference and file attachment details
@TC-229
Scenario: Submit another ticket in Spanish language
Given the user has completed a ticket submission
When the user attempts to submit another ticket in Spanish language
Then the system interface changes to Spanish language successfully
@TC-229
Scenario: Attach a different large file (75MB) to the ticket submission
Given the system interface is in Spanish language
When the user attaches a different large file of 75MB to the ticket submission
Then the system accepts the 75MB file without error
@TC-229
Scenario: Submit the ticket with the new file attachment
Given the new file is attached to the ticket
When the user submits the ticket with the new file attachment
Then the ticket is submitted successfully with the new file attachment
@TC-229
Scenario: Verify system's handling of multiple languages during ticket retrieval
Given the ticket is submitted in Spanish
When the user retrieves the ticket
Then the system displays ticket details in the selected language during retrieval
@TC-229
Scenario: Check for performance issues during file attachment
Given large files are being attached to tickets
When the user observes the system performance
Then the system handles large file attachments efficiently without performance degradation
@TC-229
Scenario: Ensure system supports language switching without loss of data
Given the user has submitted tickets in multiple languages
When the user switches language preferences
Then language switching does not affect the integrity of the ticket data