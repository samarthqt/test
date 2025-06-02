Feature: Cancel Order After Expiration Period
@TC-80
Scenario: Attempt to cancel an order after the cancellation period has expired
Given the user logs in to the account with User ID 78910
When the user navigates to the 'Order History' section
Then the order history page is displayed with a list of past orders
And the user selects the order with Order ID 123456
Then the order details page is displayed for Order ID 123456
And the cancellation period is 7 days
When the user attempts to cancel the order
Then the system displays a message indicating that the cancellation period has expired and the order cannot be canceled
And the cancellation button is disabled and cannot be clicked
When the user checks for any alternative actions suggested by the system
Then the system suggests contacting customer support for further assistance
When the user navigates to the customer support section
Then customer support contact information is displayed
When the user attempts to contact customer support via provided options
Then customer support is contacted successfully
When the user verifies any email notification received regarding the cancellation attempt
Then an email notification is received stating the cancellation attempt and its status
When the user checks the order status after the cancellation attempt
Then the order status remains unchanged as 'Processing' or 'Completed'
When the user reviews any system logs related to the cancellation attempt
Then system logs indicate the cancellation attempt and its rejection due to expired period
When the user verifies the account does not show any unauthorized changes
Then user account details remain unchanged and secure
When the user checks if any refund process is initiated mistakenly
Then no refund process is initiated as the cancellation was not successful
@TC-80
Scenario: Attempt to cancel another order within the valid period
Given the user logs in to the account with User ID 78910
When the user selects another order within the valid cancellation period
Then the system allows cancellation and updates the order status accordingly
@TC-80
Scenario: Verify the system's response time to the cancellation attempt
Given the user logs in to the account with User ID 78910
When the user attempts to cancel an order
Then the system responds promptly to the cancellation attempt with appropriate feedback