Feature: Verify Live Chat Support Availability
@TC-21
Scenario: Ensure live chat support is available for real-time assistance
Given the user is logged into the application
When the user navigates to the homepage of the application
Then the homepage is displayed with all navigation options
@TC-21
Scenario: Locate and access the 'Live Chat' option
Given the user is on the homepage
When the user locates the 'Live Chat' option
Then the 'Live Chat' option is visible and accessible
@TC-21
Scenario: Open the live chat window
Given the 'Live Chat' option is visible
When the user clicks on the 'Live Chat' option
Then the live chat window opens with a welcome message
@TC-21
Scenario: Enter and send a query through the chat
Given the live chat window is open
When the user enters a query into the chat window
Then the chat window accepts input and displays the entered query
When the user sends the query through the chat
Then the query is sent successfully and a response is received
@TC-21
Scenario: Verify response time of the live chat
Given a query has been sent
When the user waits for a response
Then the response is received within expected time frame
@TC-21
Scenario: Check for error messages during chat session
Given the chat session is ongoing
When the user interacts with the chat
Then no error messages are displayed
@TC-21
Scenario: Close and reopen the live chat window
Given the live chat window is open
When the user closes the live chat window
Then the live chat window closes without errors
When the user reopens the live chat window
Then the live chat window opens again successfully
@TC-21
Scenario: Access live chat support outside business hours
Given the time is outside business hours
When the user attempts to access live chat support
Then live chat is unavailable, and a message indicating hours of operation is displayed
@TC-21
Scenario: Check if live chat transcripts are saved
Given the chat session has ended
When the user checks the user profile
Then transcripts are saved and accessible in user profile
@TC-21
Scenario: Verify chat window compatibility with different browsers
Given the application supports multiple browsers
When the user accesses the chat window on different browsers
Then the chat window functions correctly across different browsers
@TC-21
Scenario: Ensure chat support is available on mobile devices
Given the user accesses the application on a mobile device
When the user opens the live chat window
Then live chat functions properly on mobile devices
@TC-21
Scenario: Use live chat with multiple users simultaneously
Given multiple users are logged into the application
When multiple users use live chat simultaneously
Then the system handles multiple chat sessions without performance degradation
@TC-21
Scenario: Check if live chat support is integrated with CRM systems
Given the chat session is ongoing
When the user interacts with the chat
Then chat interactions are logged in CRM systems for future reference