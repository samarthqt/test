Feature: Verify tracking accessibility on desktop and mobile platforms
@TC-204
Scenario: Log into the application using a desktop browser
Given the user has a valid order with tracking information available
When the user logs into the application using a desktop browser
Then the user is successfully logged into the application on a desktop browser
@TC-204
Scenario: Navigate to the 'Order History' section from the dashboard on desktop
Given the user is logged into the application on a desktop browser
When the user navigates to the 'Order History' section from the dashboard
Then the Order History section is displayed with a list of past orders
@TC-204
Scenario: Select an order with tracking information available on desktop
Given the Order History section is displayed with a list of past orders
When the user selects an order with tracking information available
Then the order details page is displayed with tracking information visible
@TC-204
Scenario: Access the tracking information link from the order details page on desktop
Given the order details page is displayed with tracking information visible
When the user accesses the tracking information link from the order details page
Then the tracking information is displayed correctly on the desktop browser
@TC-204
Scenario: Log into the application using a mobile device
Given the user has a valid order with tracking information available
When the user logs into the application using a mobile device
Then the user is successfully logged into the application on a mobile device
@TC-204
Scenario: Navigate to the 'Order History' section from the mobile dashboard
Given the user is logged into the application on a mobile device
When the user navigates to the 'Order History' section from the mobile dashboard
Then the Order History section is displayed with a list of past orders
@TC-204
Scenario: Select the same order with tracking information available on mobile
Given the Order History section is displayed with a list of past orders
When the user selects the same order with tracking information available
Then the order details page is displayed with tracking information visible on mobile
@TC-204
Scenario: Access the tracking information link from the order details page on mobile
Given the order details page is displayed with tracking information visible on mobile
When the user accesses the tracking information link from the order details page on mobile
Then the tracking information is displayed correctly on the mobile device
@TC-204
Scenario: Switch between desktop and mobile platforms and verify tracking information consistency
Given the tracking information is displayed correctly on both desktop and mobile platforms
When the user switches between desktop and mobile platforms
Then the tracking information remains consistent across both platforms
@TC-204
Scenario: Test responsiveness of tracking information layout on different screen sizes
Given the tracking information is displayed correctly on both desktop and mobile platforms
When the user views the tracking information on different screen sizes
Then the tracking information layout adjusts correctly to different screen sizes
@TC-204
Scenario: Check the loading time of tracking information on both platforms
Given the tracking information is displayed correctly on both desktop and mobile platforms
When the user accesses the tracking information
Then the tracking information loads within acceptable time limits on both platforms
@TC-204
Scenario: Verify that tracking information updates in real-time on both platforms
Given the tracking information is displayed correctly on both desktop and mobile platforms
When there are updates to the tracking information
Then the tracking information updates are reflected in real-time on both platforms
@TC-204
Scenario: Ensure that tracking information is accessible without any errors on both platforms
Given the tracking information is displayed correctly on both desktop and mobile platforms
When the user accesses the tracking information
Then no errors occur when accessing tracking information on either platform
@TC-204
Scenario: Confirm that the user interface for tracking information is user-friendly on both platforms
Given the tracking information is displayed correctly on both desktop and mobile platforms
When the user interacts with the tracking information interface
Then the user interface for tracking information is intuitive and easy to navigate on both platforms
@TC-204
Scenario: Verify the security of tracking information access on both platforms
Given the tracking information is displayed correctly on both desktop and mobile platforms
When the user accesses the tracking information
Then tracking information access is secure and requires valid user authentication on both platforms