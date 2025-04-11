Feature: Help Center Availability
Scenario: Accessing the help center from the main menu
Given the user is on the main menu
When the user selects the help center option
Then the help center should be accessible
Scenario: FAQs cover common user queries
Given the user is in the help center
When the user views the FAQs section
Then the FAQs should cover at least 90% of common user queries
Scenario: Troubleshooting guides are comprehensive and up-to-date
Given the user is in the help center
When the user views the troubleshooting guides section
Then the guides should be comprehensive and up-to-date
Scenario: Searching FAQs and guides using keywords
Given the user is in the help center
When the user searches FAQs and guides using keywords
Then the search results should be relevant to the keywords
Scenario: Help center responsiveness
Given the user selects the help center option from the main menu
When the help center loads
Then it should be responsive and load within 2 seconds