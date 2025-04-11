Feature: Display Return Policy Details
""
As a customer,
I want to see the return policy details clearly displayed on the site,
So that I can understand the terms and conditions for returning products.
""
Background:
Given I am on the homepage of the e-commerce site
""
Scenario: Accessing the return policy from the homepage
When I navigate to the footer section
"    Then I should see a link to ""Return Policy"""
""
Scenario: Viewing the return policy details
Given I am on the homepage of the e-commerce site
"    When I click on the ""Return Policy"" link in the footer"
"    Then I should be redirected to the ""Return Policy"" page"
And I should see the return policy details clearly displayed
""
Scenario: Ensuring return policy accessibility on product pages
Given I am on a product page
When I scroll to the bottom of the page
"    Then I should see a link to ""Return Policy"""
""
Scenario: Validating the content of the return policy page
"    Given I am on the ""Return Policy"" page"
Then I should see information about:
| Topic                               |
| Timeframe for returns               |
| Condition of returnable items       |
| Process for initiating a return     |
| Refund or exchange options          |
| Contact information for inquiries   |
""
Scenario: Ensuring mobile responsiveness of the return policy page
Given I am using a mobile device
"    When I navigate to the ""Return Policy"" page"
Then the return policy details should be clearly visible and readable
And the page layout should be responsive
""
Scenario: Checking for multilingual support of the return policy
"    Given I am on the ""Return Policy"" page"
When I change the site language to Spanish
Then the return policy details should be displayed in Spanish
```
```gherkin
TCID:19