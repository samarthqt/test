Feature: Add a product with maximum allowed characters in the name field
@TC-302
Scenario: Add product with maximum allowed characters in the name field
Given User is logged into the admin panel
When User navigates to the product addition page
Then Product addition page is displayed successfully
And Product addition interface must be accessible
@TC-302
Scenario: Enter maximum characters in Product Name field
When User enters 255 'A' characters in the 'Product Name' field
Then The 'Product Name' field is populated with 255 'A' characters
@TC-302
Scenario: Enter Product Price
When User enters '200' in the 'Product Price' field
Then The 'Product Price' field is populated with '200'
@TC-302
Scenario: Enter Product Description
When User enters 'Sample Description' in the 'Product Description' field
Then The 'Product Description' field is populated with 'Sample Description'
@TC-302
Scenario: Select Product Category
When User selects 'Home Appliances' from the 'Product Category' dropdown
Then The 'Product Category' field is set to 'Home Appliances'
@TC-302
Scenario: Save the product
When User clicks on the 'Save' button to add the product
Then The product is successfully added to the product list with the name containing 255 'A' characters
@TC-302
Scenario: Verify product name in product list
Then The product appears in the product list with the correct name
@TC-302
Scenario: Verify product name in database
Then The product name is stored correctly in the database with 255 'A' characters
@TC-302
Scenario: Attempt to exceed maximum characters in Product Name
When User attempts to edit the product name to exceed the maximum allowed characters
Then An error message is displayed indicating the maximum character limit is exceeded
@TC-302
Scenario: Verify product name display without truncation
Then The user interface displays the full product name without truncation
@TC-302
Scenario: Verify product name remains intact after logout
When User logs out and logs back in
Then The product name remains intact with 255 'A' characters
@TC-302
Scenario: Search for product using full name
When User attempts to search for the product using the full name
Then The product is successfully found using the full name in search
@TC-302
Scenario: Verify product name in product details page
Then The product details page displays the full product name correctly
@TC-302
Scenario: Ensure system stability with maximum character name
Then The system remains stable and responsive with the maximum character name
@TC-302
Scenario: Review layout and design for long name
Then The layout and design display the long name without any issues