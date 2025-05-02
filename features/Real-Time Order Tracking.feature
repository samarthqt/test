Feature: Real-Time Order Tracking
Scenario: User views order tracking information after purchase
Given a user has completed a purchase
When the user navigates to the order tracking page
Then the user should see the real-time status of their order
Scenario: User receives notification when order status changes
Given a user has an active order
When the order status changes
Then the user should receive a notification about the status change
Scenario: User checks estimated delivery date
Given a user is viewing their order tracking information
When the user looks at the estimated delivery date
Then the user should see an accurate estimated delivery date based on current order status
Scenario: User views detailed order tracking history
Given a user is on the order tracking page
When the user selects the option to view tracking history
Then the user should see a detailed history of all status updates for their order
Scenario: User encounters an error while accessing order tracking
Given a user is trying to access the order tracking page
When there is a system error or outage
Then the user should see an appropriate error message indicating the issue
Scenario: User verifies delivery address for order
Given a user is viewing their order tracking information
When the user checks the delivery address
Then the user should see the correct delivery address associated with their order
Scenario: User updates contact information for order notifications
Given a user wants to update their contact information for order notifications
When the user navigates to the contact information settings
Then the user should be able to update their contact information successfully
Scenario: User accesses order tracking from mobile device
Given a user is using a mobile device
When the user accesses the order tracking feature
Then the user should have a mobile-friendly experience with all functionalities available
Scenario: User views order tracking in multiple languages
Given a user prefers to view order tracking in a different language
When the user changes the language settings
Then the order tracking information should be displayed in the selected language