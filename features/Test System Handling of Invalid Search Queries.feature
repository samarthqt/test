Feature: Test System Handling of Invalid Search Queries
@TC-145
Scenario: Verify search bar visibility on the homepage
Given the user is logged into the application
When the user navigates to the homepage
Then the homepage is displayed with a visible search bar
@TC-145
Scenario: Test system response to invalid search query with special characters '!!!'
Given the user is on the homepage with a visible search bar
When the user clicks on the search bar
And the user types '!!!' into the search bar
Then the system provides a message indicating no results or invalid query
@TC-145
Scenario: Test system response to invalid search query with special characters '????'
Given the user is on the homepage with a visible search bar
When the user clicks on the search bar
And the user types '????' into the search bar
Then the system provides a message indicating no results or invalid query
@TC-145
Scenario: Test system handling of long input
Given the user is on the homepage with a visible search bar
When the user clicks on the search bar
And the user types '123456789012345678901234567890' into the search bar
Then the system handles the long input gracefully and provides appropriate feedback
@TC-145
Scenario: Test system response to invalid search query with script tags
Given the user is on the homepage with a visible search bar
When the user clicks on the search bar
And the user types '<script>alert(1)</script>' into the search bar
Then the system prevents script execution and provides a message indicating invalid query
@TC-145
Scenario: Test system response to invalid search query with SQL injection
Given the user is on the homepage with a visible search bar
When the user clicks on the search bar
And the user types 'SELECT * FROM users' into the search bar
Then the system prevents SQL injection and provides a message indicating invalid query
@TC-145
Scenario: Verify system response to query with special characters
Given the user is on the homepage with a visible search bar
When the user enters a query with special characters
Then the system provides feedback indicating invalid query
@TC-145
Scenario: Test system response to empty search query
Given the user is on the homepage with a visible search bar
When the user enters an empty search query
Then the system prompts the user to enter a valid search query
@TC-145
Scenario: Check system handling of queries with only spaces
Given the user is on the homepage with a visible search bar
When the user enters a query with only spaces
Then the system provides feedback indicating invalid query
@TC-145
Scenario: Verify system response to queries with mixed valid and invalid characters
Given the user is on the homepage with a visible search bar
When the user enters a query with mixed valid and invalid characters
Then the system provides feedback indicating invalid query
@TC-145
Scenario: Test system handling of queries exceeding maximum length
Given the user is on the homepage with a visible search bar
When the user enters a query exceeding maximum length
Then the system truncates input and provides feedback indicating invalid query
@TC-145
Scenario: Check system handling of queries with repetitive characters
Given the user is on the homepage with a visible search bar
When the user enters a query with repetitive characters
Then the system provides feedback indicating invalid query
@TC-145
Scenario: Verify system handling of queries with non-ASCII characters
Given the user is on the homepage with a visible search bar
When the user enters a query with non-ASCII characters
Then the system provides feedback indicating invalid query
@TC-145
Scenario: Test system handling of queries with HTML tags
Given the user is on the homepage with a visible search bar
When the user enters a query with HTML tags
Then the system provides feedback indicating invalid query