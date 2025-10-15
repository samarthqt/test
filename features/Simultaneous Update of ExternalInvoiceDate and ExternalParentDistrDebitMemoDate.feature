Feature: Simultaneous Update of ExternalInvoiceDate and ExternalParentDistrDebitMemoDate  
  To verify the system processes simultaneous updates to ExternalInvoiceDate and ExternalParentDistrDebitMemoDate without errors and maintains data consistency.  

  @TC-57  
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged into the system  

  @TC-57  
  Scenario: User navigates to the billing document creation screen  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the billing document creation screen  
    Then the billing document creation screen is displayed  

  @TC-57  
  Scenario: User creates an indirect sales cancellation invoice  
    Given the billing document creation screen is displayed  
    When the user creates an indirect sales cancellation invoice with billing type "S1"  
    Then the indirect sales cancellation invoice is successfully created with billing type "S1"  

  @TC-57  
  Scenario: User opens the newly created invoice in edit mode  
    Given the indirect sales cancellation invoice is successfully created  
    When the user opens the newly created invoice in edit mode  
    Then the invoice is opened in edit mode  

  @TC-57  
  Scenario Outline: User updates ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields  
    Given the invoice is opened in edit mode  
    When the user updates the ExternalInvoiceDate field to "<ExternalInvoiceDate>" and ExternalParentDistrDebitMemoDate field to "<ExternalParentDistrDebitMemoDate>"  
    Then both fields are updated with the new values  

    Examples:  
      | ExternalInvoiceDate | ExternalParentDistrDebitMemoDate |  
      | 2023-10-20         | 2023-10-21                       |  

  @TC-57  
  Scenario: User saves the changes to the invoice  
    Given both fields are updated with the new values  
    When the user saves the changes to the invoice  
    Then the changes are successfully saved without errors  

  @TC-57  
  Scenario: User verifies the updated values in the invoice  
    Given the changes are successfully saved  
    When the user verifies the updated values in the invoice  
    Then the ExternalInvoiceDate and ExternalParentDistrDebitMemoDate fields display the updated values  

  @TC-57  
  Scenario: User checks the system logs for errors or warnings  
    Given the updated values are displayed in the invoice  
    When the user checks the system logs for any errors or warnings related to the updates  
    Then no errors or warnings are logged for the updates  

  @TC-57  
  Scenario: User verifies data consistency in database tables  
    Given no errors or warnings are logged for the updates  
    When the user verifies data consistency in the relevant database tables  
    Then data in the database tables is consistent with the updated fields  

  @TC-57  
  Scenario: User checks the interface logs for data inconsistencies  
    Given data in the database tables is consistent with the updated fields  
    When the user checks the interface logs to ensure no data inconsistencies are reported  
    Then the interface logs show no data inconsistencies  

  @TC-57  
  Scenario: User validates invoice linkage to parent documents  
    Given no data inconsistencies are reported in the interface logs  
    When the user validates that the invoice is still linked correctly to its parent documents  
    Then the invoice maintains correct linkage to parent documents  

  @TC-57  
  Scenario: User generates a report to confirm updates in downstream systems  
    Given the invoice maintains correct linkage to parent documents  
    When the user generates a report to confirm the updates are reflected in downstream systems  
    Then the report confirms that the updates are accurately reflected in downstream systems