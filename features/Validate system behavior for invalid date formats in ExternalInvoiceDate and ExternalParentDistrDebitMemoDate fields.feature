Feature: Validate system behavior for invalid date formats in ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields

  @TC-60
  Scenario Outline: Verify the system rejects updates to date fields with invalid formats
    Given the user is logged into the SAP S/4HANA Cloud system with appropriate credentials
    And the billing document type is "<BillingDocumentType>"
    And the ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields are populated
    When the user navigates to the billing document creation screen
    And the user creates an indirect sales cancellation invoice with billing type "<BillingDocumentType>"
    And the user opens the newly created invoice in edit mode
    And the user attempts to update the ExternalInvoiceDate field to "<ExternalInvoiceDate>" and the ExternalParentDistrDebitMemoDate field to "<ExternalParentDistrDebitMemoDate>"
    Then the system displays validation error messages for the invalid date formats
    And the system logs validation errors for the invalid date formats
    And the invoice retains the original values for ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields
    When the user attempts to save the invoice with the invalid updates
    Then the system prevents saving the invoice and displays error messages
    When the user corrects the date formats to "<ValidExternalInvoiceDate>" and "<ValidExternalParentDistrDebitMemoDate>" and attempts to save again
    Then the system accepts the valid updates and saves the invoice successfully

    Examples:
      | BillingDocumentType | ExternalInvoiceDate | ExternalParentDistrDebitMemoDate | ValidExternalInvoiceDate | ValidExternalParentDistrDebitMemoDate |
      | S1                  | 15-10-2023          | 16-10-2023                        | 2023-10-15              | 2023-10-16                          |

  @TC-60
  Scenario: Verify data consistency and correct linkage after saving valid updates
    Given the user has successfully saved the invoice with valid updates
    When the user verifies data consistency in the relevant database tables
    Then the data in the database tables remains consistent with the original values
    And the invoice maintains correct linkage to its parent documents

  @TC-60
  Scenario: Verify updates are reflected in downstream systems
    Given the user has successfully saved the invoice with valid updates
    When the user generates a report to confirm the updates
    Then the report confirms that the updates are accurately reflected in downstream systems