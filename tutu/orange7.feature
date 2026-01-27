Feature: Add a Candidate to the Recruitment Module
Scenario: Recruiter adds a new candidate for a job vacancy
Given the recruiter is logged into the OrangeHRM application
When the user navigates to the "Recruitment" module
And selects a specific "Vacancy"
And clicks the "Add Candidate" button
And the user fills in the candidate's first name, last name, and email
And uploads the candidate's resume
And saves the candidate's information
Then the new candidate is listed under the selected "Vacancy"