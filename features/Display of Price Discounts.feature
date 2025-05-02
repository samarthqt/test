Feature: Display of Price Discounts
Scenario: Display discounted price alongside original price
Given a product has an original price
And the product has a discount applied
When the product is displayed on the retail platform
Then the original price should be displayed
And the discounted price should be displayed alongside the original price
And the savings should be highlighted to the customer
Scenario: No discount on product
Given a product has an original price
And no discount is applied to the product
When the product is displayed on the retail platform
Then only the original price should be displayed
And no discounted price should be shown
Scenario: Display price in different currencies
Given a product has an original price in USD
And the product has a discount applied
When the product is displayed on the retail platform
Then the original price and discounted price should be displayed in USD
And the savings should be highlighted to the customer
Scenario: Display discounted price for logged-in users
Given a product has an original price
And the product has a discount applied
And the user is logged into their account
When the product is displayed on the retail platform
Then the original price should be displayed
And the discounted price should be displayed alongside the original price
And the savings should be highlighted to the customer
Scenario: Display discounted price for guest users
Given a product has an original price
And the product has a discount applied
And the user is not logged into an account
When the product is displayed on the retail platform
Then the original price should be displayed
And the discounted price should be displayed alongside the original price
And the savings should be highlighted to the customer