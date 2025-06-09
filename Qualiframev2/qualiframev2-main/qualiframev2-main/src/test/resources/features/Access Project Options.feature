Feature: Access Project Options
@TC-11
Scenario: Successful Option Display for Project Alpha
Given the user is logged into COCO
When the user navigates to the home screen
Then the home screen is displayed with various options
And the user has at least one project assigned
When the user locates the 'projects' dropdown on the home screen
Then the projects dropdown is visible
When the user clicks on the 'projects' dropdown
Then the dropdown expands displaying the list of projects assigned to the user
When the user selects 'Project Alpha' from the dropdown
Then the user is navigated to the project details page for 'Project Alpha'
When the user locates the requirements tile on the project details page
Then the requirements tile is visible
When the user clicks on the requirements tile
Then options 'Generate', 'Validate', and 'Fix' are displayed
Then each option is clearly labeled
When the user selects the 'Generate' option
Then the 'Generate' functionality is triggered successfully
When the user returns to the requirements tile
Then the requirements tile is displayed again with options
When the user selects the 'Validate' option
Then the 'Validate' functionality is triggered successfully
When the user returns to the requirements tile
Then the requirements tile is displayed again with options
When the user selects the 'Fix' option
Then the 'Fix' functionality is triggered successfully
Then no errors occur during the selection of any option
When the user logs out of the COCO application
Then the user is logged out successfully and redirected to the login page