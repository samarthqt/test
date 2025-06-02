Feature: Test currency conversion accuracy during high fluctuation periods
@TC-283
Scenario: Verify the accuracy of currency conversion during periods of high fluctuation
Given I navigate to a product page priced in USD
Then the product page is displayed with USD pricing
@TC-283
Scenario: Convert product price to EUR
When I select EUR as the currency
Then the product price is converted to EUR
@TC-283
Scenario: Verify converted price against current conversion rate for EUR
Given the conversion rate fluctuation data for USD to EUR
Then the converted price matches the expected value based on the current rate
@TC-283
Scenario: Simulate high fluctuation in conversion rate for EUR
When I simulate a high fluctuation in conversion rate
Then the system updates the conversion rate accordingly
@TC-283
Scenario: Re-select EUR as the currency
When I re-select EUR as the currency
Then the product price reflects the updated EUR conversion rate
@TC-283
Scenario: Convert product price to GBP
When I select GBP as the currency
Then the product price is converted to GBP
@TC-283
Scenario: Verify converted price against current conversion rate for GBP
Given the conversion rate fluctuation data for USD to GBP
Then the converted price matches the expected value based on the current rate
@TC-283
Scenario: Simulate another fluctuation in conversion rate for GBP
When I simulate another fluctuation in conversion rate
Then the system updates the conversion rate accordingly
@TC-283
Scenario: Re-select GBP as the currency
When I re-select GBP as the currency
Then the product price reflects the updated GBP conversion rate
@TC-283
Scenario: Check for discrepancies in conversion calculations
When I check for any discrepancies in conversion calculations
Then no discrepancies are found and the conversion is accurate
@TC-283
Scenario: Navigate to checkout with selected currency
When I navigate to checkout with the selected currency
Then the checkout page displays prices in the selected currency
@TC-283
Scenario: Verify final price at checkout matches expected conversion
Then the final price at checkout matches the expected conversion rate
@TC-283
Scenario: Simulate rapid conversion rate changes during checkout
When I simulate rapid conversion rate changes during checkout
Then the system handles rate changes without errors
@TC-283
Scenario: Complete the purchase
When I complete the purchase
Then the purchase completes successfully with accurate pricing
@TC-283
Scenario: Review transaction logs for conversion accuracy
When I review transaction logs for conversion accuracy
Then the transaction logs confirm accurate conversion rates