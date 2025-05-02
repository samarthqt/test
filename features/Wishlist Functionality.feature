Feature: Wishlist Functionality
Scenario: User adds a product to the wishlist
Given the user is logged into their account
And the user is viewing a product page
When the user clicks on the "Add to Wishlist" button
Then the product should be added to the user's wishlist
And a confirmation message should be displayed
Scenario: User views their wishlist
Given the user is logged into their account
When the user navigates to the wishlist page
Then the user should see a list of products saved in their wishlist
Scenario: User removes a product from the wishlist
Given the user is logged into their account
And the user is viewing their wishlist
When the user clicks on the "Remove" button next to a product
Then the product should be removed from the wishlist
And a confirmation message should be displayed
Scenario: User adds a product from the wishlist to the cart
Given the user is logged into their account
And the user is viewing their wishlist
When the user clicks on the "Add to Cart" button next to a product
Then the product should be added to the user's cart
And a confirmation message should be displayed
Scenario: User views an empty wishlist
Given the user is logged into their account
And the user has no products in their wishlist
When the user navigates to the wishlist page
Then the user should see a message indicating that the wishlist is empty
Scenario: User tries to add a product to the wishlist without logging in
Given the user is not logged into their account
And the user is viewing a product page
When the user clicks on the "Add to Wishlist" button
Then the user should be prompted to log in or create an account