Feature: Add Multiple Products to Cart
@WD-REQ-04
Scenario: User adds multiple products to the cart
Given the user is on the product listing page
When the user selects "SauceLabBackPack" and clicks "Add to Cart"
And the user selects "SauceLabBikeLight" and clicks "Add to Cart"
Then the cart should display "SauceLabBackPack" and "SauceLabBikeLight"
@WD-REQ-04
Scenario: Verify each product page is accessible
Given the user is on the product listing page
When the user clicks on "SauceLabBackPack"
Then the user should be directed to the "SauceLabBackPack" product page
When the user clicks on "SauceLabBikeLight"
Then the user should be directed to the "SauceLabBikeLight" product page
@WD-REQ-04
Scenario: Ensure "Add to Cart" functionality works for each product
Given the user is on the "SauceLabBackPack" product page
When the user clicks "Add to Cart"
Then the cart should display "SauceLabBackPack"
Given the user is on the "SauceLabBikeLight" product page
When the user clicks "Add to Cart"
Then the cart should display "SauceLabBikeLight"