Feature: Tax Calculation
Scenario: Calculate taxes based on user location for accurate pricing
Given a user is located in a region with a specific tax rate
When the user adds items to their cart
And proceeds to checkout
Then the system should automatically calculate the taxes based on the user's location
And display the accurate pricing including taxes
Scenario: Verify tax calculation for different regions
Given a user is located in region A with tax rate X
When the user adds items to their cart and proceeds to checkout
Then the system should calculate the taxes as X% of the total cart value
Given a user is located in region B with tax rate Y
When the user adds items to their cart and proceeds to checkout
Then the system should calculate the taxes as Y% of the total cart value
Scenario: Handle tax exemption for specific locations
Given a user is located in a tax-exempt region
When the user adds items to their cart and proceeds to checkout
Then the system should not apply any taxes
And display the pricing without any tax inclusion
Scenario: Update tax calculation upon location change
Given a user initially located in region C with tax rate Z
When the user changes their location to region D with tax rate W
And adds items to their cart
Then the system should update the tax calculation based on the new location
And display the pricing including the updated tax rate
Scenario: Ensure accurate pricing with tax calculation during promotions
Given a user is eligible for a promotional discount
And is located in a region with a specific tax rate
When the user applies the discount to their cart
And proceeds to checkout
Then the system should calculate the taxes after applying the discount
And display the final pricing including taxes and discount adjustments