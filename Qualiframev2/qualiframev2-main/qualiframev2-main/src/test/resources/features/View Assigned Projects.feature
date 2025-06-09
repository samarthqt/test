Feature: View Assigned Projects
@TC-10
Scenario: Successful Login and Project Display
Given the user has an active account and knows the login credentials
When the user opens the COCO application login page
Then the login page should display fields for username and password
When the user enters the username "testUser" in the username field
Then the username should be entered successfully
When the user enters the password "testPassword123" in the password field
Then the password should be entered successfully
When the user clicks the "Login" button
Then the user should be successfully logged into the COCO application
When the user navigates to the home screen
Then the home screen should display various options
When the user locates the "projects" dropdown on the home screen
Then the projects dropdown should be visible on the home screen
When the user clicks on the "projects" dropdown
Then the dropdown should expand displaying the list of projects assigned to the user
Then each project name in the dropdown should be clickable
When the user clicks on one of the project names
Then the user should be navigated to the project details page
Then a loading indicator should be displayed while fetching project data
Then the project list in the dropdown should be complete without any omission
When the user logs out of the COCO application
Then the user should be logged out successfully and redirected to the login page
When the user closes the COCO application
Then the application should close without any issues