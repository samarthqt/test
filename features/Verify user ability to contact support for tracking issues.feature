Feature: Verify user ability to contact support for tracking issues
@TC-205
Scenario: User logs into the application and navigates to the 'Order History' section
Given the user is logged into their account
When the user navigates to the 'Order History' section
Then the 'Order History' section is displayed with a list of past orders
@TC-205
Scenario: User selects an order with tracking information available
Given the user has an order with tracking information
When the user selects an order with tracking information available
Then the order details page is displayed with tracking information visible
@TC-205
Scenario: User identifies an issue with the tracking information
Given the user is on the order details page
When the user identifies an issue with the tracking information, such as incorrect updates
Then the issue with tracking information is identified
@TC-205
Scenario: User navigates to the 'Help & Support' section from the dashboard
Given the user is on the dashboard
When the user navigates to the 'Help & Support' section
Then the 'Help & Support' section is displayed with contact options
@TC-205
Scenario: User selects 'Live Chat' as the contact method
Given the user is in the 'Help & Support' section
When the user selects 'Live Chat' as the contact method
Then the Live Chat interface is displayed for user interaction
@TC-205
Scenario: User initiates a chat session and describes the tracking issue to support
Given the Live Chat interface is displayed
When the user initiates a chat session and describes the tracking issue to support
Then the chat session is initiated and the issue is communicated to support
@TC-205
Scenario: Support acknowledges the issue and provides possible solutions
Given the user has communicated the issue to support
When support acknowledges the issue
Then support provides solutions or next steps
@TC-205
Scenario: User tests alternative contact methods like email or phone for tracking issues
Given the user has identified a tracking issue
When the user tests alternative contact methods like email or phone
Then the user is able to contact support via alternative methods successfully
@TC-205
Scenario: Check the response time and effectiveness of support in resolving tracking issues
Given the user has contacted support
When checking the response time and effectiveness of support
Then support responds within acceptable time limits and resolves the issue effectively
@TC-205
Scenario: Verify that tracking issue resolution is communicated back to the user
Given the tracking issue has been resolved
When support communicates the resolution back to the user
Then the resolution of the tracking issue is communicated back to the user
@TC-205
Scenario: Test the usability of the support interface for reporting tracking issues
Given the user is accessing the support interface
When testing the usability of the support interface
Then the support interface is user-friendly and easy to navigate for reporting issues
@TC-205
Scenario: Ensure that support contact options are accessible from both desktop and mobile platforms
Given the user is on the application
When accessing support contact options
Then support contact options are accessible and functional on both platforms
@TC-205
Scenario: Verify that user authentication is required before contacting support
Given the user is attempting to contact support
When verifying user authentication
Then user authentication is required and verified before contacting support
@TC-205
Scenario: Check the security of user information during support interaction
Given the user is interacting with support
When checking the security of user information
Then user information is securely handled during support interaction
@TC-205
Scenario: Confirm that support is available during specified hours for tracking issues
Given the user needs support for tracking issues
When checking support availability
Then support is available during specified hours and ready to assist with tracking issues