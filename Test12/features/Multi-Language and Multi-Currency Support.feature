Feature: Multi-Language and Multi-Currency Support
@21
Scenario: User selects preferred language from a list of supported languages
Given the user is on the settings page
When the user selects a language from the list of supported languages
Then the system should update the content to the selected language
@21
Scenario: User selects preferred currency for transactions
Given the user is on the settings page
When the user selects a currency from the list of supported currencies
Then the system should update the prices to the selected currency
@21
Scenario: System displays content and prices in selected language and currency
Given the user has selected a language and currency
When the user navigates through the application
Then the system should display all content and prices in the selected language and currency
@21
Scenario: System updates language and currency settings in real-time
Given the user changes the language or currency settings
When the user confirms the changes
Then the system should immediately reflect the changes across all interfaces
@21
Scenario: System handles conversion rates for currency accurately
Given the user selects a currency for transactions
When there is a need for currency conversion
Then the system should apply accurate conversion rates
@21
Scenario: System provides fallback options for unsupported languages or currencies
Given the user selects a language or currency not supported by the system
When the user tries to apply the settings
Then the system should provide a fallback option to the default language or currency
@21
Scenario: System ensures consistency across all interfaces with selected settings
Given the user has selected language and currency settings
When the user accesses different interfaces of the application
Then the system should maintain consistency with the selected settings
@21
Scenario: Localization features are accessible on both desktop and mobile devices
Given the user accesses the application on a desktop or mobile device
When the user navigates to the settings page
Then the localization features should be available and functional on both types of devices