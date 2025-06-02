Feature: Keyword-Based Product Search Verification
@TC-143
Scenario: Verify that users can access the search bar in the retail application
Given the retail application is open
When the user navigates to the search bar
Then the search bar should be accessible and ready for input
@TC-143
Scenario: Verify search functionality with keyword 'Laptop'
Given the product catalog is populated with searchable products
When the user enters the keyword 'Laptop' in the search bar
And submits the search query
Then relevant product results should be displayed based on the keyword 'Laptop'
@TC-143
Scenario: Verify relevance of search results for keyword 'Laptop'
Given the search results are displayed
Then the search results should be relevant and accurately match the keyword 'Laptop'
@TC-143
Scenario: Check the speed of search results display
When the user submits the search query
Then search results should be displayed quickly, within acceptable time limits
@TC-143
Scenario: Verify search functionality with keyword 'Smartphone'
When the user enters the keyword 'Smartphone' in the search bar
And submits the search query
Then relevant product results should be displayed based on the keyword 'Smartphone'
@TC-143
Scenario: Verify consistency of search results across different keywords
Given search results for 'Laptop' and 'Smartphone' are displayed
Then the search results should be consistent and accurately match different keywords
@TC-143
Scenario: Test search functionality on mobile devices
Given the retail application is open on a mobile device
When the user enters a keyword in the search bar
And submits the search query
Then search functionality should work well on mobile, displaying relevant results quickly
@TC-143
Scenario: Check for discrepancies between desktop and mobile search results
Given search results are displayed on both desktop and mobile
Then no discrepancies should be found; search results should be consistent across platforms
@TC-143
Scenario: Ensure search results include product details
Given search results are displayed
Then search results should include product details such as name, price, and image
@TC-143
Scenario: Verify interactive elements in search results
Given search results are displayed
Then 'Add to Cart' button should function correctly in search results
@TC-143
Scenario: Test system response to complex search queries
When the user enters a complex search query with multiple keywords
And submits the search query
Then the system should handle complex search queries well, displaying relevant results
@TC-143
Scenario: Check for error messages or broken links in search results
Given search results are displayed
Then no error messages or broken links should be present in search results
@TC-143
Scenario: Confirm search results can be filtered by categories or price ranges
Given search results are displayed
When the user applies filters by categories or price ranges
Then search results should be filtered successfully
@TC-143
Scenario: Test system's ability to handle large datasets
Given the retail application has a large dataset
When the user submits a search query
Then the system should handle large datasets efficiently, maintaining performance during searches