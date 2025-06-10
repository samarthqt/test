Feature: Subscription Services for Regular Product Deliveries
@82
Scenario: User subscribes to regular product deliveries
Given a user is logged into their account
When the user navigates to the subscription services section
And the user selects a product to subscribe to
And the user chooses a delivery frequency option (e.g., weekly, monthly)
Then the user should be subscribed to the regular product deliveries
@82
Scenario: User receives notifications for upcoming deliveries
Given a user is subscribed to regular product deliveries
When a delivery date is approaching
Then the user should receive a notification for the upcoming delivery
@82
Scenario: User accesses subscription management from their account
Given a user is logged into their account
When the user navigates to the subscription management section
Then the user should be able to view and manage their subscriptions
@82
Scenario: User cancels a subscription
Given a user is subscribed to regular product deliveries
When the user navigates to the subscription management section
And the user selects a subscription to cancel
Then the subscription should be successfully canceled
@82
Scenario: User modifies a subscription
Given a user is subscribed to regular product deliveries
When the user navigates to the subscription management section
And the user selects a subscription to modify
And the user changes the delivery frequency or product
Then the subscription should be successfully updated with the new details