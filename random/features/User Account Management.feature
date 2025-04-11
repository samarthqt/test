Feature: User Account Management
Scenario: View complete order history
Given a registered user is logged into their account
When the user navigates to the order history page
Then the user should see a list of all their past orders
And the order details should include products, prices, and purchase dates
Scenario: Track order status in real-time
Given a registered user has placed an order
When the user views the order status
Then the status should be updated in real-time
And notifications should inform the user of any changes in order status
Scenario: Manage wishlist by adding items
Given a registered user is logged into their account
When the user adds an item to their wishlist
Then the item should be added to the wishlist
And the change should be saved immediately
Scenario: Manage wishlist by removing items
Given a registered user has items in their wishlist
When the user removes an item from their wishlist
Then the item should be removed from the wishlist
And the change should be saved immediately
Scenario: Display error messages for invalid operations
Given a registered user is logged into their account
When the user performs an invalid operation
Then an appropriate error message should be displayed
Scenario: Logging user interactions with order history and wishlist
Given a registered user is logged into their account
When the user views their order history or modifies their wishlist
Then the interactions should be logged for audit and tracking purposes