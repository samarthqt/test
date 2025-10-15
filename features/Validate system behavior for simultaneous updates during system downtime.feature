Feature: Validate system behavior for simultaneous updates during system downtime

  @TC-63
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system
    And the billing document type is set to "S1"
    And the ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields are populated in the system

  @TC-63
  Scenario: User navigates to the billing document creation screen
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the billing document creation screen
    Then the billing document creation screen is displayed
    And the ExternalInvoiceDate is set to "2023-11-15"
    And the test environment is set up to simulate system downtime

  @TC-63
  Scenario: User creates an indirect sales cancellation invoice
    Given the user is on the billing document creation screen
    When the user creates an indirect sales cancellation invoice with billing type "S1"
    Then the indirect sales cancellation invoice is successfully created
    And the ExternalParentDistrDebitMemoDate is set to "2023-11-16"

  @TC-63
  Scenario: User opens the newly created invoice in edit mode
    Given the user has created an indirect sales cancellation invoice
    When the user opens the newly created invoice in edit mode
    Then the invoice is opened in edit mode

  @TC-63
  Scenario: User simulates system downtime
    Given the user has opened the invoice in edit mode
    When the user simulates system downtime by disconnecting from the network or shutting down the server
    Then the system is in a simulated downtime state

  @TC-63
  Scenario: User attempts to update fields during system downtime
    Given the system is in a simulated downtime state
    When the user attempts to update the ExternalInvoiceDate field to "2023-11-20" 
      And the ExternalParentDistrDebitMemoDate field to "2023-11-21"
    Then the system displays error messages indicating the inability to save changes due to downtime

  @TC-63
  Scenario: User restores system connectivity
    Given the system is in a simulated downtime state
    When the user restores system connectivity or brings the server back online
    Then the system is back online and operational

  @TC-63
  Scenario: User reattempts updates after system restoration
    Given the system is back online and operational
    When the user reattempts to update the ExternalInvoiceDate field to "2023-11-20" 
      And the ExternalParentDistrDebitMemoDate field to "2023-11-21"
    Then the system successfully processes the updates without errors

  @TC-63
  Scenario: User saves the changes to the invoice
    Given the updates to the ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields are processed
    When the user saves the changes to the invoice
    Then the changes are successfully saved without errors

  @TC-63
  Scenario: User checks system logs for errors or warnings
    Given the user has saved the changes to the invoice
    When the user checks the system logs for any errors or warnings related to the downtime and updates
    Then the system logs indicate downtime but no data corruption or inconsistencies

  @TC-63
  Scenario: User verifies data consistency in the database tables
    Given the user has saved the changes to the invoice
    When the user verifies data consistency in the relevant database tables (e.g., VBRK, VBFA)
    Then the data in the database tables is consistent with the updated fields

  @TC-63
  Scenario: User generates a report to confirm updates
    Given the data in the database tables is consistent with the updated fields
    When the user generates a report to confirm the updates are reflected in downstream systems
    Then the report confirms that the updates are accurately reflected in downstream systems