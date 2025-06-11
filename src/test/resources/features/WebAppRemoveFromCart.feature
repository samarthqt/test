Feature: WebAppRemoveFromCart
As a user, I want the ability to remove multiple products from my cart, so that I can update or change my order before checkout.
@5
Scenario Outline: Remove multiple products from cart
Given Launch Application using "<tc_id>"
Then verify login page displayed successfully
When User enters userCredentials in text field
And User clicks Login button
Then verify home page displayed successfully
When User adds multiple products to the cart
And User clicks Cart button
Then User should see all added products in the cart
When User selects multiple products to remove
And User clicks Remove button
Then User should see the selected products removed from the cart
Examples:
| tc_id                 |
| SeleniumPracticeTest5 |