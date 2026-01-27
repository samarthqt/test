Feature: Agile Testing Page
@TC-31
Scenario: Verify Agile Testing page functionalities
Given I open a new browser window
When I enter "http://www.qasymphony.com/platform.html" URL
Then I should see the "Agile Testing" sub-menu
When I click on the "Agile Testing" sub-menu
Then I should be able to call Get Free Trial
When I click on the content or Learn More button of Scale Agile section
Then I should see details about Scale Agile
When I click on the content or Learn More button of eXplorer Testing section
Then I should see details about eXplorer Testing
When I click on the content or Learn More button of Distributed Team section
Then I should see details about Distributed Team
When I click on the content or Learn More button of Integration & APIs section
Then I should see details about Integration & APIs