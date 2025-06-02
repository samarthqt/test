Feature: Verify application functionality on the latest versions of Chrome, Firefox, Safari, and Edge
@TC-347
Scenario: Verify web platform loads correctly on Chrome 90
Given the latest version of Chrome 90 is installed
When the user opens the web platform on Chrome 90
Then the web platform loads correctly without any display issues
@TC-347
Scenario: Verify user login functionality on Chrome 90
Given the user has valid credentials
When the user logs in on Chrome 90
Then the user is successfully logged in
And the Order ID is ORD54321
@TC-347
Scenario: Verify 'Order History' navigation on Chrome 90
Given the user is logged in on Chrome 90
When the user navigates to the 'Order History' section
Then the order history page is displayed correctly
And the User Account is user_browser@example.com
@TC-347
Scenario Outline: Verify web platform functionality on different browsers
Given the latest version of <browser> is installed
When the user repeats steps 1-3 on <browser>
Then the web platform functions correctly on <browser>
Examples:
| browser  |
| Firefox 88 |
| Safari 14  |
| Edge 90    |
@TC-347
Scenario: Verify real-time order status updates on all browsers
Given the user is logged in on any browser
When the user checks for order status updates
Then the order status updates are consistent across all browsers
@TC-347
Scenario: Check for display issues or errors on each browser
Given the user is logged in on any browser
When the user checks for display issues or errors
Then no display issues or errors are encountered on any browser
@TC-347
Scenario: Test responsiveness and performance on each browser
Given the user is logged in on any browser
When the user tests responsiveness and performance
Then the web platform is responsive and performs well on each browser
@TC-347
Scenario: Verify user notifications for order status updates on each browser
Given the user is logged in on any browser
When the user checks for notifications of order status updates
Then users receive notifications for order status updates on each browser
@TC-347
Scenario: Check system logs for browser-specific errors
Given the user is logged in on any browser
When the user checks system logs for errors
Then no browser-specific errors are logged in the system
@TC-347
Scenario: Assess user experience on each browser
Given the user is logged in on any browser
When the user assesses the user experience
Then user experience is consistent and satisfactory on each browser
@TC-347
Scenario: Verify compatibility with browser extensions
Given the user is logged in on any browser
When the user checks compatibility with browser extensions
Then the web platform remains compatible with common browser extensions
@TC-347
Scenario: Test accessibility features on each browser
Given the user is logged in on any browser
When the user tests accessibility features
Then accessibility features function correctly on each browser
@TC-347
Scenario: Log out from the web platform on each browser
Given the user is logged in on any browser
When the user logs out from the web platform
Then the user is successfully logged out from the web platform on each browser