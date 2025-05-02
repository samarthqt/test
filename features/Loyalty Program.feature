Feature: Loyalty Program
The loyalty program offers rewards and discounts for frequent purchases, encouraging customer retention.
Scenario: Customer enrolls in the loyalty program
Given a customer is not enrolled in the loyalty program
When the customer enrolls in the loyalty program
Then the customer should receive a confirmation of enrollment
And the customer should see the loyalty program details in their account
Scenario: Customer makes a purchase as a loyalty member
Given a customer is enrolled in the loyalty program
And the customer is logged into their account
When the customer makes a purchase
Then the customer should earn loyalty points for the purchase
And the customer should receive any applicable discounts
Scenario: Customer redeems loyalty points for a reward
Given a customer has sufficient loyalty points
When the customer chooses to redeem points for a reward
Then the loyalty points should be deducted from the customer's account
And the customer should receive the chosen reward
Scenario: Customer receives a discount for frequent purchases
Given a customer has made frequent purchases
And the customer is enrolled in the loyalty program
When the customer makes another purchase
Then the customer should receive a discount based on their purchase frequency
Scenario: Customer queries their loyalty points balance
Given a customer is enrolled in the loyalty program
When the customer checks their loyalty points balance
Then the customer should see the correct number of loyalty points in their account
Scenario: Customer receives notification of loyalty program updates
Given a customer is enrolled in the loyalty program
When there is an update to the loyalty program
Then the customer should receive a notification about the update