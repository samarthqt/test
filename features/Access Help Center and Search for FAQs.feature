Feature: Access Help Center and Search for FAQs
@TC-224
Scenario: Verify users can access the help center from the main navigation
Given the user is logged in with valid credentials
When the user navigates to the homepage
Then the main navigation bar is visible and accessible
@TC-224
Scenario: Access the Help Center page
Given the user is on the homepage
When the user clicks on the 'Help Center' link in the main navigation
Then the user is redirected to the Help Center page
@TC-224
Scenario: Verify Help Center page layout and options
Given the user is on the Help Center page
Then the Help Center page displays FAQs and guides options
@TC-224
Scenario: Search for FAQ using keyword 'returns'
Given the user is on the Help Center page
When the user enters 'returns' in the FAQ search bar and clicks search
Then relevant FAQ results for 'returns' are displayed
@TC-224
Scenario: Search for guide using keyword 'setup'
Given the user is on the Help Center page
When the user enters 'setup' in the guide search bar and clicks search
Then relevant guide results for 'setup' are displayed
@TC-224
Scenario: Select an FAQ from search results
Given relevant FAQ results are displayed
When the user selects a FAQ from the search results
Then the selected FAQ content is displayed correctly
@TC-224
Scenario: Select a guide from search results
Given relevant guide results are displayed
When the user selects a guide from the search results
Then the selected guide content is displayed correctly
@TC-224
Scenario: Check responsiveness of the Help Center page
Given the user is on the Help Center page
When the user checks the page on different devices
Then the Help Center page is responsive and displays correctly on all devices
@TC-224
Scenario: Test search functionality with multiple keywords
Given the user is on the Help Center page
When the user tests the search functionality with multiple keywords
Then search results are accurate and relevant to the keywords entered
@TC-224
Scenario: Verify loading time for FAQ and guide content
Given the user is on the Help Center page
When the user accesses FAQ and guide content
Then content loads within acceptable time limits
@TC-224
Scenario: Check accessibility features in the Help Center
Given the user is on the Help Center page
When the user checks for accessibility features
Then accessibility features are present and functional
@TC-224
Scenario: Attempt to access Help Center while logged out
Given the user is logged out
When the user attempts to access the Help Center
Then the user is prompted to log in to access the Help Center
@TC-224
Scenario: Verify search functionality with special characters
Given the user is on the Help Center page
When the user enters special characters in the search bar
Then the system handles special characters gracefully and returns relevant results
@TC-224
Scenario: Test Help Center access during peak hours
Given the user is on the Help Center page
When the user accesses the Help Center during peak hours
Then the Help Center remains accessible and performs well during peak hours
@TC-224
Scenario: Validate search accuracy with synonyms
Given the user is on the Help Center page
When the user searches using synonyms
Then search results include relevant synonyms