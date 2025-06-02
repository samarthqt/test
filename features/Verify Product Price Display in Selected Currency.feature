Feature: Verify Product Price Display in Selected Currency
@TC-105
Scenario: Verify product prices display correctly in the selected currency
Given the user is logged into the application
When the user navigates to the user settings page
Then the user settings page is displayed
And the preferred currency is set to EUR
And the currency selection feature is enabled
@TC-105
Scenario: Select EUR from the currency dropdown
Given the currency selection dropdown is visible
When the user selects 'EUR' from the currency dropdown
Then EUR is selected as the preferred currency
@TC-105
Scenario: Save changes made in settings
When the user saves the changes made in the settings
Then the settings are saved successfully
@TC-105
Scenario: Verify product prices on the catalog page
When the user navigates to the product catalog page
Then the product catalog is displayed
And product prices are displayed in EUR
@TC-105
Scenario: Add a product to the cart
When the user adds a product to the cart
Then the product is added to the cart successfully
@TC-105
Scenario: Verify product price in the cart
When the user navigates to the cart page
Then the cart page is displayed
And the product price in the cart is displayed in EUR
@TC-105
Scenario: Verify total price in the checkout page
When the user proceeds to the checkout page
Then the checkout page is displayed
And the total price in the checkout page is displayed in EUR
@TC-105
Scenario: Complete the purchase
When the user completes the purchase
Then the purchase is completed successfully
@TC-105
Scenario: Check order confirmation email
When the user checks the order confirmation email
Then the order confirmation email displays prices in EUR
@TC-105
Scenario: Verify currency in order details
When the user navigates to the order history page
Then the order history page is displayed
And the currency in the order details is displayed as EUR