Feature: Verify relevance of search results to entered keyword
@TC-109
Scenario: Verify search results for the keyword 'laptop'
Given the user is logged into the application
When the user navigates to the search bar
And the search bar is accessible and ready for input
And the user enters the keyword 'laptop' into the search bar
And initiates the search
Then search results relevant to 'laptop' are displayed
And all search results contain products related to laptops
@TC-109
Scenario: Verify search results for the keyword 'smartphone'
Given the user is logged into the application
When the user enters the keyword 'smartphone' into the search bar
And initiates the search
Then search results relevant to 'smartphone' are displayed
And all search results contain products related to smartphones
@TC-109
Scenario: Verify search results for the keyword 'wireless headphones'
Given the user is logged into the application
When the user enters the keyword 'wireless headphones' into the search bar
And initiates the search
Then search results relevant to 'wireless headphones' are displayed
And all search results contain products related to wireless headphones
@TC-109
Scenario: Check ranking of search results for relevance and accuracy
Given the user is logged into the application
When the user performs a search
Then search results are ranked accurately based on relevance
@TC-109
Scenario: Test search results with partial keyword input
Given the user is logged into the application
When the user enters a partial keyword into the search bar
Then relevant suggestions and results are displayed for partial keywords
@TC-109
Scenario: Verify search results with synonyms of the entered keywords
Given the user is logged into the application
When the user enters a keyword synonym into the search bar
Then search results include products related to synonyms of the keyword
@TC-109
Scenario: Test search results with misspelled keywords
Given the user is logged into the application
When the user enters a misspelled keyword into the search bar
Then search results include suggestions or corrections for misspelled keywords
@TC-109
Scenario: Verify the speed and performance of the search functionality
Given the user is logged into the application
When the user performs a search
Then search results are displayed promptly without delay
@TC-109
Scenario: Check the search results pagination and navigation
Given the user is logged into the application
When the user navigates through search results
Then pagination and navigation through search results function correctly
@TC-109
Scenario: Test search functionality on different devices and screen sizes
Given the user is logged into the application
When the user performs a search on different devices and screen sizes
Then search results are consistent across various devices and screen sizes
@TC-109
Scenario: Verify search results with multiple keywords and filters applied
Given the user is logged into the application
When the user enters multiple keywords and applies filters
Then search results accurately reflect the combination of keywords and filters