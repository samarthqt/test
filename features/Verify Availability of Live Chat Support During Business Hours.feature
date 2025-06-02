Feature: Verify Availability of Live Chat Support During Business Hours
@TC-97
Scenario: Verify live chat support is available during business hours
Given the user is logged into the application using valid credentials
And the live chat feature is enabled
When the user navigates to the support or help section of the application
Then the support section is displayed with all available options
And business hours information is visible
And the live chat support option is visible and accessible
@TC-97
Scenario: Initiate a live chat session during business hours
Given the user locates the live chat support option
When the user initiates a live chat session during business hours
Then the live chat session is initiated successfully with an available agent
@TC-97
Scenario: Send a message to the live chat agent
Given a live chat session is initiated
When the user sends a message to the live chat agent
Then the message is sent successfully
And the agent responds in a timely manner
@TC-97
Scenario: Verify the response time of the live chat agent
Given a message is sent to the live chat agent
When the agent responds
Then the response time is within acceptable limits as per business standards
@TC-97
Scenario: Check for automated messages or acknowledgments
Given a live chat session is active
When the user receives messages
Then automated messages or acknowledgments are appropriate and informative
@TC-97
Scenario: Test live chat functionality with different types of inquiries
Given a live chat session is active
When the user sends different types of inquiries
Then all types of inquiries are handled appropriately by the live chat agent
@TC-97
Scenario: End the live chat session
Given a live chat session is active
When the user attempts to end the live chat session
Then the live chat session ends successfully with a confirmation message
@TC-97
Scenario: Re-initiate the live chat session to test repeated access
Given the user has ended a live chat session
When the user re-initiates the live chat session during business hours
Then live chat can be re-initiated without issues
@TC-97
Scenario: Verify the availability of live chat outside business hours
Given the user navigates to the support section outside business hours
When the user attempts to initiate a live chat session
Then live chat support is unavailable or provides an appropriate message
@TC-97
Scenario: Check the live chat feature on different devices/browsers
Given the user has access to different devices/browsers
When the user tests the live chat feature on these devices/browsers
Then live chat is accessible and functional across different devices/browsers
@TC-97
Scenario: Test the live chat feature with a slow internet connection
Given the user has a slow internet connection
When the user initiates a live chat session
Then live chat remains functional, albeit with possible delays
@TC-97
Scenario: Verify live chat session history is saved for future reference
Given the user has completed a live chat session
When the user checks the session history
Then chat history is saved and accessible for future reference
@TC-97
Scenario: Check for error messages or logs during live chat sessions
Given a live chat session is active
When the user monitors for errors
Then no error messages or logs indicate issues during live chat sessions