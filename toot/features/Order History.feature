Feature: Order History
""
As a user, I want to be able to view my past orders and invoices so that I can keep track of my purchase history.
""
Background:
Given the user is logged into their account
""
Scenario: View Order History
Given the user navigates to the Order History page
When the page loads successfully
Then the user should see a list of their past orders
""
Scenario: View Order Details
Given the user is on the Order History page
When the user selects an order from the list
Then the user should see the details of the selected order including the invoice
""
Scenario: No Past Orders
Given the user is on the Order History page
And the user has no past orders
Then the user should see a message indicating that there are no past orders available
""
Scenario: Pagination in Order History
Given the user is on the Order History page
And the user has more orders than can fit on one page
When the user navigates through the pages
Then the user should be able to view all their past orders across multiple pages
""
Scenario: Filter Orders by Date
Given the user is on the Order History page
When the user applies a date filter
Then the user should see orders that fall within the specified date range
""
Scenario: Download Invoice
Given the user is on the Order History page
When the user selects an order
And the user chooses to download the invoice
Then the invoice should be downloaded successfully
```
```gherkin
TCID:36