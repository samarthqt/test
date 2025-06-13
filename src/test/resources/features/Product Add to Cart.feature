Feature: Product Add to Cart
As a user
I want to be able to add products to my shopping cart
So that I can purchase them later
@WD-REQ-02
Scenario: Add a product to the shopping cart
Given the user is logged in
And the user is on the product page for "SauceLabBackPack"
When the user clicks "AddToCart"
Then the product "SauceLabBackPack" should be displayed in the shopping cart
@WD-REQ-02
Scenario: Verify product details in the shopping cart after adding
Given the user has added "SauceLabBackPack" to the shopping cart
When the user views the shopping cart
Then the shopping cart should display the correct product name "SauceLabBackPack"
And the shopping cart should display the correct product price
And the shopping cart should display the correct product quantity
@WD-REQ-02
Scenario: Add multiple products to the shopping cart
Given the user is logged in
And the user is on the product page for "SauceLabBackPack"
When the user clicks "AddToCart"
And the user navigates to the product page for "SauceLabT-Shirt"
And the user clicks "AddToCart"
Then both products "SauceLabBackPack" and "SauceLabT-Shirt" should be displayed in the shopping cart
@WD-REQ-02
Scenario: Remove a product from the shopping cart
Given the user has added "SauceLabBackPack" to the shopping cart
And the user is viewing the shopping cart
When the user clicks "Remove" next to "SauceLabBackPack"
Then the product "SauceLabBackPack" should no longer be displayed in the shopping cart
@WD-REQ-02
Scenario: Attempt to add a product to the cart without logging in
Given the user is not logged in
And the user is on the product page for "SauceLabBackPack"
When the user clicks "AddToCart"
Then the user should be prompted to log in