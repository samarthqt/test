Feature: Wishlist Functionality
""
As a user,
I want to be able to save products to a wishlist,
So that I can easily find and purchase them in the future.
""
Scenario: Add a product to the wishlist
Given I am logged into my user account
And I am on a product page
"    When I click on the ""Add to Wishlist"" button"
Then the product should be added to my wishlist
And I should see a confirmation message
""
Scenario: View wishlist
Given I am logged into my user account
When I navigate to the wishlist page
Then I should see a list of all products I have added to my wishlist
""
Scenario: Remove a product from the wishlist
Given I am logged into my user account
And I have products in my wishlist
"    When I click on the ""Remove"" button next to a product"
Then the product should be removed from my wishlist
And I should see a confirmation message
""
Scenario: Add a product to the wishlist without logging in
Given I am not logged into my user account
When I attempt to add a product to the wishlist
Then I should be prompted to log in or create an account
""
Scenario: Wishlist persists after logging out and back in
Given I am logged into my user account
And I have products in my wishlist
When I log out and then log back into my account
Then I should see all previously added products still in my wishlist
""
Scenario: Attempt to add the same product multiple times
Given I am logged into my user account
And I have a product already in my wishlist
When I attempt to add the same product to my wishlist again
Then I should not see duplicate entries in my wishlist
And I should see a message indicating the product is already in the wishlist
```
```gherkin
TCID:20