Feature: Display Promotional Banners for Current Sales and Discounts
""
Background:
Given the user is on the homepage of the e-commerce website
""
Scenario: Display promotional banner on the homepage
When the user visits the homepage
Then the promotional banner for current sales and discounts should be displayed prominently
""
Scenario: Promotional banner contains correct information
Given the promotional banner is displayed on the homepage
When the user views the promotional banner
Then the banner should display accurate information about current sales and discounts
""
Scenario: Promotional banner is updated with new promotions
Given a new promotional campaign is launched
When the user visits the homepage
Then the promotional banner should be updated with the new sales and discounts information
""
Scenario: Promotional banner is clickable and redirects to promotions page
Given the promotional banner is displayed on the homepage
When the user clicks on the promotional banner
Then the user should be redirected to the promotions page with details of the current sales and discounts
""
Scenario: Promotional banner is responsive on different devices
Given the user accesses the website on a desktop, tablet, or mobile device
When the promotional banner is displayed
Then the banner should be responsive and display properly on the device being used
""
Scenario: Promotional banner does not obstruct other important content
Given the promotional banner is displayed on the homepage
When the user navigates through the homepage
Then the banner should not obstruct the view of other important content or functionalities
```
```gherkin
TCID:37