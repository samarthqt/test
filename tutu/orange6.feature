Feature: Employee Timesheet Submission
Scenario: Employee fills and submits a timesheet for the week
Given the employee is logged on to the OrangeHRM system
When the user goes to the "Time" module and selects "My Timesheets"
And creates a timesheet for the current week
And the user enters hours for a specific project and activity for each day of the week
And the user submits the timesheet for approval
Then the timesheet status changes to "Submitted"