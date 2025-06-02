Feature: Verify Multiple Filters Application and Result Accuracy
@TC-147
Scenario: Apply multiple filters and verify result accuracy
Given the user is logged into the application
When the user navigates to the homepage of the application
Then the homepage is displayed with available filters
@TC-147
Scenario: Apply 'Brand A' filter
When the user selects the 'Brand' filter and chooses 'Brand A'
Then the filter is applied and results are updated accordingly
@TC-147
Scenario: Apply 'Price Range' filter
When the user selects the 'Price Range' filter and chooses '$100-$200'
Then the filter is applied and results are updated accordingly
@TC-147
Scenario: Apply 'Rating' filter
When the user selects the 'Rating' filter and chooses '4 stars and above'
Then the filter is applied and results are updated accordingly
@TC-147
Scenario: Apply 'Availability' filter
When the user selects the 'Availability' filter and chooses 'In stock'
Then the filter is applied and results are updated accordingly
@TC-147
Scenario: Apply 'Category' filter
When the user selects the 'Category' filter and chooses 'Electronics'
Then the filter is applied and results are updated accordingly
@TC-147
Scenario: Verify simultaneous application of all filters
Then all selected filters are applied simultaneously
And results match the criteria
@TC-147
Scenario: Check accuracy of filtered results
Then filtered results are accurate and match the selected criteria
@TC-147
Scenario: Ensure system performance with multiple filters
Then system performance remains optimal with filters applied
@TC-147
Scenario: Verify filter display on different devices
Then filters display correctly across different devices
@TC-147
Scenario: Test removal of filters one by one
When the user removes filters individually
Then results update accordingly
@TC-147
Scenario: Check system handling when all filters are removed
When all filters are removed
Then the system returns to default results
@TC-147
Scenario: Verify ability to reset all filters
When the user resets all filters at once
Then all filters are reset simultaneously and results return to default
@TC-147
Scenario: Test application of filters in different sequences
When filters are applied in any sequence
Then results update correctly
@TC-147
Scenario: Check system handling of invalid filter combinations
When the user applies invalid filter combinations
Then the system provides feedback for invalid combinations and prevents application