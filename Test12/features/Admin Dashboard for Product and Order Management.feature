Feature: Admin Dashboard for Product and Order Management
@19
Scenario: Admin adds a new product
Given an admin is logged into the dashboard
When the admin adds a new product with details like name, description, price, image, stock, and category
Then the product should be successfully added to the catalog
@19
Scenario: Admin edits an existing product
Given an admin is logged into the dashboard
And there is an existing product in the catalog
When the admin edits the product details
Then the product details should be successfully updated
@19
Scenario: Admin deletes a product
Given an admin is logged into the dashboard
And there is an existing product in the catalog
When the admin deletes the product
Then the product should be successfully removed from the catalog
@19
Scenario: Admin views all orders
Given an admin is logged into the dashboard
When the admin views all orders
Then the admin should see details like order number, customer info, and status for each order
@19
Scenario: Admin processes an order
Given an admin is logged into the dashboard
And there is an existing order
When the admin processes the order and updates its status
Then the order status should be successfully updated
@19
Scenario: System validates inputs to prevent errors
Given an admin is entering product or order details
When the admin provides invalid inputs
Then the system should display appropriate error messages
@19
Scenario: System logs admin actions for auditing
Given an admin performs actions like adding, editing, or deleting products
When the actions are completed
Then the system should log these actions for auditing purposes
@19
Scenario: System provides notifications for new orders
Given there is a new order placed
When the order is processed by the system
Then the admin should receive a notification about the new order
@19
Scenario: System provides stock alerts
Given a product's stock reaches a predefined threshold
When the system checks the stock levels
Then the admin should receive a stock alert notification
@19
Scenario: Admin dashboard access restriction
Given a user attempts to access the admin dashboard
When the user is not authorized
Then the user should be denied access to the dashboard
@19
Scenario: Authorized user accesses the admin dashboard
Given an authorized admin user
When the admin logs into the dashboard
Then the admin should be granted access to the dashboard