Feature: View Order History with Large Number of Past Orders
@TC-133
Scenario: User successfully logs into the account
Given a user account exists with User ID: 67890 and Account Status: Active
When the user logs in using valid credentials
Then the user is successfully logged into the account
@TC-133
Scenario: Navigate to the 'Order History' section
Given the user is logged into the account
When the user navigates to the 'Order History' section in the user dashboard
Then the user is directed to the 'Order History' page
@TC-133
Scenario: Scroll through the list of past orders
Given the user is on the 'Order History' page with 1000 past orders
When the user scrolls through the list of past orders
Then all past orders are displayed without any truncation or loading issues
@TC-133
Scenario: Use the search or filter options to locate a specific order
Given the user is on the 'Order History' page
When the user uses the search or filter options to locate a specific order
Then the search or filter functionality works correctly, and the specific order is located
@TC-133
Scenario: Check the order details for a randomly selected order
Given the user is on the 'Order History' page
When the user checks the order details for a randomly selected order
Then the order details are accurate and complete
@TC-133
Scenario: Verify the performance of the page when loading a large number of orders
Given the user is on the 'Order History' page with a large number of orders
When the page loads
Then the page loads efficiently, and performance is not degraded
@TC-133
Scenario: Export the order history to a file format
Given the user is on the 'Order History' page
When the user attempts to export the order history to a file format (e.g., PDF, CSV)
Then the order history is successfully exported in the chosen format
@TC-133
Scenario: Verify the pagination functionality
Given the user is on the 'Order History' page with pagination
When the user navigates between pages
Then the pagination works correctly, and navigation between pages is smooth
@TC-133
Scenario: Check for error messages or warnings during navigation
Given the user is navigating the 'Order History' page
When the user navigates through the page
Then no error messages or warnings are displayed
@TC-133
Scenario: Inspect the page layout and design for consistency and clarity
Given the user is on the 'Order History' page
When the user inspects the page layout and design
Then the page layout is consistent, and design is clear with appropriate spacing and alignment
@TC-133
Scenario: Navigate back to the main dashboard from the 'Order History' page
Given the user is on the 'Order History' page
When the user attempts to navigate back to the main dashboard
Then the user can easily navigate back to the main dashboard
@TC-133
Scenario: Access the 'Order History' page directly via URL manipulation
Given the user is not authenticated
When the user attempts to access the 'Order History' page directly via URL manipulation
Then the user is redirected to the login page or main dashboard
@TC-133
Scenario: Check for help or support links on the 'Order History' page
Given the user is on the 'Order History' page
When the user checks for help or support links
Then help or support links are present and functional
@TC-133
Scenario: Review the page for promotional content or offers
Given the user is on the 'Order History' page
When the user reviews the page for promotional content or offers
Then relevant promotional content or offers are displayed if applicable
@TC-133
Scenario: Verify the responsiveness of the 'Order History' page on different devices
Given the user is accessing the 'Order History' page on various devices
When the user views the page on different devices
Then the page is responsive and displays correctly on various devices