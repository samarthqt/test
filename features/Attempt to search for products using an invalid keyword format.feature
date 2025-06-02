Feature: Attempt to search for products using an invalid keyword format
To test the system's response to invalid keyword formats during product search.
@TC-2
Scenario: Search with special characters
Given the user is logged into the retail application
When the user navigates to the homepage
And the user enters "!@#$%" in the search bar and presses enter
Then the system displays an error message indicating invalid search keyword format
@TC-2
Scenario: Search with excessively long keyword
Given the user is logged into the retail application
When the user navigates to the homepage
And the user enters "123456789012345678901234567890" in the search bar and presses enter
Then the system displays an error message indicating keyword length exceeds limit
@TC-2
Scenario: Search with script injection
Given the user is logged into the retail application
When the user navigates to the homepage
And the user enters "<script>alert('test')</script>" in the search bar and presses enter
Then the system displays an error message indicating invalid characters used
@TC-2
Scenario: Search with empty keyword
Given the user is logged into the retail application
When the user navigates to the homepage
And the user enters an empty string in the search bar and presses enter
Then the system displays an error message indicating keyword cannot be empty
@TC-2
Scenario: Search with SQL query
Given the user is logged into the retail application
When the user navigates to the homepage
And the user enters "SELECT * FROM products" in the search bar and presses enter
Then the system displays an error message indicating invalid keyword format
@TC-2
Scenario: Verify no search results for invalid keywords
Given the user has entered an invalid keyword
Then no products are displayed; only error message is shown
@TC-2
Scenario: Ensure search bar functionality after invalid input
Given the user has entered an invalid keyword
Then the search bar remains operational and can accept new input
@TC-2
Scenario: Prevent SQL injection through search bar
Given the user has entered a potential SQL injection keyword
Then the system does not execute any unintended SQL commands
@TC-2
Scenario: Verify user-friendly error messages
Given the user has entered an invalid keyword
Then error messages provide clear guidance on correcting the input
@TC-2
Scenario: Ensure other functionalities remain unaffected
Given the user has entered an invalid keyword
Then other functionalities remain unaffected and operational
@TC-2
Scenario: Log invalid search attempts
Given the user has entered an invalid keyword
Then invalid search attempts are logged for auditing purposes
@TC-2
Scenario: Provide suggestions for valid keywords
Given the user has entered an invalid keyword
Then the system suggests alternative keywords or categories
@TC-2
Scenario: Retry search with a valid keyword
Given the user has entered an invalid keyword
When the user enters a valid keyword
Then the user can perform a successful search
@TC-2
Scenario: Confirm no account lock on invalid search
Given the user has entered an invalid keyword
Then the user account remains unlocked and accessible