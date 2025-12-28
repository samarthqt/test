Feature: Validate default routine execution when RV60C901 is not assigned

  @TC-214
  Scenario: Ensure the user can log in to SAP S/4HANA Cloud successfully
    Given the user has valid credentials
    When the user logs in to SAP S/4HANA Cloud
    Then the user gains access to the Finance module

  @TC-214
  Scenario: Ensure the user can navigate to the Billing Document creation screen
    Given the user is logged in to SAP S/4HANA Cloud
    When the user navigates to the Billing Document creation screen
    Then the Billing Document creation screen is displayed

  @TC-214
  Scenario: Ensure the Sales Order ID is accepted without errors
    Given the user is on the Billing Document creation screen
    When the user enters the Sales Order ID "SO12345" in the relevant field
    Then the Sales Order ID is accepted without errors

  @TC-214
  Scenario: Ensure the system starts processing copy-control mappings
    Given the user has entered the Sales Order ID "SO12345"
    When the user attempts to execute the Sales Order to Billing Document copy process
    Then the system starts processing the copy-control mappings

  @TC-214
  Scenario: Ensure the system executes the default routine RV60C900
    Given the system is processing the copy-control mappings
    When the user monitors the system to identify which routine is executed
    Then the default routine RV60C900 is executed

  @TC-214
  Scenario: Ensure the system does not trigger the split logic associated with RV60C901
    Given the default routine RV60C900 is executed
    When the user verifies the system behavior
    Then the split logic associated with RV60C901 is not triggered

  @TC-214
  Scenario: Ensure the generated Billing Document is accurate
    Given the default routine RV60C900 is executed
    When the user checks the generated Billing Document
    Then the Billing Document is created successfully without errors

  @TC-214
  Scenario: Validate the document flow linkage between the Sales Order and the Billing Document
    Given the Billing Document is created successfully
    When the user validates the document flow linkage
    Then the document flow linkage is accurate and complete

  @TC-214
  Scenario: Confirm routine execution details in system logs
    Given the Billing Document is created successfully
    When the user reviews the system logs
    Then the logs indicate that RV60C900 was executed successfully

  @TC-214
  Scenario: Ensure no error messages are displayed during the process
    Given the user has executed the Sales Order to Billing Document copy process
    When the user checks for any error messages during the process
    Then no errors are displayed during the process

  @TC-214
  Scenario: Validate financial postings related to the Billing Document
    Given the Billing Document is created successfully
    When the user validates the financial postings
    Then the financial postings are accurate and complete

  @TC-214
  Scenario: Ensure compliance with business rules for Billing Document creation
    Given the Billing Document is created successfully
    When the user ensures compliance with business rules
    Then the system complies with all relevant business rules