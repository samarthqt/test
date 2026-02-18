Feature: Add a New Employee in OrangeHRM
Scenario: HR Admin successfully adds a new employee with mandatory details
Given the user navigates to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
And the user logs in with username "Admin" and password "admin123"
When the user navigates to the "PIM" module
And clicks on the "Add Employee" button
And the user enters the first name as maron, middle name as bon, and last name as mon
And saves the new employee details
Then a success message "Successfully Saved" is displayed
And the new employee is visible in the "Employee List"