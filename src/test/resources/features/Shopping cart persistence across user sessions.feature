Feature: Shopping cart persistence across user sessions
@TC-8
Scenario: Verify shopping cart persistence when a logged-in user closes and reopens the browser session
Given the user opens the web application in Chrome browser
When the user logs in with valid credentials "test_user@example.com" and "Test@123"
Then the user is redirected to the home page
When the user navigates to the "Men's Clothing" category
Then men's clothing products are displayed
When the user selects "Men's T-shirt" product and adds it to the cart
Then the product is added to the cart with a confirmation message
When the user navigates to the "Women's Clothing" category
Then women's clothing products are displayed
When the user selects "Women's Jeans" product and adds it to the cart
Then the product is added to the cart with a confirmation message
When the user views the shopping cart
Then both "Men's T-shirt" and "Women's Jeans" are displayed in the cart with correct quantities (1 each)
When the user closes the browser completely
And reopens the browser and navigates to the web application
Then the application home page is displayed
When the user logs in with the same credentials "test_user@example.com" and "Test@123"
Then the user is successfully logged in
When the user views the shopping cart
Then both "Men's T-shirt" and "Women's Jeans" are displayed in the cart with correct quantities (1 each)
And product names, prices, quantities, and subtotals are correctly displayed
When the user logs out from the application
Then the user is successfully logged out and redirected to the home page