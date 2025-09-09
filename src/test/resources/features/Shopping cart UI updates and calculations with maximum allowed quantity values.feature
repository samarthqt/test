Feature: Shopping cart UI updates and calculations with maximum allowed quantity values
@TC-7
Scenario Outline: Verify shopping cart UI updates and calculations with maximum allowed quantity values
Given user has access to the e-commerce website
When user navigates to the product listing page
Then the product listing page is displayed with multiple products
When user selects Product 1 to view its details
Then Product 1 detail page is displayed with product information, price, quantity selector, and 'Add to Cart' button
When user enters "<quantity1>" in the quantity field for Product 1
And user adds Product 1 to the cart
Then Product 1 is successfully added to the cart with the specified quantity and a confirmation message appears
When user views the cart contents
Then the shopping cart page opens displaying Product 1 with the specified quantity
And the line item price for Product 1 is correctly calculated as "<line_price1>"
And the subtotal is correctly calculated as "<subtotal1>"
When user navigates back to the product listing page
And user selects Product 2 to view its details
Then Product 2 detail page is displayed with product information, price, quantity selector, and 'Add to Cart' button
When user enters "<quantity2>" in the quantity field for Product 2
And user adds Product 2 to the cart
Then Product 2 is successfully added to the cart with the specified quantity and a confirmation message appears
When user views the cart contents
Then the shopping cart page opens displaying Product 1 with the specified quantity and Product 2 with the specified quantity
And the line item price for Product 2 is correctly calculated as "<line_price2>"
And the updated subtotal is correctly calculated as "<subtotal2>"
When user attempts to increase Product 1 quantity by 1 more than the maximum allowed
Then the system prevents updating the quantity and displays an error message about the maximum quantity limit
And tax and total amounts are correctly calculated based on the large subtotal amount
Examples:
| quantity1 | line_price1 | subtotal1 | quantity2 | line_price2 | subtotal2 |
| 999       | $999.00     | $999.00   | 100       | $1,000.00   | $1,999.00 |