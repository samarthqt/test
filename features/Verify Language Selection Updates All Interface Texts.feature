Feature: Verify Language Selection Updates All Interface Texts
@TC-106
Scenario: Check if language selection updates all interface text
Given the user is logged into the application
When the user navigates to the user settings page
Then the user settings page is displayed
And the language selection feature is enabled
When the user locates the language selection dropdown
Then the language selection dropdown is visible
When the user selects 'Spanish' from the language dropdown
Then Spanish is selected as the preferred language
When the user saves the changes made in the settings
Then settings are saved successfully
When the user refreshes the page or navigates to another page
Then interface text is updated to Spanish
When the user navigates to the home page
Then the home page is displayed in Spanish
When the user navigates to the product catalog page
Then the product catalog is displayed in Spanish
When the user navigates to the cart page
Then the cart page is displayed in Spanish
When the user navigates to the checkout page
Then the checkout page is displayed in Spanish
When the user navigates to the user profile page
Then the user profile page is displayed in Spanish
When the user navigates to the order history page
Then the order history page is displayed in Spanish
When the user performs a product search
Then search results are displayed in Spanish
When the user checks the help section
Then the help section is displayed in Spanish
When the user logs out and logs back into the application
Then the login page and subsequent pages are displayed in Spanish
When the user verifies any error messages displayed
Then error messages are displayed in Spanish