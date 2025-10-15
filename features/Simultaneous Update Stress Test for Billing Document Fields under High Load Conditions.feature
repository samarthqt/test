Feature: Simultaneous Update Stress Test for Billing Document Fields under High Load Conditions

  @TC-59
  Scenario: User logs into the system and navigates to the billing document creation screen
    Given the user has valid credentials for the SAP S/4HANA Cloud system
    When the user logs into the system
    Then the user is successfully logged into the system
    And the billing document type "S1" is configured
    And the ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields are populated

  @TC-59
  Scenario: User sets up the test environment for high load simulation
    Given the user is on the billing document creation screen
    When the user confirms the ExternalInvoiceDate as "2023-11-01"
    And the ExternalParentDistrDebitMemoDate as "2023-11-02"
    Then the test environment is set up to simulate high load conditions

  @TC-59
  Scenario Outline: User creates multiple indirect sales cancellation invoices under high load
    Given the user is on the billing document creation screen
    When the user creates "<number_of_invoices>" indirect sales cancellation invoices with billing type "S1"
    Then "<number_of_invoices>" invoices are successfully created with billing type "S1"

    Examples:
      | number_of_invoices |
      | 10                 |
      | 50                 |

  @TC-59
  Scenario: User opens an invoice in edit mode
    Given multiple invoices are created
    When the user opens one of the newly created invoices in edit mode
    Then the invoice is opened in edit mode

  @TC-59
  Scenario Outline: User simultaneously updates ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields
    Given the user has opened an invoice in edit mode
    When the user updates the ExternalInvoiceDate field to "<new_invoice_date>"
    And the user updates the ExternalParentDistrDebitMemoDate field to "<new_parent_date>"
    Then both fields are updated with the new values

    Examples:
      | new_invoice_date | new_parent_date |
      | 2023-11-05       | 2023-11-06      |
      | 2023-11-10       | 2023-11-11      |

  @TC-59
  Scenario: User saves the changes to the invoice
    Given the user has updated the ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields
    When the user saves the changes to the invoice
    Then the changes are successfully saved without errors

  @TC-59
  Scenario: User repeats the update process for all created invoices
    Given multiple invoices are created under high load
    When the user repeats the update process for all created invoices
    Then all invoices are successfully updated without errors

  @TC-59
  Scenario: User monitors system performance during updates
    Given the user is performing updates under high load
    When the user monitors the system performance
    Then the system performance remains stable with no significant degradation

  @TC-59
  Scenario: User checks system logs for errors or warnings
    Given the user has performed updates under high load
    When the user checks the system logs for errors or warnings
    Then no errors or warnings are logged for the updates

  @TC-59
  Scenario: User verifies data consistency in database tables
    Given the user has performed updates under high load
    When the user verifies the data consistency in relevant database tables such as "VBRK" and "VBFA"
    Then the data in the database tables is consistent with the updated fields

  @TC-59
  Scenario: User validates invoice linkage to parent documents
    Given the user has performed updates under high load
    When the user validates that all invoices are still linked to their parent documents
    Then all invoices maintain correct linkage to parent documents

  @TC-59
  Scenario: User generates a report to confirm updates in downstream systems
    Given the user has performed updates under high load
    When the user generates a report to confirm the updates
    Then the report confirms that the updates are accurately reflected in downstream systems