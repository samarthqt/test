Feature: Loyalty Program
TCID:25
""
As a user, I want to participate in a loyalty program that offers rewards and discounts for frequent purchases so that I can save money and gain additional benefits.
""
Background:
Given the user is logged into their account
""
Scenario: Enroll in the Loyalty Program
Given the user is on the User Account page
When the user opts to join the Loyalty Program
Then the user should be successfully enrolled in the Loyalty Program
And the user should receive a confirmation message
""
Scenario: Earn Points on Purchases
Given the user is enrolled in the Loyalty Program
When the user makes a purchase
Then the user should earn loyalty points for the purchase
And the points should be reflected in the user's account
""
Scenario: Redeem Points for Discounts
Given the user has accumulated loyalty points
When the user chooses to redeem points for a discount
Then the discount should be applied to the user's purchase
And the redeemed points should be deducted from the user's account
""
Scenario: View Loyalty Points Balance
Given the user is enrolled in the Loyalty Program
When the user navigates to the Loyalty section of their account
Then the user should see their current loyalty points balance
""
Scenario: Receive Notifications for Loyalty Offers
Given the user is enrolled in the Loyalty Program
When there are new rewards or discounts available
Then the user should receive a notification about the new offers
""
Scenario: Unenroll from the Loyalty Program
Given the user is enrolled in the Loyalty Program
When the user opts to leave the Loyalty Program
Then the user should be successfully unenrolled from the Loyalty Program
And the user should receive a confirmation message
```gherkin
TCID:26