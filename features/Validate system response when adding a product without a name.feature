Feature: Validate system response when adding a product without a name
@TC-301
Scenario: Attempt to add a product without a name to verify system validation
Given the user is logged into the admin panel
When the user navigates to the product addition page
Then the product addition page is displayed successfully
And the product addition interface must be accessible
@TC-301
Scenario: Leave the 'Product Name' field empty
Given the 'Product Name' field is empty
When the user enters '100' in the 'Product Price' field
Then the 'Product Price' field is populated with '100'
When the user enters 'Sample Description' in the 'Product Description' field
Then the 'Product Description' field is populated with 'Sample Description'
When the user selects 'Electronics' from the 'Product Category' dropdown
Then the 'Product Category' field is set to 'Electronics'
When the user clicks on the 'Save' button to attempt to add the product
Then an error message is displayed indicating that the 'Product Name' field cannot be empty
And the product does not appear in the product list
And system logs or alerts indicate a validation error due to the missing product name
@TC-301
Scenario: Attempt to refresh the page and re-enter the same data
When the user refreshes the page and re-enters the same data
Then the same validation error is displayed indicating the 'Product Name' field is required
@TC-301
Scenario: Try to navigate away from the page without saving
When the user attempts to navigate away from the page without saving
Then a warning message is displayed asking to confirm navigation without saving
@TC-301
Scenario: Attempt to add a product with a name to verify successful addition
Given the user enters a valid name in the 'Product Name' field
When the user saves the product
Then the product is successfully added to the product list with a valid name
@TC-301
Scenario: Check the database for product entry
Given the product was attempted to be added without a name
Then no entry is found in the database for the product without a name
@TC-301
Scenario: Ensure system stability during validation process
Given the user encounters a validation error
Then the system remains stable and responsive after the validation error
@TC-301
Scenario: Review the user interface for layout issues
Given an error message is displayed
Then the user interface displays the error message correctly without any layout issues
@TC-301
Scenario: Attempt to log out and log back in to ensure system state consistency
Given the user logs out and logs back in
Then the system state is consistent and no product without a name is added