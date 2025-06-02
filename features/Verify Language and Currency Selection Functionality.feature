Feature: Verify Language and Currency Selection Functionality
@TC-104
Scenario: Ensure users can select their preferred language and currency
Given User is logged into the application
When User navigates to the user settings page
Then User settings page is displayed
And Language and currency selection feature is enabled
When User locates the language selection dropdown
Then Language selection dropdown is visible
When User selects 'English' from the language dropdown
Then English is selected as the preferred language
When User locates the currency selection dropdown
Then Currency selection dropdown is visible
When User selects 'USD' from the currency dropdown
Then USD is selected as the preferred currency
When User saves the changes made in the settings
Then Settings are saved successfully
When User refreshes the page or navigates to another page
Then Selected language and currency persist after refresh
When User logs out and logs back into the application
Then Selected language and currency settings persist after re-login
When User navigates to the product catalog page
Then Product catalog is displayed in the selected language
When User checks the product prices on the catalog page
Then Product prices are displayed in the selected currency
When User navigates to the checkout page
Then Checkout page is displayed in the selected language
When User verifies the currency displayed on the checkout page
Then Currency displayed on the checkout page matches the selected currency
When User navigates to the user profile page
Then User profile page is displayed in the selected language
When User verifies the currency settings in the user profile
Then Currency settings in the user profile match the selected currency
When User performs a search for products
Then Search results are displayed in the selected language and currency