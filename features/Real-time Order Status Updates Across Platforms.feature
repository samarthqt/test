Feature: Real-time Order Status Updates Across Platforms
@TC-344
Scenario: Ensure order status updates are reflected in real-time across web and mobile platforms
Given the user has placed an order with ID "ORD12345"
And the order tracking system is integrated with web and mobile platforms
And the user logs in to the web platform using valid credentials
Then the user is successfully logged in and redirected to the dashboard
@TC-344
Scenario: Navigate to Order History on the web platform
Given the user is on the dashboard
When the user navigates to the 'Order History' section
Then the order history page is displayed with a list of past orders
@TC-344
Scenario: View order details on the web platform
Given the order history page is displayed
When the user selects the order with ID "ORD12345"
Then the order details page is displayed showing the current status
@TC-344
Scenario: Update order status to 'Shipped' in the backend
Given the order details page is displayed
When the order status is updated to 'Shipped' in the backend system
Then the order status is updated in the backend system
@TC-344
Scenario: Verify real-time update of order status on the web platform
Given the order status is updated to 'Shipped' in the backend system
When the user refreshes the order details page on the web platform
Then the order status is updated to 'Shipped' in real-time on the web platform
@TC-344
Scenario: Log in to the mobile app
Given the user has the mobile app version 1.0.0
When the user opens the mobile app and logs in using valid credentials
Then the user is successfully logged in and redirected to the mobile app dashboard
@TC-344
Scenario: Navigate to Order History in the mobile app
Given the user is on the mobile app dashboard
When the user navigates to the 'Order History' section in the mobile app
Then the order history page is displayed with a list of past orders in the mobile app
@TC-344
Scenario: View order details in the mobile app
Given the order history page is displayed in the mobile app
When the user selects the order with ID "ORD12345" in the mobile app
Then the order details page is displayed showing the current status in the mobile app
@TC-344
Scenario: Verify real-time update of order status in the mobile app
Given the order status is updated to 'Shipped' in the backend system
When the user verifies the order status in the mobile app
Then the order status is updated to 'Shipped' in real-time in the mobile app
@TC-344
Scenario: Update order status to 'Delivered' in the backend
Given the order status is 'Shipped'
When the order status is changed to 'Delivered' in the backend system
Then the order status is updated in the backend system
@TC-344
Scenario: Verify real-time update of order status to 'Delivered' on the web platform
Given the order status is updated to 'Delivered' in the backend system
When the user refreshes the order details page on the web platform
Then the order status is updated to 'Delivered' in real-time on the web platform
@TC-344
Scenario: Verify real-time update of order status to 'Delivered' in the mobile app
Given the order status is updated to 'Delivered' in the backend system
When the user refreshes the order details page in the mobile app
Then the order status is updated to 'Delivered' in real-time in the mobile app
@TC-344
Scenario: Verify notifications for status updates
Given the order status changes to 'Shipped' and 'Delivered'
When notifications are sent to the user
Then the user receives notifications for 'Shipped' and 'Delivered' status updates
@TC-344
Scenario: Check consistency of order status across platforms
Given the order status is 'Delivered' on both platforms
When the user checks the order status consistency
Then the order status is consistent across web and mobile platforms
@TC-344
Scenario: Log out from both web and mobile platforms
Given the user is logged in on both platforms
When the user logs out from both web and mobile platforms
Then the user is successfully logged out from both platforms