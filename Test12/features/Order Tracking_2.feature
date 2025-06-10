Feature: Order Tracking
@78
Scenario: User accesses the order tracking page from their account
Given the user is logged into their account
When the user navigates to the order tracking page
Then the order tracking page is displayed
@78
Scenario: Order status is displayed accurately
Given the user is on the order tracking page
When the order details are loaded
Then the order status is displayed accurately
@78
Scenario: Tracking number is clickable and redirects to the shipping provider's site
Given the user is on the order tracking page
When the user clicks on the tracking number
Then the user is redirected to the shipping provider's site
@78
Scenario: Updates on order status are reflected in real-time
Given the user is on the order tracking page
When there is a change in the order status
Then the updated order status is displayed in real-time
@78
Scenario: User receives notification for any change in status
Given the user has an active order
When there is a change in the order status
Then the user receives a notification about the status change
@78
Scenario: Order tracking page is responsive and loads within 3 seconds
Given the user is accessing the order tracking page
When the page is loading
Then the page loads within 3 seconds
And the page is responsive
@78
Scenario: Security measures ensure tracking details are visible only to authorized users
Given the user is on the order tracking page
When an unauthorized user attempts to access tracking details
Then the tracking details are not visible to the unauthorized user