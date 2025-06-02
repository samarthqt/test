Feature: Verify live chat initiation from help section
Ensure users can start live chat from help or contact us page on web and mobile platforms.
@TC-221
Scenario: Verify live chat initiation on web platform
Given user account with valid credentials
And user ID is 67890
When user logs into the system on web platform
Then user successfully logs into the system
And user navigates to the 'Help' section
Then help section is displayed with various support options
When user clicks on 'Live Chat' option
Then live chat window opens with greeting message
And chat availability is 24/7
When user initiates a chat by typing a message
Then message is sent and received by support agent
And user receives a response from the support agent within expected time frame
When user logs out from the web platform
Then user successfully logs out from the web platform
@TC-221
Scenario: Verify live chat initiation on mobile platform
Given user account with valid credentials
When user logs into the system on mobile platform
Then user successfully logs into the system
And user navigates to the 'Contact Us' page
Then contact us page is displayed with support options
When user selects 'Live Chat' option
Then live chat window opens on mobile with greeting message
When user initiates a chat by typing a message
Then message is sent and received by support agent
And user receives a response from the support agent within expected time frame
@TC-221
Scenario: Verify chat history consistency across platforms
Given user has initiated and received responses from live chat on both web and mobile platforms
When user checks chat history for both platforms
Then chat history is consistent across web and mobile
@TC-221
Scenario: Ensure chat functionality under different network conditions
Given user is in varying network conditions
When user initiates a live chat
Then chat remains functional under varying network conditions
@TC-221
Scenario: Verify system logs for chat initiation
Given user has initiated a chat
When user verifies system logs
Then logs contain entries for chat initiation and messages exchanged
@TC-221
Scenario: Check UI for accessibility and ease of use
Given user is on the live chat section
When user checks UI for accessibility and ease of use
Then UI is accessible and user-friendly for chat initiation